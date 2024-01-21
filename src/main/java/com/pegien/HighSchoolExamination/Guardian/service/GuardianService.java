package com.pegien.HighSchoolExamination.Guardian.service;


import com.pegien.HighSchoolExamination.Guardian.GuardianRepository;
import com.pegien.HighSchoolExamination.enums.GuardianRelationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuardianService {

    @Autowired
    private GuardianRepository guardianRepository;



}
