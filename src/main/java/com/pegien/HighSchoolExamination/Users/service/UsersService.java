package com.pegien.HighSchoolExamination.Users.service;

import com.pegien.HighSchoolExamination.Auth.AuthService;
import com.pegien.HighSchoolExamination.Logs.service.LogService;
import com.pegien.HighSchoolExamination.Users.ForgotPassword.PasswordResetCode;
import com.pegien.HighSchoolExamination.Users.ForgotPassword.PasswordResetCodeRepository;
import com.pegien.HighSchoolExamination.Users.User;
import com.pegien.HighSchoolExamination.Users.UserRepository;
import com.pegien.HighSchoolExamination.Users.models.requests.*;

import com.pegien.HighSchoolExamination.Users.models.responses.LoginResponseModel;
import com.pegien.HighSchoolExamination.Utils.ConvertionUtils;
import com.pegien.HighSchoolExamination.Utils.EmailUtils;
import com.pegien.HighSchoolExamination.Utils.MyUtils;
import com.pegien.HighSchoolExamination.Utils.SMSUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
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

    @Autowired
    private PasswordResetCodeRepository passwordResetCodeRepository;

    @Autowired
    private AuthenticationManager authenticationManager;


    public ResponseEntity<String> registerUser(RegisterUserRequest registerRequest) {
        Optional<User> username=userRepository.findByUsernameIgnoreCase(registerRequest.getUsername().trim());
        if(username.isPresent())
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already Exists");

        User user=User.builder()
                .email(registerRequest.getEmail())
                .username(registerRequest.getUsername().trim().trim())
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
        user.setUsername(updateRequest.getUsername().trim());
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
        Optional<User> optionalUser=userRepository.findByUsernameIgnoreCase(forgotPasswordEMailRequest.getUsername().trim());
        if(optionalUser.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Username not found");

        User user=optionalUser.get();
        if(!user.getEmail().trim().equalsIgnoreCase(forgotPasswordEMailRequest.getEmail().trim()))
            return ResponseEntity.status(HttpStatus.CONFLICT).body("email does not match with username");

        String resetCode= MyUtils.generateVerificationCode(6);

        PasswordResetCode passwordResetCode=PasswordResetCode.builder()
                .userId(user.getNum())
                .created(new Date().getTime())
                .passwordResetCode(resetCode)
                .build();

        passwordResetCodeRepository.save(passwordResetCode);

        String message="Your Password Reset Code is "+resetCode+" valid for "+10+" Minutes. Do not share it with anyone.";
        String subject="Exam System Password reset Code";
        EmailUtils.sendEmail(subject,message,user.getEmail().trim());

        return ResponseEntity.ok("Password ResetCode sent to email "+user.getEmail());
    }

    public ResponseEntity<String> smsForgotPassword(ForgotPasswordSmsRequest forgotPasswordSmsRequest) {
        Optional<User> optionalUser=userRepository.findByUsernameIgnoreCase(forgotPasswordSmsRequest.getUsername().trim());
        if(optionalUser.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Username not found");

        User user=optionalUser.get();
        if(!ConvertionUtils.formatPhone(user.getPhone().trim()).equalsIgnoreCase(ConvertionUtils.formatPhone(forgotPasswordSmsRequest.getPhone().trim())))
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Phone does not match with username");

        String resetCode= MyUtils.generateVerificationCode(6);

        PasswordResetCode passwordResetCode=PasswordResetCode.builder()
                .userId(user.getNum())
                .created(new Date().getTime())
                .passwordResetCode(resetCode)
                .build();

        passwordResetCodeRepository.save(passwordResetCode);

        String message="Your Password Reset Code is "+resetCode+" valid for "+10+" Minutes. Do not share it with anyone.";

        SMSUtils.sendMesage(message,user.getPhone().trim());

        return ResponseEntity.ok("Password ResetCode sent to Phone "+user.getPhone());
    }

    public ResponseEntity<String> passwordReset(ResetPasswordRequest resetPasswordRequest) {

        Optional<User> usr=userRepository.findByUsernameIgnoreCase(resetPasswordRequest.getUsername().trim());
        if(usr.isEmpty())
            throw new UsernameNotFoundException(resetPasswordRequest.getUsername()+" does not exist");

        User user=usr.get();

        Optional<PasswordResetCode> optionalPasswordResetCode=passwordResetCodeRepository.findResetCode(user.getNum(),resetPasswordRequest.getResetCode());
        if(optionalPasswordResetCode.isEmpty())
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Password Reset code");

        PasswordResetCode passwordResetCode=optionalPasswordResetCode.get();
        if(!passwordResetCode.isUsable())
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Expired Password Reset code");

        if(!resetPasswordRequest.getNewPassword().equals(resetPasswordRequest.getConfirmPassword()))
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Passwords dont match");

        user.setPassword(passwordEncoder.encode(resetPasswordRequest.getNewPassword()));
        userRepository.save(user);

        return ResponseEntity.ok("Password Reset Successfully");
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
        user.setUsername(updateRequest.getUsername().trim());
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

    public ResponseEntity<LoginResponseModel> loginUser(LoginRequest loginRequest) {
        Optional<User> optionalUser = userRepository.findByUsernameIgnoreCase(loginRequest.getUsername().trim());
        if (optionalUser.isEmpty())
            throw new UsernameNotFoundException("Invalid Username");

        User user = optionalUser.get();

        String authorization = authService.loginUser(user.getNum(), loginRequest.getPassword(),authenticationManager);

        LoginResponseModel loginResponseModel = LoginResponseModel.builder()
                .user(user)
                .message("Login Successful.")
                .Authorization(authorization)
                .build();

        return ResponseEntity.ok(loginResponseModel);
    }


    public User currentUser() {
        return authService.getActiveUser();
    }

    public ResponseEntity<String> logOut(HttpServletRequest request) {
        return ResponseEntity.ok(authService.logOut(request));
    }
}
