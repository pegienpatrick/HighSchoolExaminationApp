package com.pegien.HighSchoolExamination.BusinessLogic.Examination.service;


import com.pegien.HighSchoolExamination.BusinessLogic.Examination.Examination;
import com.pegien.HighSchoolExamination.BusinessLogic.Examination.ExaminationRepository;
import com.pegien.HighSchoolExamination.BusinessLogic.Examination.models.requests.NewExaminationRequest;
import com.pegien.HighSchoolExamination.BusinessLogic.Examination.models.requests.UpdateExamTitleRequest;
import com.pegien.HighSchoolExamination.BusinessLogic.Examination.models.requests.UpdateReportCardMessageRequest;
import com.pegien.HighSchoolExamination.BusinessLogic.Examination.models.responses.CreateExaminationResponse;
import com.pegien.HighSchoolExamination.BusinessLogic.Examination.models.responses.Term;
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
                .deleted(false)
                .build();

        examination.setGrade(newExaminationRequest.getGrades());

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

    public ResponseEntity<List<Term>> listTerms() {
        return ResponseEntity.ok(examinationRepository.listTerms());
    }


    public ResponseEntity<List<Examination>> findTermExams(int year, int term) {
        return ResponseEntity.ok(examinationRepository.listTermExams(year,term));
    }

    public ResponseEntity<String> deleteExam(Long examinationId) {
        Optional<Examination> optionalExamination=examinationRepository.findById(examinationId);
        if(optionalExamination.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        Examination examination=optionalExamination.get();
        examination.setDeleted(true);
        examinationRepository.save(examination);
        logService.recordLog("Deleted Exam "+examination);

        return ResponseEntity.status( HttpStatus.OK ).body("Deleted Successfully");
    }

    public ResponseEntity<String> updateReportCardMessage(UpdateReportCardMessageRequest updateReportCardMessageRequest) {
        Optional<Examination> optionalExamination=examinationRepository.findById(updateReportCardMessageRequest.getExaminationId());
        if(optionalExamination.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        Examination examination=optionalExamination.get();
        String prev=examination.toString();
        examination.setReportCardMsg(updateReportCardMessageRequest.getReportCardMsg());
        examinationRepository.save(examination);
        logService.recordLog("Updated ReportCard Message from"+prev+"  to "+examination);
        return ResponseEntity.status( HttpStatus.OK ).body("Updated Successfully");
    }

    public ResponseEntity<String> updateExamTitle(UpdateExamTitleRequest updateExamTitleRequest) {
        Optional<Examination> optionalExamination=examinationRepository.findById(updateExamTitleRequest.getNum());
        if(optionalExamination.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        Examination examination=optionalExamination.get();
        String prev=examination.toString();
        examination.setTitle(updateExamTitleRequest.getTitle());
        examinationRepository.save(examination);
        logService.recordLog("Updated ReportCard Title from"+prev+"  to "+examination);
        return ResponseEntity.status( HttpStatus.OK ).body("Updated Successfully");
    }


}
