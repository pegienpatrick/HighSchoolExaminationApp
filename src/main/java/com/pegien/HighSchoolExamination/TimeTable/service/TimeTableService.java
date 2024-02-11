package com.pegien.HighSchoolExamination.TimeTable.service;


import com.pegien.HighSchoolExamination.Teachers.SubjectTeacher;
import com.pegien.HighSchoolExamination.Teachers.SubjectTeacherRepository;
import com.pegien.HighSchoolExamination.Teachers.service.SubjectTeacherService;
import com.pegien.HighSchoolExamination.TimeTable.TimeTableUtils;
import com.pegien.HighSchoolExamination.Users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

@Service
public class TimeTableService {


    @Autowired
    private SubjectTeacherRepository subjectTeacherRepository;

    @Value("timetableFolder")
    private String timetablefolder;

    @Autowired
    private SubjectTeacherService subjectTeacherService;

    public ResponseEntity<byte[]> viewClassTimeTable() {
        try {
            // Generate the PDF report
            byte[] pdfBytes = new FileInputStream(new File(timetablefolder,"classtimeTable.pdf")).readAllBytes();

            // Set the response headers
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "Class Time Table.pdf");

            return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<byte[]> viewTeachersTimeTable() {
        try {
            // Generate the PDF report
            byte[] pdfBytes = new FileInputStream(new File(timetablefolder,"TeachersTimeTable.pdf")).readAllBytes();

            // Set the response headers
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "Teachers Time Table.pdf");

            return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    public ResponseEntity<byte[]> viewVenuesTimeTable() {
        try {
            // Generate the PDF report
            byte[] pdfBytes = new FileInputStream(new File(timetablefolder,"venuesTimeTable.pdf")).readAllBytes();

            // Set the response headers
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "Venues Time Table.pdf");

            return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    public ResponseEntity<String> regenerate() {

        TimeTableUtils.subjectTeachers=new HashMap<>();
        if(TimeTableUtils.teachersName==null)
            TimeTableUtils.teachersName=new HashMap<>();
        for(SubjectTeacher t:subjectTeacherRepository.findAll())
        {
            String joint=((int)(t.getGrade()/1))+t.getStream();
            if(!TimeTableUtils.subjectTeachers.containsKey(joint))
                TimeTableUtils.subjectTeachers.put(joint,new HashMap<>());
            HashMap<Integer, Long> ctt=TimeTableUtils.subjectTeachers.get(joint);
            if(t.getIsClassTeacher())
                ctt.put(999,t.getTeacher());
            else
                ctt.put(t.getSubjectCode(),t.getTeacher());
        }
        TimeTableUtils.timetablefolder=timetablefolder;
        TimeTableUtils.teachersName=subjectTeacherService.allTeacher();
        TimeTableUtils.main(new String[]{"pats"});
        return ResponseEntity.ok("Completed Successfully");
    }
}
