package com.pegien.HighSchoolExamination.BusinessLogic.StudySubjects.SubjectGrade;


import com.pegien.HighSchoolExamination.BusinessLogic.StudySubjects.SubjectGrade.model.requests.SubjectGradingUpdateRequest;
import com.pegien.HighSchoolExamination.BusinessLogic.StudySubjects.SubjectGrade.model.responses.SubjectGradingResponse;
import com.pegien.HighSchoolExamination.BusinessLogic.StudySubjects.SubjectGrade.service.SubjectGradingService;
import com.pegien.HighSchoolExamination.Utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/grading")
public class SubjectGradingController {

    @Autowired
    private SubjectGradingService subjectGradingService;


    @GetMapping("/viewGradings")
    public ResponseEntity<List<SubjectGradingResponse>> allGradings()
    {
        return subjectGradingService.viewGrading();
    }

    @PutMapping("/updateGrading")
    public ResponseEntity<String> updateGradings(@RequestBody @Valid SubjectGradingUpdateRequest subjectGradingUpdateRequest, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MyUtils.createErrorMessage(bindingResult));
        return ResponseEntity.ok(subjectGradingService.update(subjectGradingUpdateRequest));
    }



}
