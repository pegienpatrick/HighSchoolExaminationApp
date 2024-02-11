package com.pegien.HighSchoolExamination.TimeTable.SubjectsPerWeek.controller;


import com.pegien.HighSchoolExamination.TimeTable.SubjectsPerWeek.SUbjectPerWeek;
import com.pegien.HighSchoolExamination.TimeTable.SubjectsPerWeek.service.SubjectsPerWeekService;
import com.pegien.HighSchoolExamination.Utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/subjectPerWeek")
public class SubjectPerWeekController {

    @Autowired
    private SubjectsPerWeekService subjectsPerWeekService;


    @GetMapping("/getForGrade/{grade}")
    public ResponseEntity<List<SUbjectPerWeek>> getForGrade(@PathVariable("grade") Double grade)
    {
        return subjectsPerWeekService.getForGrade(grade);
    }

    @PutMapping("/updateSubjectPerWeek")
    public ResponseEntity<String> updateSubjectPerWeek(@RequestBody @Valid SUbjectPerWeek sUbjectPerWeek, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MyUtils.createErrorMessage(bindingResult));

        return subjectsPerWeekService.updateSubjectPerWeek(sUbjectPerWeek);
    }


}
