package com.pegien.HighSchoolExamination.Students.service;

import com.pegien.HighSchoolExamination.Guardian.service.GuardianService;
import com.pegien.HighSchoolExamination.Students.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentsService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private GuardianService guardianService;





}
