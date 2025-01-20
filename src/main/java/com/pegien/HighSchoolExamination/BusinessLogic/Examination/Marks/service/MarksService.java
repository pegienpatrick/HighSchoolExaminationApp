package com.pegien.HighSchoolExamination.BusinessLogic.Examination.Marks.service;


import com.pegien.HighSchoolExamination.BusinessLogic.Examination.Marks.Marks;
import com.pegien.HighSchoolExamination.BusinessLogic.Examination.Marks.MarksRepository;
import com.pegien.HighSchoolExamination.BusinessLogic.Examination.Marks.model.requests.BulkUpdateMarksRequest;
import com.pegien.HighSchoolExamination.BusinessLogic.Examination.Marks.model.requests.UpdateMarksRequest;
import com.pegien.HighSchoolExamination.BusinessLogic.Examination.Marks.model.responses.MarksSheetResponse;
import com.pegien.HighSchoolExamination.Logs.service.LogService;
import com.pegien.HighSchoolExamination.BusinessLogic.Students.entity.Student;
import com.pegien.HighSchoolExamination.BusinessLogic.Students.repository.StudentRepository;
import com.pegien.HighSchoolExamination.BusinessLogic.StudySubjects.StudySubject;
import com.pegien.HighSchoolExamination.BusinessLogic.StudySubjects.StudySubjectsRepository;
import com.pegien.HighSchoolExamination.BusinessLogic.Teachers.SubjectTeacher;
import com.pegien.HighSchoolExamination.BusinessLogic.Teachers.SubjectTeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MarksService {

    @Autowired
    private MarksRepository marksRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudySubjectsRepository studySubjectsRepository;


    @Autowired
    private LogService logService;

    @Autowired
    private SubjectTeacherRepository subjectTeacherRepository;



    public Student getStudentByNum(Long student)
    {
        Optional<Student> student1=studentRepository.findById(student);
        if(student1.isEmpty())
            throw new RuntimeException("Student not found");

        return student1.get();
    }

    public Student getStudentByAdmno(int student)
    {
        Optional<Student> student1=studentRepository.findByAdmNo(student);
        if(student1.isEmpty())
            throw new RuntimeException("Student not found");

        return student1.get();
    }

//    private Examination g



    public Marks getMark(Long student,Long examination,int subjectCode){
        Optional<Marks> optionalMarks=marksRepository.findByExaminationAndStudentIdAndSubjectCode(examination,student,subjectCode);
        if(optionalMarks.isPresent())
            return optionalMarks.get();

        Student student1=getStudentByNum(student);


        Marks marks= Marks.builder()
                .stage(student1.getStage())
                .examination(examination)
                .lastUpdate(new Date().getTime())
                .studentId(student)
                .subjectCode(subjectCode)
                .build();

        marksRepository.saveAndFlush(marks);

        return marks;
    }


    public ResponseEntity<List<MarksSheetResponse>> viewMarksSheet(Long examination, Double grade) {

        List<MarksSheetResponse> marksSheetResponses=new ArrayList<>();
        for(Student student:studentRepository.findByStage(grade))
        {
            HashMap<Integer,Marks> marks=new HashMap<>();
//            System.out.println(studySubjectsRepository.allAvailable());
            for(StudySubject i:studySubjectsRepository.allAvailable()) {
                Marks tmpMarks=getMark(student.getNum(), examination, i.getSubjectCode());
                tmpMarks.setRep(i.getSubjectRep());
                Optional<SubjectTeacher> optionalSubjectTeacher=subjectTeacherRepository.findByGradeAndStreamAndSubjectCode(grade,student.getStream(),i.getSubjectCode());
                if(optionalSubjectTeacher.isPresent())
                    tmpMarks.setSubjectTeacher(optionalSubjectTeacher.get().getTeacher());
                marks.put(i.getSubjectCode(), tmpMarks);
            }

            MarksSheetResponse marksSheetResponse=MarksSheetResponse.builder()
                    .admNo(student.getAdmNo())
                    .studentName(student.getName())
                    .examination(examination)
                    .marks(marks)
                    .form(student.getStage())
                    .stream(student.getStream())
                    .build();
            marksSheetResponses.add(marksSheetResponse);
        }
//        System.out.println(marksSheetResponses);
        return ResponseEntity.ok(marksSheetResponses);

    }


    public ResponseEntity<String> updateMarks(UpdateMarksRequest updateMarksRequest) {

        Optional<Marks> optionalMarks=marksRepository.findById(updateMarksRequest.getNum());
        if(optionalMarks.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mark not found");

        Marks marks=optionalMarks.get();
        String prevma=marks.toString();

        marks.setMarks(updateMarksRequest.getMarks());
        marks.setLastUpdate(new Date().getTime());

        marksRepository.saveAndFlush(marks);
        logService.recordLog("Entered marks from "+prevma+" to "+marks);
        return ResponseEntity.ok("Saved Successfully");
    }

    public ResponseEntity<String> updateMarks(BulkUpdateMarksRequest bulkUpdateMarksRequest) {
        StringBuilder response= new StringBuilder();
        for(UpdateMarksRequest updateMarksRequest: bulkUpdateMarksRequest.getMarksList()) {
            try {
                response.append("\n ").append(updateMarksRequest.getNum()).append(" - ").append(updateMarks(updateMarksRequest));
            } catch (Exception es) {
                response.append("\n ").append(updateMarksRequest).append(" - ").append(es);
            }
        }
        return ResponseEntity.ok(response.toString());
    }
}
