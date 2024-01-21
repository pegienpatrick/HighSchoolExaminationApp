package com.pegien.HighSchoolExamination.Users.service;

import com.pegien.HighSchoolExamination.Users.User;
import com.pegien.HighSchoolExamination.Users.UserRepository;
import com.pegien.HighSchoolExamination.Users.models.requests.*;
import com.pegien.HighSchoolExamination.Users.models.requests.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public ResponseEntity<String> passwordReset(ResetPasswordRequest resetPasswordRequest) {
    }

    public User currentUser()
    {
        Long userId = Long.valueOf(SecurityContextHolder.getContext().getAuthentication().getName());
        Optional<User> optionalUser=userRepository.findById(userId);
        if(optionalUser.isPresent()) {
            User currUser = optionalUser.get();
            return currUser;
        }
        else{
            return null;
        }
    }
}
