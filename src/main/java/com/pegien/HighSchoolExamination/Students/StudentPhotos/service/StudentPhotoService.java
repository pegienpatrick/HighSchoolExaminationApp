package com.pegien.HighSchoolExamination.Students.StudentPhotos.service;


import com.pegien.HighSchoolExamination.Students.Student;
import com.pegien.HighSchoolExamination.Students.StudentRepository;
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
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

@Service
public class StudentPhotoService {

    @Autowired
    private StudentRepository studentRepository;


    @Value("studentPhotosFolder")
    private String studentPhotosFolder;


    public ResponseEntity<String> upload(int admNo, MultipartFile multipartFile) {
        Optional<Student> optionalStudent=studentRepository.findByAdmNo(admNo);
        if(optionalStudent.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cant Find Student");

        File saveFolder=new File(studentPhotosFolder);
        try{
            if(!saveFolder.exists())
                saveFolder.mkdirs();
        }catch (Exception es)
        {
            es.printStackTrace();
        }
        try {
            File saveFile = new File(saveFolder, "Student" + optionalStudent.get().getNum());
            Files.copy(multipartFile.getInputStream(), saveFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return ResponseEntity.ok("Uploaded Successfully");
        }catch (Exception es)
        {
            return ResponseEntity.status(500).body(es.getStackTrace().toString());
        }

    }

    public ResponseEntity<byte[]> download(int admNo) {
        Optional<Student> optionalStudent=studentRepository.findByAdmNo(admNo);
        if(optionalStudent.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        File saveFolder=new File(studentPhotosFolder);
        File saveFile = new File(saveFolder, "Student" + optionalStudent.get().getNum());

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







}
