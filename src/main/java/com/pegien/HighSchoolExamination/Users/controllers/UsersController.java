package com.pegien.HighSchoolExamination.Users.controllers;

import com.pegien.HighSchoolExamination.Students.models.RegisterResponse;
import com.pegien.HighSchoolExamination.Users.models.requests.*;
import com.pegien.HighSchoolExamination.Users.models.requests.RegisterRequest;
import com.pegien.HighSchoolExamination.Users.service.UsersService;
import com.pegien.HighSchoolExamination.Utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/user")
public class UsersController {

    @Autowired
    private UsersService usersService;


    @PostMapping("/registerUser")
    public ResponseEntity<String> registerUser(@RequestBody @Valid RegisterUserRequest registerRequest, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MyUtils.createErrorMessage(bindingResult));
        return usersService.registerUser(registerRequest);
    }

    @PostMapping("/emailForgotPassword")
    public ResponseEntity<String> emailForgotPassword(@RequestBody @Valid ForgotPasswordEMailRequest forgotPasswordEMailRequest, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MyUtils.createErrorMessage(bindingResult));
        return usersService.emailForgotPassword(forgotPasswordEMailRequest);
    }

    @PostMapping("/smsForgotPassword")
    public ResponseEntity<String> smsForgotPassword(@RequestBody @Valid ForgotPasswordSmsRequest forgotPasswordSmsRequest, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MyUtils.createErrorMessage(bindingResult));
        return usersService.smsForgotPassword(forgotPasswordSmsRequest);
    }




    @PutMapping("/updateUser")
    public ResponseEntity<String> updateUser(@RequestBody @Valid UpdateRequest updateRequest, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MyUtils.createErrorMessage(bindingResult));
        return usersService.updateUser(updateRequest);
    }

    @PutMapping("/updatePassword")
    public ResponseEntity<String> updatePassword(@RequestBody @Valid UpdatePasswordRequest updatePasswordRequest, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MyUtils.createErrorMessage(bindingResult));
        return usersService.updatePassword(updatePasswordRequest);
    }















}
