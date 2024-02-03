package com.pegien.HighSchoolExamination.Teachers.controller;


import com.pegien.HighSchoolExamination.Teachers.SubjectTeacher;
import com.pegien.HighSchoolExamination.Teachers.model.responses.ClassSubjectTeachers;
import com.pegien.HighSchoolExamination.Teachers.service.SubjectTeacherService;
import com.pegien.HighSchoolExamination.Utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import javax.validation.Valid;
import java.util.HashMap;

@RestController
@RequestMapping("/api/v1/subjectTeacher")
public class SubjectTeacherController {

    @Autowired
    private SubjectTeacherService subjectTeacherService;


    @GetMapping("/viewSubjectTeachers/{grade}/{stream}")
    public ResponseEntity<ClassSubjectTeachers> getSubjectTeachers(@PathVariable("grade") Double grade,@PathVariable("stream") String stream)
    {
        return subjectTeacherService.getSubjectTeachers(grade,stream);
    }

    @PutMapping("/updateSubjectTeacher")
    public ResponseEntity<String> updateSubjectTeacher(@RequestBody @Valid SubjectTeacher subjectTeacher, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MyUtils.createErrorMessage(bindingResult));

        return subjectTeacherService.updateSubjectTeacher(subjectTeacher);
    }

    @GetMapping("/allTeachers")
    public ResponseEntity<HashMap<Long,String>> allTeachers(){
        return subjectTeacherService.allTeachers();
    }




}
