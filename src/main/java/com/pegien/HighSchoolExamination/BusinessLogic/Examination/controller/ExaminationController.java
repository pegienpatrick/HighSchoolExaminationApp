package com.pegien.HighSchoolExamination.BusinessLogic.Examination.controller;


import com.pegien.HighSchoolExamination.BusinessLogic.Examination.Examination;
import com.pegien.HighSchoolExamination.BusinessLogic.Examination.models.requests.NewExaminationRequest;
import com.pegien.HighSchoolExamination.BusinessLogic.Examination.models.requests.UpdateExamTitleRequest;
import com.pegien.HighSchoolExamination.BusinessLogic.Examination.models.requests.UpdateReportCardMessageRequest;
import com.pegien.HighSchoolExamination.BusinessLogic.Examination.models.responses.CreateExaminationResponse;
import com.pegien.HighSchoolExamination.BusinessLogic.Examination.models.responses.Term;
import com.pegien.HighSchoolExamination.BusinessLogic.Examination.service.ExaminationService;
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

    @GetMapping("/listTerms")
    public ResponseEntity<List<Term>> listTerms(){
        return examinationService.listTerms();
    }

    @GetMapping("/listTermExaminations")
    public ResponseEntity<List<Examination>> findTermExams(@RequestParam("year") int year,@RequestParam("term") int term)
    {
        return examinationService.findTermExams(year,term);
    }

    @DeleteMapping("/delete/{examinationId}")
    public ResponseEntity<String> deleteExamination(@PathVariable("examinationId") Long examinationId)
    {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Unfortunately i fear for you");
//        return examinationService.deleteExam(examinationId);
    }


    @PutMapping("/updateReportCardMessage")
    public ResponseEntity<String> updateReportCardMsg(@RequestBody @Valid UpdateReportCardMessageRequest updateReportCardMessageRequest,BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MyUtils.createErrorMessage(bindingResult));
        return examinationService.updateReportCardMessage(updateReportCardMessageRequest);
    }


    @PutMapping("/updateExamTitle")
    public ResponseEntity<String> updateExamTitle(@RequestBody @Valid UpdateExamTitleRequest updateExamTitleRequest,BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MyUtils.createErrorMessage(bindingResult));
        return examinationService.updateExamTitle(updateExamTitleRequest);
    }



}
