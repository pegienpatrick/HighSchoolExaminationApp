package com.pegien.HighSchoolExamination.Examination.Marks.service;


import com.pegien.HighSchoolExamination.Examination.Examination;
import com.pegien.HighSchoolExamination.Examination.Marks.Marks;
import com.pegien.HighSchoolExamination.Examination.Marks.MarksRepository;
import com.pegien.HighSchoolExamination.Examination.Marks.model.requests.BulkUpdateMarksRequest;
import com.pegien.HighSchoolExamination.Examination.Marks.model.requests.UpdateMarksRequest;
import com.pegien.HighSchoolExamination.Examination.Marks.model.responses.MarksSheetResponse;
import com.pegien.HighSchoolExamination.Logs.service.LogService;
import com.pegien.HighSchoolExamination.Students.Student;
import com.pegien.HighSchoolExamination.Students.StudentRepository;
import com.pegien.HighSchoolExamination.StudySubjects.StudySubject;
import com.pegien.HighSchoolExamination.StudySubjects.StudySubjectsRepository;
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



    private Student getStudentByNum(Long student)
    {
        Optional<Student> student1=studentRepository.findById(student);
        if(student1.isEmpty())
            throw new RuntimeException("Student not found");

        return student1.get();
    }

    private Student getStudentByAdmno(int student)
    {
        Optional<Student> student1=studentRepository.findByAdmNo(student);
        if(student1.isEmpty())
            throw new RuntimeException("Student not found");

        return student1.get();
    }

//    private Examination g



    private Marks getMark(Long student,Long examination,int subjectCode){
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
        for(Student student:studentRepository.findByGrade(grade))
        {
            HashMap<Integer,Marks> marks=new HashMap<>();
            for(StudySubject i:studySubjectsRepository.allAvailable())
                marks.put(i.getSubjectCode(),getMark(student.getNum(),examination,i.getSubjectCode()));

            MarksSheetResponse marksSheetResponse=MarksSheetResponse.builder()
                    .admNo(student.getAdmNo())
                    .studentName(student.getName())
                    .examination(examination)
                    .marks(marks)
                    .build();
            marksSheetResponses.add(marksSheetResponse);
        }
        return ResponseEntity.ok(marksSheetResponses);

    }


    public ResponseEntity<String> updateMarks(UpdateMarksRequest updateMarksRequest) {

        Optional<Marks> optionalMarks=marksRepository.findById(updateMarksRequest.getNum());
        if(optionalMarks.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mark not found");

        Marks marks=optionalMarks.get();
        String prevma=marks.toString();

        marks.setMarks(updateMarksRequest.getMarks());

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
