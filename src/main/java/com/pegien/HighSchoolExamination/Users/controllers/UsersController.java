package com.pegien.HighSchoolExamination.Users.controllers;

import com.pegien.HighSchoolExamination.Students.models.RegisterResponse;
import com.pegien.HighSchoolExamination.Users.User;
import com.pegien.HighSchoolExamination.Users.UserRepository;
import com.pegien.HighSchoolExamination.Users.models.requests.*;

import com.pegien.HighSchoolExamination.Users.service.UsersService;
import com.pegien.HighSchoolExamination.Utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private UserRepository userRepository;


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

    @PostMapping("/passwordReset")
    public ResponseEntity<String> passwordReset(@RequestBody @Valid ResetPasswordRequest resetPasswordRequest,BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MyUtils.createErrorMessage(bindingResult));
        return usersService.passwordReset(resetPasswordRequest);
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


    @PreAuthorize("hasAuthority('user:write')")
    @PutMapping("/adminUpdateUser/{num}")
    public ResponseEntity<String> adminUpdateUser(@PathVariable("num") Long num,@RequestBody @Valid UpdateRequest updateRequest, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MyUtils.createErrorMessage(bindingResult));
        return usersService.updateUser(updateRequest);
    }

    @PreAuthorize("hasAuthority('user:write')")
    @PutMapping("/adminUpdatePassword/{num}")
    public ResponseEntity<String> adminUpdatePassword(@PathVariable("num") Long num,@RequestBody @Valid UpdatePasswordRequest updatePasswordRequest, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MyUtils.createErrorMessage(bindingResult));
        return usersService.updatePassword(updatePasswordRequest);
    }

    @GetMapping("/userInfo")
    public ResponseEntity<User> userInfo()
    {
        User usr=usersService.currentUser();
        if(usr==null)
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(usr);
        else
            return ResponseEntity.ok(usr);
    }

    @PreAuthorize("hasAuthority('user:read')")
    @GetMapping("/viewUser/{username}")
    public ResponseEntity<User> viewUser(@PathVariable("username") String username)
    {
        Optional<User> usr=userRepository.findByUsername(username);
        if(usr.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        else
            return ResponseEntity.ok(usr.get());
    }

    @PreAuthorize("hasAuthority('user:read')")
    @GetMapping("/viewUserId/{num}")
    public ResponseEntity<User> viewUserByNum(@PathVariable("num") Long num)
    {
        Optional<User> usr=userRepository.findById(num);
        if(usr.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        else
            return ResponseEntity.ok(usr.get());
    }

    @PreAuthorize("hasAuthority('user:read')")
    @GetMapping("/listUsers")
    public List<User> listUsers()
    {
        return userRepository.findAll();
    }


    @PreAuthorize("hasAuthority(user:write)")
    @GetMapping("/assignRoles/{num}")
    public ResponseEntity<String> assignUserRoles(@PathVariable("num") Long num,@RequestBody @Valid AssignRoleRequest assignRoleRequest,BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MyUtils.createErrorMessage(bindingResult));

        Optional<User> usr=userRepository.findById(num);
        if(usr.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        else
        {
            User user=usr.get();
            user.setRoles(new HashSet<>());
            user.getRoles().addAll(assignRoleRequest.getRoles());
            userRepository.save(user);
            return ResponseEntity.ok("Assigned Successfully");
        }
    }



}
