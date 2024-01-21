package com.pegien.HighSchoolExamination.Users.service;

import com.pegien.HighSchoolExamination.Auth.AuthService;
import com.pegien.HighSchoolExamination.Logs.service.LogService;
import com.pegien.HighSchoolExamination.Users.User;
import com.pegien.HighSchoolExamination.Users.UserRepository;
import com.pegien.HighSchoolExamination.Users.models.requests.*;

import com.pegien.HighSchoolExamination.Utils.ConvertionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LogService logService;

    @Autowired
    private AuthService authService;


    public ResponseEntity<String> registerUser(RegisterUserRequest registerRequest) {
        Optional<User> username=userRepository.findByUsername(registerRequest.getUsername());
        if(username.isPresent())
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already Exists");

        User user=User.builder()
                .email(registerRequest.getEmail())
                .username(registerRequest.getUsername())
                .fname(registerRequest.getFullname())
                .gender(registerRequest.getGender())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .phone(registerRequest.getPhone())
                .build();

        userRepository.saveAndFlush(user);

        logService.recordLog("Registering User : "+user);

        return ResponseEntity.ok("Registered Successfully. Go to Login");
    }

    public ResponseEntity<String> updateUser(UpdateRequest updateRequest) {
        User user=authService.getActiveUser();
        user.setEmail(updateRequest.getEmail());
        user.setFname(updateRequest.getFullname());
        user.setPhone(updateRequest.getPhone());
        user.setGender(updateRequest.getGender());
        user.setUsername(updateRequest.getUsername());
        userRepository.save(user);

        return ResponseEntity.ok("Saved Successfully");
    }

    public ResponseEntity<String> updatePassword(UpdatePasswordRequest updatePasswordRequest) {
        User user=authService.getActiveUser();
        if(!passwordEncoder.matches(updatePasswordRequest.getOldPassword(),user.getPassword()))
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Incorrect old Password");

        if(!updatePasswordRequest.getNewPassword().equals(updatePasswordRequest.getConfirmPassword()))
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Passwords dont match");

        user.setPassword(passwordEncoder.encode(updatePasswordRequest.getNewPassword()));
        userRepository.save(user);

        return ResponseEntity.ok("Updated Successfully");
    }

    public ResponseEntity<String> emailForgotPassword(ForgotPasswordEMailRequest forgotPasswordEMailRequest) {

    }

    public ResponseEntity<String> smsForgotPassword(ForgotPasswordSmsRequest forgotPasswordSmsRequest) {

    }

    public ResponseEntity<String> passwordReset(ResetPasswordRequest resetPasswordRequest) {
    }



    public ResponseEntity<String> updateUser(UpdateRequest updateRequest, Long num) {
        Optional<User> usr=userRepository.findById(num);
        if(usr.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        User user=usr.get();
        user.setEmail(updateRequest.getEmail());
        user.setFname(updateRequest.getFullname());
        user.setPhone(updateRequest.getPhone());
        user.setGender(updateRequest.getGender());
        user.setUsername(updateRequest.getUsername());
        userRepository.save(user);

        return ResponseEntity.ok("Saved Successfully");
    }

    public ResponseEntity<String> updatePassword(UpdatePasswordRequest updatePasswordRequest, Long num) {
        Optional<User> usr=userRepository.findById(num);
        if(usr.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        User user=usr.get();

        if(!passwordEncoder.matches(updatePasswordRequest.getOldPassword(),user.getPassword()))
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Incorrect old Password");

        if(!updatePasswordRequest.getNewPassword().equals(updatePasswordRequest.getConfirmPassword()))
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Passwords dont match");

        user.setPassword(passwordEncoder.encode(updatePasswordRequest.getNewPassword()));
        userRepository.save(user);

        return ResponseEntity.ok("Updated Successfully");

    }

    public ResponseEntity<String> loginUser(LoginRequest loginRequest) {

    }



}
