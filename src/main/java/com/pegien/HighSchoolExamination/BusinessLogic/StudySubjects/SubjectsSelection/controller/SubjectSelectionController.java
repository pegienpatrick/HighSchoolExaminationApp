package com.pegien.HighSchoolExamination.BusinessLogic.StudySubjects.SubjectsSelection.controller;


import com.pegien.HighSchoolExamination.BusinessLogic.StudySubjects.StudySubject;
import com.pegien.HighSchoolExamination.BusinessLogic.StudySubjects.StudySubjectsRepository;
import com.pegien.HighSchoolExamination.BusinessLogic.StudySubjects.SubjectsSelection.models.requests.SubjectSelectionRequest;
import com.pegien.HighSchoolExamination.BusinessLogic.StudySubjects.SubjectsSelection.models.responses.SelectionSubjectsResponse;
import com.pegien.HighSchoolExamination.BusinessLogic.StudySubjects.SubjectsSelection.service.SubjectSelectionService;
import com.pegien.HighSchoolExamination.Utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v1/subjectSelection")
public class SubjectSelectionController {

    @Autowired
    private SubjectSelectionService subjectSelectionService;

    @Autowired
    private StudySubjectsRepository studySubjectsRepository;

    @GetMapping("/studentSelections")
    public ResponseEntity<List<SelectionSubjectsResponse>> studentSelections()
    {
        return ResponseEntity.ok(subjectSelectionService.selectionSubjectsResponseList());
    }


    @GetMapping("/allSubjects")
    public ResponseEntity<List<StudySubject>> allSubjects()
    {
        return ResponseEntity.ok(studySubjectsRepository.findAll());
    }

    @GetMapping("/availableSubjects")
    public ResponseEntity<List<StudySubject>> availableSubjects()
    {
        return ResponseEntity.ok(studySubjectsRepository.allAvailable());
    }

    @GetMapping("/compulsorySubjects")
    public ResponseEntity<List<StudySubject>> compulsorySubjects()
    {
        return ResponseEntity.ok(studySubjectsRepository.listCompulsory());
    }

    @GetMapping("/optionalSubjects")
    public ResponseEntity<HashMap<String, StudySubject[]>> selectionSubjects()
    {
        return ResponseEntity.ok(studySubjectsRepository.selectionOptions());
    }

    @PutMapping("/updateSelection")
    public ResponseEntity<String> updateSelection(@RequestBody @Valid SubjectSelectionRequest subjectSelectionRequest, BindingResult result)
    {
        if(result.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MyUtils.createErrorMessage(result));
        return subjectSelectionService.updateSelection(subjectSelectionRequest);
    }




}
