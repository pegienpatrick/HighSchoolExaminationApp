package com.pegien.HighSchoolExamination.Users.controllers;

import com.pegien.HighSchoolExamination.Users.entity.User;
import com.pegien.HighSchoolExamination.Users.Repository.UserRepository;
import com.pegien.HighSchoolExamination.Users.models.requests.*;

import com.pegien.HighSchoolExamination.Users.models.responses.LoginResponseModel;
import com.pegien.HighSchoolExamination.Users.service.UsersService;
import com.pegien.HighSchoolExamination.Utils.MyUtils;
import com.pegien.HighSchoolExamination.Users.enums.UserRoles;
import com.pegien.HighSchoolExamination.enums.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
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





    @PostMapping("/login")
    public ResponseEntity<LoginResponseModel> loginUser(@RequestBody @Valid LoginRequest loginRequest, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors()||loginRequest==null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(LoginResponseModel.builder().message(MyUtils.createErrorMessage(bindingResult)).build());

        return usersService.loginUser(loginRequest);
    }


    @PostMapping("/registerUser")
    public ResponseEntity<String> registerUser(@RequestBody @Valid RegisterUserRequest registerRequest, BindingResult bindingResult)
    {

        if(bindingResult.hasErrors()||registerRequest==null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MyUtils.createErrorMessage(bindingResult));
        else
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


    @PreAuthorize("hasAuthority('user:manage')")
    @PutMapping("/adminUpdateUser/{num}")
    public ResponseEntity<String> adminUpdateUser(@PathVariable("num") Long num,@RequestBody @Valid UpdateRequest updateRequest, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MyUtils.createErrorMessage(bindingResult));
        return usersService.updateUser(updateRequest,num);
    }

    @PreAuthorize("hasAuthority('user:manage')")
    @PutMapping("/adminUpdatePassword/{num}")
    public ResponseEntity<String> adminUpdatePassword(@PathVariable("num") Long num,@RequestBody @Valid UpdatePasswordRequest updatePasswordRequest, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MyUtils.createErrorMessage(bindingResult));
        return usersService.updatePassword(updatePasswordRequest,num);
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

    @GetMapping("/checkUser")
    public ResponseEntity<User> checkUser()
    {
        User usr=usersService.currentUser();
        if(usr==null)
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(usr);
        else
            return ResponseEntity.ok(usr);
    }



    @PreAuthorize("hasAuthority('user:view')")
    @GetMapping("/viewUser/{username}")
    public ResponseEntity<User> viewUser(@PathVariable("username") String username)
    {
        return usersService.viewUser(username);
    }

    @PreAuthorize("hasAuthority('user:view')")
    @GetMapping("/viewUserId/{num}")
    public ResponseEntity<User> viewUserByNum(@PathVariable("num") Long num)
    {
        return usersService.viewUser(num);
    }

    @PreAuthorize("hasAuthority('user:view')")
    @GetMapping("/listUsers")
    public ResponseEntity<List<User>> listUsers()
    {
        return ResponseEntity.ok(usersService.listUsers());
    }


    @PreAuthorize("hasAuthority(user:manage)")
    @GetMapping("/assignRoles/{num}")
    public ResponseEntity<String> assignUserRoles(@PathVariable("num") Long num,@RequestBody @Valid AssignRoleRequest assignRoleRequest,BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MyUtils.createErrorMessage(bindingResult));
        return usersService.assignUserRoles(num,assignRoleRequest);
    }

    @GetMapping("/allRoles")
    public ResponseEntity<HashMap> getAllRoles()
    {
        return ResponseEntity.ok(UserRoles.listAllRoles());
    }


    @GetMapping("/possibleGenders")
    public ResponseEntity<Gender[]> possibleGenders()
    {
        return ResponseEntity.ok(Gender.values());
    }

    @GetMapping("/logOut")
    public ResponseEntity<String> logOut(HttpServletRequest request)
    {
        return usersService.logOut(request);
    }


    @GetMapping("/logOutAllDevices")
    public ResponseEntity<String> logOutAllDevices()
    {
        return usersService.logOutAllDevices();
    }


}
