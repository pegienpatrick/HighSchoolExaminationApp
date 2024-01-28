package com.pegien.HighSchoolExamination.Reports.MeritList.service;

import com.pegien.HighSchoolExamination.Examination.ExaminationRepository;
import com.pegien.HighSchoolExamination.Examination.Marks.Marks;
import com.pegien.HighSchoolExamination.Examination.Marks.service.MarksService;
import com.pegien.HighSchoolExamination.Reports.MeritList.MeritListItem.MeritListLine;
import com.pegien.HighSchoolExamination.Reports.MeritList.MeritListItem.MeritListLineRepository;
import com.pegien.HighSchoolExamination.Students.Student;
import com.pegien.HighSchoolExamination.Students.StudentRepository;
import com.pegien.HighSchoolExamination.Students.service.StudentsService;
import com.pegien.HighSchoolExamination.StudySubjects.StudySubject;
import com.pegien.HighSchoolExamination.StudySubjects.StudySubjectsRepository;
import com.pegien.HighSchoolExamination.StudySubjects.SubjectGrade.SubjectGrading;
import com.pegien.HighSchoolExamination.StudySubjects.SubjectGrade.service.SubjectGradingService;
import com.pegien.HighSchoolExamination.Utils.GradingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MeritListService {

    @Autowired
    private MarksService marksService;

    @Autowired
    private MeritListLineRepository meritListLineRepository;

    @Autowired
    private SubjectGradingService subjectGradingService;

    @Autowired
    private ExaminationRepository examinationRepository;

    @Autowired
    private StudentsService studentsService;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudySubjectsRepository studySubjectsRepository;



    public List<MeritListLine> generateMeritList(Long examination,Double stage)
    {
        List<SubjectGrading> subjectGradings=subjectGradingService.viewGradings();
        List<Integer> pointsList=new ArrayList<>();
        List<MeritListLine> meritListLines=new ArrayList<>();
        for(Student student:studentRepository.findByStage(stage))
        {
            MeritListLine meritListLine=getMeritLine(student,examination,stage);
            //feed grades and subjects marks
            HashMap<Integer,Double> subjectMarks=new HashMap<>();
            HashMap<Integer,String> subjectGrades=new HashMap<>();
            int points=0;
            for(SubjectGrading subjectGrading:subjectGradings)
            {
                Marks marks=marksService.getMark(student.getNum(),examination,subjectGrading.getSubjectCode());
                Double mark=marks.getMarks();
                int grad= GradingUtils.getGrade(subjectGrading.getAMarks(),subjectGrading.getEMarks(),mark);
                points+=grad;
                subjectMarks.put(subjectGrading.getSubjectCode(),mark);
                subjectGrades.put(subjectGrading.getSubjectCode(),GradingUtils.gradeChar(grad));
            }
            meritListLine.setPoints(points);
            meritListLine.setAggregateGrade(GradingUtils.gradeChar(GradingUtils.agregateGrading(points)));
            meritListLine.setSubjectGrades(subjectGrades);
            meritListLine.setSubjectMarks(subjectMarks);
            pointsList.add(points);
            meritListLine.setExamination(examination);
            meritListLine.setStage(stage);
            meritListLines.add(meritListLine);
        }
        setRanks(pointsList,meritListLines);
        meritListLineRepository.saveAllAndFlush(meritListLines);
        return viewMeritList(examination,stage);
    }

    private void setRanks(List<Integer> pointsList, List<MeritListLine> meritListLines) {
//        pointsList.sort();
//        Collections.sort(pointsList, Collections.reverseOrder());
//        Collections.sort(meritListLines, Comparator.comparing(MeritListLine::getPoints));
        meritListLines.sort(Comparator.comparing(MeritListLine::getPoints, Collections.reverseOrder()));

        HashMap<String,Integer> lastStreamPosition=new HashMap<>();
        HashMap<String,Integer> lastStreamPoints=new HashMap<>();
        HashMap<String,Integer> streamCounts=new HashMap<>();

        //set last positions
//        lastStreamPosition.put("A",0);
//        lastStreamPosition.put("B",0);
//        lastStreamPosition.put("C",0);
//        //set last stream points
//        lastStreamPoints.put("A",0);
//        lastStreamPoints.put("B",0);
//        lastStreamPoints.put("C",0);

        //set positions
        int lastPosition=0;
        int lastPoints=0;
        int count=0;

        for(MeritListLine meritListLine:meritListLines)
        {
            if(meritListLine.getAggregateGrade().equalsIgnoreCase("z"))
            {
                return;
            }
            count++;
            //set class position
            if(meritListLine.getPoints()!=lastPoints)
            {
                lastPoints=meritListLine.getPoints();
                lastPosition=count;
            }
            meritListLine.setClassRank(lastPosition);
            //streamWise Rank
            String stream=meritListLine.getStream().toUpperCase().trim();
            if(!lastStreamPoints.containsKey(stream)) {
                lastStreamPoints.put(stream, 0);
                lastStreamPosition.put(stream, 0);
                streamCounts.put(stream,0);
            }


            {
                int streamCount=streamCounts.get(stream);
                streamCount++;
                int strlPoints = lastStreamPoints.get(stream);
                int strlPos=lastStreamPosition.get(stream);
                if(meritListLine.getPoints()!=strlPoints) {
                    strlPos=streamCount;
                    lastStreamPoints.put(stream,meritListLine.getPoints());
                    lastStreamPosition.put(stream,strlPos);
                    streamCounts.put(stream,streamCount);
                }
                meritListLine.setStreamRank(strlPos);
            }



        }


    }

    private MeritListLine getMeritLine(Student student, Long examination, Double stage) {

        MeritListLine meritListLine1;
        Optional<MeritListLine> meritListLine = meritListLineRepository.findByStudentIdAndExamination(student.getNum(),examination);
        if(meritListLine.isPresent())
           meritListLine1= meritListLine.get();
        else {
        meritListLine1=MeritListLine.builder()
                    .admNo(student.getAdmNo())
                    .stream(student.getStream())
                    .studentId(student.getNum())
                    .stage(stage)
                    .classRank(0).streamRank(0).points(0).kcpeMarks(0).build();
        }
        meritListLine1.setStage(student.getStage());
        meritListLine1.setStream(student.getStream());
        meritListLine1.setKcpeMarks(student.getKcpeMarks());
        meritListLine1.setAdmNo(student.getAdmNo());

        return meritListLine1;
    }


    public List<MeritListLine> viewMeritList(Long examination,Double stage)
    {
        List<MeritListLine> fullList=new ArrayList<>();
        for(MeritListLine l:meritListLineRepository.findByStageAndExaminationOrderByClassRankAsc(stage,examination))
        {
            Optional<Student> student=studentRepository.findById(l.getStudentId());
            if(student.isPresent())
            {
                Student cStudent=student.get();
                l.setStudentName(cStudent.getName());
                l.setKcpeMarks(cStudent.getKcpeMarks());
            }
            fullList.add(l);
        }

        return fullList;
    }

    public List<MeritListLine> viewMeritList(Long examination,Double stage,String stream)
    {
        List<MeritListLine> fullList=new ArrayList<>();
        for(MeritListLine l:meritListLineRepository.findByStageAndExaminationAndStreamOrderByClassRankAsc(stage,examination,stream))
        {
            Optional<Student> student=studentRepository.findById(l.getStudentId());
            if(student.isPresent())
            {
                Student cStudent=student.get();
                l.setStudentName(cStudent.getName());
                l.setKcpeMarks(cStudent.getKcpeMarks());
            }
            fullList.add(l);
        }

        return fullList;
    }




}
