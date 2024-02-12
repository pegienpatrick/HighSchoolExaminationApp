package com.pegien.HighSchoolExamination.Dashboard.controller;

import com.pegien.HighSchoolExamination.Dashboard.model.DashboardResponse;
import com.pegien.HighSchoolExamination.Examination.ExaminationRepository;
import com.pegien.HighSchoolExamination.Students.StudentRepository;
import com.pegien.HighSchoolExamination.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/dashboard")
public class DashboardController {

    @Autowired
    private ExaminationRepository examinationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/stats")
    public ResponseEntity<DashboardResponse> viewStats()
    {
        DashboardResponse dashboardResponse=new DashboardResponse();

        dashboardResponse.setExams(examinationRepository.countByDeletedFalse());
        dashboardResponse.setStudents((int) studentRepository.count());
        dashboardResponse.setUsers((int) userRepository.count());

        return ResponseEntity.ok(dashboardResponse);
    }
}
