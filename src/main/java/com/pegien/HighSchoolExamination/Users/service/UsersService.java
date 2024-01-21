package com.pegien.HighSchoolExamination.Users.service;

import com.pegien.HighSchoolExamination.Users.UserRepository;
import com.pegien.HighSchoolExamination.Users.models.requests.*;
import com.pegien.HighSchoolExamination.Users.models.requests.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private UserRepository userRepository;


    public ResponseEntity<String> registerUser(RegisterUserRequest registerRequest) {
    }

    public ResponseEntity<String> updateUser(UpdateRequest updateRequest) {
    }

    public ResponseEntity<String> updatePassword(UpdatePasswordRequest updatePasswordRequest) {
    }

    public ResponseEntity<String> emailForgotPassword(ForgotPasswordEMailRequest forgotPasswordEMailRequest) {
    }

    public ResponseEntity<String> smsForgotPassword(ForgotPasswordSmsRequest forgotPasswordSmsRequest) {
    }
}
