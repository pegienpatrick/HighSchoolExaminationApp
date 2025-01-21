package com.pegien.HighSchoolExamination.BusinessLogic.Students.controllers;


import com.pegien.HighSchoolExamination.BusinessLogic.Students.entity.Student;
import com.pegien.HighSchoolExamination.BusinessLogic.Students.models.requests.PrintClassListRequest;
import com.pegien.HighSchoolExamination.BusinessLogic.Students.models.requests.StudentRegisterRequest;
import com.pegien.HighSchoolExamination.BusinessLogic.Students.models.requests.StudentUpdateRequest;
import com.pegien.HighSchoolExamination.BusinessLogic.Students.models.responses.StudentRegisterResponse;
import com.pegien.HighSchoolExamination.BusinessLogic.Students.service.StudentsService;
import com.pegien.HighSchoolExamination.Utils.MyUtils;
import com.pegien.HighSchoolExamination.enums.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {


    @Autowired
    private StudentsService studentsService;



    @PreAuthorize("hasAuthority(student:register)")
    @PostMapping("/registerStudent")
    public ResponseEntity<StudentRegisterResponse> registerStudent(@RequestBody @Valid StudentRegisterRequest studentRegisterRequest, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(StudentRegisterResponse.builder().message(MyUtils.createErrorMessage(bindingResult)).admNo(-1).build());
        return studentsService.registerStudent(studentRegisterRequest);
    }

    @GetMapping("/nextAvailableAdm")
    public ResponseEntity<Integer> nextAdm(){
        return ResponseEntity.ok(studentsService.getNextAdmission());
    }

    @PreAuthorize("hasAuthority(student:manage)")
    @PutMapping("/updateStudent/{oldAdm}")
    public ResponseEntity<String> updateStudent(@RequestBody @Valid StudentUpdateRequest studentUpdateRequest, BindingResult bindingResult, @PathVariable("oldAdm") int oldAdm)
    {
        if(bindingResult.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MyUtils.createErrorMessage(bindingResult));
        return studentsService.updateStudent(studentUpdateRequest,oldAdm);
    }

    @PreAuthorize("hasAuthority('student:view')")
    @GetMapping("/allStudents")
    public ResponseEntity<List<Student>> allStudents()
    {
        return ResponseEntity.ok(studentsService.allStudents());
    }

    @PreAuthorize("hasAuthority('student:view')")
    @GetMapping("/viewStudent/{admNo}")
    public ResponseEntity<ResponseEntity<Student>> viewStudent(@PathVariable("admNo") int admNo)
    {
        return ResponseEntity.ok(studentsService.viewStudent(admNo));
    }


    @PreAuthorize("hasAuthority('student:manage')")
    @GetMapping("/deleteStudent/{admNo}")
    public ResponseEntity<ResponseEntity<String>> deleteStudent(@PathVariable("admNo") int admNo)
    {
        return ResponseEntity.ok(studentsService.deleteStudent(admNo));
    }


    @GetMapping("/possibleGenders")
    public ResponseEntity<Gender[]> possibleGenders()
    {
        return ResponseEntity.ok(Gender.values());
    }

    @GetMapping("/listStudents")
    public ResponseEntity<List<Student>> listStudents(@RequestParam(value = "stage",required = false) String stage,@RequestParam(value = "stream",required = false) String stream)
    {
        return studentsService.listStudents(stage,stream);
    }


    @GetMapping("/exportStudents")
    public ResponseEntity<byte[]> exportStudents(@RequestParam(value = "stage",required = false) String stage,@RequestParam(value = "stream",required = false) String stream)
    {
        return studentsService.exportStudents(stage,stream);
    }

    @GetMapping("/printStudentsList")
    public ResponseEntity<byte[]> printStudentsList(@RequestParam(value = "stage",required = false) String stage, @RequestParam(value = "stream",required = false) String stream, @RequestBody @Valid PrintClassListRequest printClassListRequest,BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        return studentsService.printStudentsList(stage,stream,printClassListRequest);
    }



}
