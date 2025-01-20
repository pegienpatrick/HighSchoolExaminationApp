package com.pegien.HighSchoolExamination.BusinessLogic.Examination.Marks.controller;

import com.pegien.HighSchoolExamination.BusinessLogic.Examination.Marks.model.requests.BulkUpdateMarksRequest;
import com.pegien.HighSchoolExamination.BusinessLogic.Examination.Marks.model.requests.UpdateMarksRequest;
import com.pegien.HighSchoolExamination.BusinessLogic.Examination.Marks.model.responses.MarksSheetResponse;
import com.pegien.HighSchoolExamination.BusinessLogic.Examination.Marks.service.MarksService;
import com.pegien.HighSchoolExamination.Utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/marks")
public class MarksController {

    @Autowired
    private MarksService marksService;

    @GetMapping("/viewMarksSheet/{examination}/{grade}")
    public ResponseEntity<List<MarksSheetResponse>> viewMarkSheet(@PathVariable("examination") Long examination, @PathVariable("grade") Double grade)
    {
        return marksService.viewMarksSheet(examination,grade);
    }

    @PutMapping("/updateMarks")
    public ResponseEntity<String> updateMarks(@RequestBody @Valid UpdateMarksRequest updateMarksRequest, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MyUtils.createErrorMessage(bindingResult));
        return marksService.updateMarks(updateMarksRequest);

    }

    @PutMapping("/updateBulkMarks")
    public ResponseEntity<String> updateBulkMarks(@RequestBody @Valid BulkUpdateMarksRequest bulkUpdateMarksRequest, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MyUtils.createErrorMessage(bindingResult));
        return marksService.updateMarks(bulkUpdateMarksRequest);

    }

}
