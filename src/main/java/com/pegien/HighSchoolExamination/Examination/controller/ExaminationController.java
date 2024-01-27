package com.pegien.HighSchoolExamination.Examination.controller;


import com.pegien.HighSchoolExamination.Examination.Examination;
import com.pegien.HighSchoolExamination.Examination.models.requests.NewExaminationRequest;
import com.pegien.HighSchoolExamination.Examination.models.responses.CreateExaminationResponse;
import com.pegien.HighSchoolExamination.Examination.service.ExaminationService;
import com.pegien.HighSchoolExamination.Utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/examination")
public class ExaminationController {

    @Autowired
    private ExaminationService examinationService;


    @PostMapping("/newExamination")
    public ResponseEntity<CreateExaminationResponse> createExamination(@RequestBody @Valid NewExaminationRequest newExaminationRequest, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CreateExaminationResponse(null, MyUtils.createErrorMessage(bindingResult)));

        return examinationService.createExamination(newExaminationRequest);
    }


    @GetMapping("/listExaminations")
    public ResponseEntity<List<Examination>> listExaminations(){
        return examinationService.listExams();
    }

    @GetMapping("/viewExamination/{num}")
    public ResponseEntity<Examination> viewExamination(@PathVariable("num") Long num)
    {
        return examinationService.viewExamination(num);
    }

}
