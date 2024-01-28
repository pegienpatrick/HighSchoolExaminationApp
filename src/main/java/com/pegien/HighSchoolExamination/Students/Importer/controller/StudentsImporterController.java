package com.pegien.HighSchoolExamination.Students.Importer.controller;


import com.pegien.HighSchoolExamination.Logs.service.LogService;
import com.pegien.HighSchoolExamination.Students.Student;
import com.pegien.HighSchoolExamination.Students.StudentRepository;
import com.pegien.HighSchoolExamination.enums.Gender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

@RestController
@RequestMapping("/api/v1/import")
public class StudentsImporterController {


    @Autowired
    private StudentRepository studentRepository;


    @Autowired
    private LogService logService;



    @PostMapping("/importStudents")
    public ResponseEntity<String> importStudents(@RequestParam("file") MultipartFile multipartFile)
    {
        StringBuilder errors= new StringBuilder();
        int success=0;
        try {
            Scanner s=new Scanner(multipartFile.getInputStream());
            s.nextLine();
            while(s.hasNextLine())
            {
                String line = s.nextLine();
                try {

                    String[] columns = line.split(",");
                    int adm = Integer.valueOf(columns[0].trim());
                    String name=columns[1];
                    String gender=columns[2].trim().toUpperCase();
                    Double form=Double.valueOf(columns[3].trim());
                    String stream=columns[4].trim();

                    String[] nameParts=name.split("\\s+");
                    String surname=nameParts[nameParts.length-1];
                    String firstName=nameParts.length>1?nameParts[0]:"";
                    String otherName=nameParts.length>2?nameParts[1]:"";


                    Optional<Student> student=studentRepository.findByAdmNo(adm);

                    Student student1;
                    if(student.isPresent())
                        student1=student.get();
                    else
                        student1 = new Student();

                    student1.setAdmNo(adm);
                    student1.setSurname(surname);
                    student1.setFirstName(firstName);
                    student1.setOtherName(otherName);
                    student1.setGender(Gender.valueOf(gender));
                    student1.setStage(form);
                    student1.setStream(stream);

                    studentRepository.saveAndFlush(student1);

                    success++;
                    logService.recordLog("imported Student : "+student1);
                }catch (Exception es)
                {
                    errors.append("\n student ").append(line).append(" ").append(es);
                }

            }

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error - "+e);
        }

        return ResponseEntity.ok("{imported : "+success+", errors : {"+errors+"}}");
    }



}
