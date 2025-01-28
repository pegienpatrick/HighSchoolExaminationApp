package com.pegien.HighSchoolExamination.Users.UsersHelpers.UserPhotos.service;


import com.pegien.HighSchoolExamination.Auth.AuthService;
import com.pegien.HighSchoolExamination.Users.entity.User;
import com.pegien.HighSchoolExamination.Users.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

@Service
public class UserPhotoService {

    @Autowired
    private UserRepository UserRepository;

    @Autowired
    private AuthService authService;


    @Value("UserPhotosFolder")
    private String UserPhotosFolder;


    public ResponseEntity<String> upload(MultipartFile multipartFile) {
        File saveFolder=new File(UserPhotosFolder);
        try{
            if(!saveFolder.exists())
                saveFolder.mkdirs();
        }catch (Exception es)
        {
            es.printStackTrace();
        }
        try {
            File saveFile = new File(saveFolder, "User" + authService.getActiveUser().getNum());
            Files.copy(multipartFile.getInputStream(), saveFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return ResponseEntity.ok("Uploaded Successfully");
        }catch (Exception es)
        {
            return ResponseEntity.status(500).body(es.getStackTrace().toString());
        }

    }

    public ResponseEntity<byte[]> download() {

        File saveFolder=new File(UserPhotosFolder);
        File saveFile = new File(saveFolder, "User" +authService.getActiveUser().getNum());

        try {
            byte[] imageBytes;
            if (saveFile.exists())
                imageBytes = new FileInputStream(saveFile).readAllBytes();

            else
                imageBytes=getClass().getResourceAsStream("/defaultPerson/default.png").readAllBytes();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_PNG);
            String fileName = saveFile.exists()?saveFile.getName():"default";
            headers.setContentDispositionFormData("attachment", fileName+".png");

            return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
        }catch (Exception es)
        {
            es.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }


    public File getUserImage(Long userId)
    {
        Optional<User> optionalUser=UserRepository.findById(userId);
        if(optionalUser.isEmpty())
           return (null);
        File saveFolder=new File(UserPhotosFolder);
        File saveFile = new File(saveFolder, "User" + userId);
        if(saveFile.exists())
            return saveFile;
        else
            return new File(getClass().getResource("/defaultPerson/default.png").getFile());
    }







}
