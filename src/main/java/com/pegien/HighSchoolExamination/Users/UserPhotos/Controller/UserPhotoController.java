package com.pegien.HighSchoolExamination.Users.UserPhotos.Controller;


import com.pegien.HighSchoolExamination.Users.UserPhotos.service.UserPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/UserPhoto")
public class UserPhotoController {

    @Autowired
    private UserPhotoService UserPhotoService;


    @PostMapping("/uploadUserPhoto")
    public ResponseEntity<String> uploadPhoto(@RequestParam("file") MultipartFile multipartFile) {
        return UserPhotoService.upload(multipartFile);
    }


    @GetMapping("/getUserPhoto")
    public ResponseEntity<byte[]> getPhoto() {
        return UserPhotoService.download();
    }

}
