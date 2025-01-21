package com.pegien.HighSchoolExamination.BusinessLogic.Students.Studenthelpers.StudentPhotos.Controller;


import com.pegien.HighSchoolExamination.BusinessLogic.Students.Studenthelpers.StudentPhotos.service.StudentPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/studentPhoto")
public class StudentPhotoController {

    @Autowired
    private StudentPhotoService studentPhotoService;

    @PreAuthorize("hasAuthority(student:manage)")
    @PostMapping("/uploadStudentPhoto/{admNo}")
    public ResponseEntity<String> uploadPhoto(@RequestParam("file") MultipartFile multipartFile, @PathVariable("admNo") int admNo) {
        return studentPhotoService.upload(admNo,multipartFile);
    }

    @PreAuthorize("hasAuthority(student:view)")
    @GetMapping("/getStudentPhoto/{admNo}")
    public ResponseEntity<byte[]> getPhoto(@PathVariable("admNo") int admNo) {
        return studentPhotoService.download(admNo);
    }

}
