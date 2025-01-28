package com.pegien.HighSchoolExamination.BusinessLogic.Guardian.service;


import com.pegien.HighSchoolExamination.BusinessLogic.Guardian.Guardian;
import com.pegien.HighSchoolExamination.BusinessLogic.Guardian.GuardianRepository;
import com.pegien.HighSchoolExamination.BusinessLogic.Guardian.models.requests.GuardianRegisterRequest;
import com.pegien.HighSchoolExamination.BusinessLogic.Guardian.models.requests.GuardianUpdateRequest;
import com.pegien.HighSchoolExamination.Logs.service.LogService;
import com.pegien.HighSchoolExamination.BusinessLogic.Students.entity.Student;
import com.pegien.HighSchoolExamination.BusinessLogic.Students.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class GuardianService {

    @Autowired
    private GuardianRepository guardianRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private LogService logService;


    public ResponseEntity<String> addGuardian(GuardianRegisterRequest guardianRegisterRequest) {

        Optional<Student> optionalStudent=studentRepository.findByAdmNo(guardianRegisterRequest.getAdmNo());
        if(optionalStudent.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student Not Found");

        Guardian guardian= Guardian.builder()
                .student(optionalStudent.get().getNum())
                .email(guardianRegisterRequest.getEmail())
                .fullName(guardianRegisterRequest.getFullName())
                .gender(guardianRegisterRequest.getGender())
                .idNo(guardianRegisterRequest.getIdNo())
                .phone(guardianRegisterRequest.getPhone())
                .relationship(guardianRegisterRequest.getRelationship())
                .build();
        guardianRepository.saveAndFlush(guardian);

        logService.recordLog("Added Guardian "+guardian);

        return ResponseEntity.ok("Guardian Saved Successfully");
    }

    public ResponseEntity<Guardian> viewGuardian(Long guardianNum) {
        Optional<Guardian> optionalGuardian=guardianRepository.findById(guardianNum);
        if(optionalGuardian.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        else
            return ResponseEntity.ok(optionalGuardian.get());
    }

    public ResponseEntity<List<Guardian>> viewStudentGuardians(int admNo) {
        Optional<Student> optionalStudent=studentRepository.findByAdmNo(admNo);
        if(optionalStudent.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        return ResponseEntity.ok(guardianRepository.findByStudent(optionalStudent.get().getNum()));
    }

    public ResponseEntity<String> updateGuardian(@Valid GuardianUpdateRequest guardianUpdateRequest, Long guardianNo) {

        Optional<Guardian> optionalGuardian=guardianRepository.findById(guardianNo);
        if(optionalGuardian.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found");

        Guardian guardian= optionalGuardian.get();

        String prevGuardian=guardian.toString();
        guardian.setEmail(guardianUpdateRequest.getEmail());
        guardian.setFullName(guardianUpdateRequest.getFullName());
        guardian.setGender(guardianUpdateRequest.getGender());
        guardian.setIdNo(guardianUpdateRequest.getIdNo());
        guardian.setPhone(guardianUpdateRequest.getPhone());
        guardian.setRelationship(guardianUpdateRequest.getRelationship());
        guardianRepository.saveAndFlush(guardian);

        logService.recordLog("Updated Guardian from "+prevGuardian+" to "+guardian.toString());

        return ResponseEntity.ok("Updated Successfully");
    }

    public ResponseEntity<String> deleteGuardian(Long guardianNum) {
        Optional<Guardian> optionalGuardian=guardianRepository.findById(guardianNum);
        if(optionalGuardian.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found");

        Guardian guardian=optionalGuardian.get();
        logService.recordLog("Deleted Guardian "+guardian);
        guardianRepository.delete(guardian);
        return ResponseEntity.ok("Deleted Successfully");
    }
}
