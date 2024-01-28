package com.pegien.HighSchoolExamination.StudySubjects.SubjectGrade.service;


import com.pegien.HighSchoolExamination.StudySubjects.StudySubject;
import com.pegien.HighSchoolExamination.StudySubjects.StudySubjectsRepository;
import com.pegien.HighSchoolExamination.StudySubjects.SubjectGrade.SubjectGrading;
import com.pegien.HighSchoolExamination.StudySubjects.SubjectGrade.SubjectGradingRepository;
import com.pegien.HighSchoolExamination.StudySubjects.SubjectGrade.model.requests.SubjectGradingUpdateRequest;
import com.pegien.HighSchoolExamination.StudySubjects.SubjectGrade.model.responses.SubjectGradingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectGradingService {

    @Autowired
    private SubjectGradingRepository subjectGradingRepository;

    @Autowired
    private StudySubjectsRepository studySubjectsRepository;


    public List<SubjectGrading> viewGradings() {
        for(StudySubject studySubject: studySubjectsRepository.allAvailable())
        {
            Optional<SubjectGrading> optionalSubjectGrading=subjectGradingRepository.findBySubjectCode(studySubject.getSubjectCode());
            if(optionalSubjectGrading.isEmpty())
                subjectGradingRepository.saveAndFlush(new SubjectGrading(studySubject.getSubjectCode(),80,29));
        }
        return subjectGradingRepository.findAll();
    }


    public ResponseEntity<List<SubjectGradingResponse>> viewGrading() {
        List<SubjectGradingResponse> subjectGradingResponses=new ArrayList<>();
        for(SubjectGrading subjectGrading:viewGradings()) {
            SubjectGradingResponse subjectGradingResponse= new SubjectGradingResponse(subjectGrading);

            StudySubject s=studySubjectsRepository.findBySubjectCode(subjectGrading.getSubjectCode());
            subjectGradingResponse.setSubjectName(s.getSubjectName());
            subjectGradingResponse.setSubjectRep(s.getSubjectRep());
            subjectGradingResponse.setAMarks(subjectGrading.getAMarks());
            subjectGradingResponse.setEMarks(subjectGrading.getEMarks());
            subjectGradingResponses.add(subjectGradingResponse);
        }
        return ResponseEntity.ok(subjectGradingResponses);
    }

    @Transactional
    public String update(SubjectGradingUpdateRequest subjectGradingUpdateRequest) {
        for(SubjectGrading subjectGrading:subjectGradingUpdateRequest.getSubjectGradings())
        {
            subjectGradingRepository.saveAndFlush(subjectGrading);
        }

        return "Updated Successfully";
    }
}
