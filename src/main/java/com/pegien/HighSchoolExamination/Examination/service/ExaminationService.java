package com.pegien.HighSchoolExamination.Examination.service;


import com.pegien.HighSchoolExamination.Examination.Examination;
import com.pegien.HighSchoolExamination.Examination.ExaminationRepository;
import com.pegien.HighSchoolExamination.Examination.models.requests.NewExaminationRequest;
import com.pegien.HighSchoolExamination.Examination.models.responses.CreateExaminationResponse;
import com.pegien.HighSchoolExamination.Logs.service.LogService;
import com.pegien.HighSchoolExamination.Utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ExaminationService {

    @Autowired
    private ExaminationRepository examinationRepository;

    @Autowired
    private LogService logService;


    public ResponseEntity<CreateExaminationResponse> createExamination(NewExaminationRequest newExaminationRequest) {

        Examination examination= Examination.builder()
                .title(newExaminationRequest.getTitle())
                .year(newExaminationRequest.getYear())
                .term(newExaminationRequest.getTerm())
                .date(MyUtils.formatDate(new Date().getTime()))
                .build();

        examinationRepository.saveAndFlush(examination);
        CreateExaminationResponse response= CreateExaminationResponse.builder()
                .examinationId(examination.getNum())
                .message("Created Successfully")
                .build();

        logService.recordLog("Created Examination "+examination);

        return ResponseEntity.ok(response);
    }

    public ResponseEntity<List<Examination>> listExams() {
        return ResponseEntity.ok(examinationRepository.listAll());
    }

    public ResponseEntity<Examination> viewExamination(Long num) {
        Optional<Examination> optionalExamination=examinationRepository.findById(num);
        if(optionalExamination.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        else
            return ResponseEntity.ok(optionalExamination.get());

    }
}
