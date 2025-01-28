package com.pegien.HighSchoolExamination.Users.service;

import com.pegien.HighSchoolExamination.Auth.AuthService;
import com.pegien.HighSchoolExamination.Logs.service.LogService;
import com.pegien.HighSchoolExamination.Users.UsersHelpers.ForgotPassword.PasswordResetCode;
import com.pegien.HighSchoolExamination.Users.UsersHelpers.ForgotPassword.PasswordResetCodeRepository;
import com.pegien.HighSchoolExamination.Users.UsersHelpers.UserRoles.Utils.UserRoleUtils;
import com.pegien.HighSchoolExamination.Users.UsersHelpers.UserRoles.entity.UserRole;
import com.pegien.HighSchoolExamination.Users.UsersHelpers.UserRoles.repository.UserRolesRepository;
import com.pegien.HighSchoolExamination.Users.entity.User;
import com.pegien.HighSchoolExamination.Users.Repository.UserRepository;
import com.pegien.HighSchoolExamination.Users.models.requests.*;

import com.pegien.HighSchoolExamination.Users.models.responses.ListUserModel;
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
import javax.validation.Valid;
import java.util.*;
import java.util.concurrent.TimeUnit;

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

    @Autowired
    private UserRolesRepository userRolesRepository;


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
        Optional<User> optionalUser=userRepository.findByUsernameIgnoreCaseAndAddedTrue(forgotPasswordEMailRequest.getUsername().trim());
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
                .expiryTime(TimeUnit.MINUTES.toMillis(10))
                .build();

        passwordResetCodeRepository.save(passwordResetCode);

        String message="Your Password Reset Code is "+resetCode+" valid for "+10+" Minutes. Do not share it with anyone.";
        String subject="Exam System Password reset Code";
        EmailUtils.sendEmail(subject,message,user.getEmail().trim());

        return ResponseEntity.ok("Password ResetCode sent to email "+user.getEmail());
    }

    public ResponseEntity<String> smsForgotPassword(ForgotPasswordSmsRequest forgotPasswordSmsRequest) {
        Optional<User> optionalUser=userRepository.findByUsernameIgnoreCaseAndAddedTrue(forgotPasswordSmsRequest.getUsername().trim());
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
                .expiryTime(TimeUnit.MINUTES.toMillis(10))
                .build();

        passwordResetCodeRepository.save(passwordResetCode);

        String message="Your Password Reset Code is "+resetCode+" valid for "+10+" Minutes. Do not share it with anyone.";

        SMSUtils.sendMesage(message,user.getPhone().trim());

        return ResponseEntity.ok("Password ResetCode sent to Phone "+user.getPhone());
    }

    public ResponseEntity<String> passwordReset(ResetPasswordRequest resetPasswordRequest) {

        Optional<User> usr=userRepository.findByUsernameIgnoreCaseAndAddedTrue(resetPasswordRequest.getUsername().trim());
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

        if(user.getAdded()==null||!user.getAdded())
        {
            if(user.getUsername().equalsIgnoreCase("admin"))
            {
                user.setAdded(true);
                userRepository.saveAndFlush(user);
            } else {
                user.setAdded(false);
                userRepository.saveAndFlush(user);
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(LoginResponseModel.builder().message("User Not Authorized").build());
            }

        }

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
    private User uploadRoles(User user) {
        user.setRoles(
                UserRoleUtils.rolesMap.get(user.getRolesCategory())
        );

        List<UserRole> userRoles = userRolesRepository.findByUserId(user.getNum());
        for(UserRole r:userRoles)
            user.getRoles().add(r.getRoleName());
        return user;
    }

    public ResponseEntity<String> logOut(HttpServletRequest request) {
        return ResponseEntity.ok(authService.logOut(request));
    }

    public ResponseEntity<String> logOutAllDevices() {
        return ResponseEntity.ok(authService.logOutAllDevices());
    }

    public ResponseEntity<User> viewUser(String username) {
        Optional<User> usr=userRepository.findByUsernameIgnoreCaseAndAddedTrue(username);
        if(usr.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        else
            return ResponseEntity.ok(uploadRoles(usr.get()));
    }


    public ResponseEntity<User> viewUser(Long num) {
        Optional<User> usr=userRepository.findById(num);
        if(usr.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        else
            return ResponseEntity.ok(uploadRoles(usr.get()));
    }

    public List<User> listUsers() {
        List<User> users = userRepository.findAll();
        for(int i=0;i<users.size();i++)
            uploadRoles(users.get(i));
        return users;
    }

    public ResponseEntity<String> assignUserRoles(Long num, @Valid AssignRoleRequest assignRoleRequest) {
        Optional<User> usr=userRepository.findById(num);
        if(usr.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        User user= usr.get();
        uploadRoles(user);

        HashSet<String> toAdd=new HashSet<>();
        toAdd.addAll(assignRoleRequest.getRoles());
        for(String role: user.getRoles())
            toAdd.remove(role);


        HashSet<String> toRemove= new HashSet<>();
        toRemove.addAll(user.getRoles());
        for(String role:assignRoleRequest.getRoles())
            toRemove.remove(role);

        for(String role:toAdd)
        {
            UserRole userRole = UserRole.builder()
                    .roleName(role)
                    .userId(user.getNum())
                    .assignedOn(System.currentTimeMillis())
                    .assignedBy(authService.getActiveUser().getNum())
                    .build();
            userRolesRepository.save(userRole);
        }

        for(String role:toRemove)
        {
            Optional<UserRole> optionalUserRole = userRolesRepository.findByUserIdAndRoleName(user.getNum(),role);
            if(optionalUserRole.isPresent())
                userRolesRepository.delete(optionalUserRole.get());
        }
        return ResponseEntity.ok("Updated Successfully");
    }

    public List<ListUserModel> usersListing() {
        List<User> users = userRepository.findAllOrderByNum();

        List<ListUserModel> listing = new LinkedList<>();
        for(int i=0;i<users.size();i++) {
            User user = users.get(i);
            uploadRoles(user);

            ListUserModel listUserModel = getListUserModel(user);

            listing.add(listUserModel);
        }
        return listing;
    }

    private static ListUserModel getListUserModel(User user) {
        ListUserModel listUserModel = new ListUserModel();
        listUserModel.setNum(user.getNum());
        listUserModel.setUsername(user.getUsername());
        listUserModel.setFname(user.getFname());
        listUserModel.setGender(user.getGender());
        listUserModel.setEmail(user.getEmail());
        listUserModel.setPhone(user.getPhone());

        listUserModel.setAuthorization(((user.getAdded()!=null&& user.getAdded())?"":"Not ")+"Authorized");
        listUserModel.setRoles(user.getRoles());
        listUserModel.setUserType(user.getRolesCategory().toString());
        return listUserModel;
    }

    public ResponseEntity<ListUserModel> userListing(Long num) {
        Optional<User> usr=userRepository.findById(num);
        if(usr.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        User user = usr.get();
        uploadRoles(user);
        return ResponseEntity.ok(getListUserModel(user));
    }

    public ResponseEntity<ListUserModel> authorizeUser(Long num) {
        Optional<User> usr=userRepository.findById(num);
        if(usr.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        User user = usr.get();
        if(user.getAdded()==null||!user.getAdded()) {
            user.setAdded(true);
            user.setAddedOn(System.currentTimeMillis());
            user.setActionBy(authService.getActiveUser().getNum());
            userRepository.save(user);
        }
        uploadRoles(user);
        return ResponseEntity.ok(getListUserModel(user));
    }

    public ResponseEntity<ListUserModel> deAuthorizeUser(Long num) {
        Optional<User> usr=userRepository.findById(num);
        if(usr.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        User user = usr.get();
        if(user.getAdded()!=null&&user.getAdded()) {
            user.setAdded(false);
            user.setAddedOn(System.currentTimeMillis());
            user.setActionBy(authService.getActiveUser().getNum());
            userRepository.save(user);
        }
        uploadRoles(user);
        return ResponseEntity.ok(getListUserModel(user));
    }
}
