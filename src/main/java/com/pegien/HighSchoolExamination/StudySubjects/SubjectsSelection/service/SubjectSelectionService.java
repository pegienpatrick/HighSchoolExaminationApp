package com.pegien.HighSchoolExamination.StudySubjects.SubjectsSelection.service;


import com.pegien.HighSchoolExamination.Logs.service.LogService;
import com.pegien.HighSchoolExamination.Students.Student;
import com.pegien.HighSchoolExamination.Students.StudentRepository;
import com.pegien.HighSchoolExamination.StudySubjects.SubjectsSelection.SubjectSelection;
import com.pegien.HighSchoolExamination.StudySubjects.SubjectsSelection.SubjectSelectionRepository;
import com.pegien.HighSchoolExamination.StudySubjects.SubjectsSelection.models.requests.SubjectSelectionRequest;
import com.pegien.HighSchoolExamination.StudySubjects.SubjectsSelection.models.responses.SelectionSubjectsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectSelectionService {

    @Autowired
    private SubjectSelectionRepository subjectSelectionRepository;


    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private LogService logService;



    public SubjectSelection getForStudent(Long studentId)
    {
        Optional<SubjectSelection> optionalSubjectSelection=subjectSelectionRepository.findByStudentId(studentId);
        if(optionalSubjectSelection.isPresent())
            return optionalSubjectSelection.get();
        else
        {
            SubjectSelection toSave= SubjectSelection.builder()
                                .studentId(studentId)
                                    .sciences(-1)
                                    .humanities(-1)
                                    .applied(-1)
                                    .hasSelected(false)
                                    .build();

            subjectSelectionRepository.saveAndFlush(toSave);
            return toSave;
        }
    }


    public List<SelectionSubjectsResponse> selectionSubjectsResponseList()
    {
        List<SelectionSubjectsResponse> all=new ArrayList<>();
        for(Student i: studentRepository.findAll())
            all.add(new SelectionSubjectsResponse(i.getAdmNo(),i.getName(),i.getStage(),i.getStream(),getForStudent(i.getNum())));
        return all;
    }


    public ResponseEntity<String> updateSelection(SubjectSelectionRequest subjectSelectionRequest) {
        SubjectSelection subjectSelection=getForStudent(subjectSelectionRequest.getStudentId());
        String prev=subjectSelection.toString();
        subjectSelection.setHasSelected(subjectSelectionRequest.getHasSelected());
        subjectSelection.setHumanities(subjectSelectionRequest.getHumanities());
        subjectSelection.setSciences(subjectSelectionRequest.getSciences());
        subjectSelection.setApplied(subjectSelectionRequest.getApplied());
        subjectSelectionRepository.save(subjectSelection);
        logService.recordLog("Updated subject selection from "+prev+" to "+subjectSelection);
        return ResponseEntity.ok("saved Succesfully");
    }
}
