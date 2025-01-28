package com.pegien.HighSchoolExamination.BusinessLogic.Guardian.controller;


import com.pegien.HighSchoolExamination.BusinessLogic.Guardian.Guardian;
import com.pegien.HighSchoolExamination.BusinessLogic.Guardian.models.requests.GuardianRegisterRequest;
import com.pegien.HighSchoolExamination.BusinessLogic.Guardian.models.requests.GuardianUpdateRequest;
import com.pegien.HighSchoolExamination.BusinessLogic.Guardian.service.GuardianService;
import com.pegien.HighSchoolExamination.Utils.MyUtils;
import com.pegien.HighSchoolExamination.enums.Gender;
import com.pegien.HighSchoolExamination.enums.GuardianRelationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/guardian")
public class GuardianController {

    @Autowired
    private GuardianService guardianService;

    @PreAuthorize("hasAuthority(student:manage)")
    @PostMapping("/addGuardian")
    public ResponseEntity<String> newGuardian(@RequestBody @Valid GuardianRegisterRequest guardianRegisterRequest, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MyUtils.createErrorMessage(bindingResult));
        return guardianService.addGuardian(guardianRegisterRequest);
    }

    @PreAuthorize("hasAuthority('student:view')")
    @GetMapping("viewGuardian/{guardianNo}")
    public ResponseEntity<Guardian> viewGuardian(@PathVariable("guardianNo") Long guardianNum)
    {
        return guardianService.viewGuardian(guardianNum);
    }

    @PreAuthorize("hasAuthority('student:view')")
    @GetMapping("viewStudentGuardians/{admNo}")
    public ResponseEntity<List<Guardian>> viewStudentGuardians(@PathVariable("admNo") int admNo)
    {
        return guardianService.viewStudentGuardians(admNo);
    }



    @PreAuthorize("hasAuthority(student:manage)")
    @PutMapping("/updateGuardian/{guardianNo}")
    public ResponseEntity<String> updateGuardian(@RequestBody @Valid GuardianUpdateRequest guardianUpdateRequest, BindingResult bindingResult, @PathVariable("guardianNo") Long guardianNo)
    {
        if(bindingResult.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MyUtils.createErrorMessage(bindingResult));
        return guardianService.updateGuardian(guardianUpdateRequest,guardianNo);
    }

    @PreAuthorize("hasAuthority('student:manage')")
    @GetMapping("deleteGuardian/{guardianNo}")
    public ResponseEntity<String> deleteGuardian(@PathVariable("guardianNo") Long guardianNum)
    {
        return guardianService.deleteGuardian(guardianNum);
    }









    @GetMapping("/possibleGenders")
    public ResponseEntity<Gender[]> possibleGenders()
    {
        return ResponseEntity.ok(Gender.values());
    }

    @GetMapping("/possibleRelations")
    public ResponseEntity<GuardianRelationship[]> possibleRelations()
    {
        return ResponseEntity.ok(GuardianRelationship.values());
    }





}
