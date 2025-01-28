package com.pegien.HighSchoolExamination.Logs.service;


import com.pegien.HighSchoolExamination.Auth.AuthService;
import com.pegien.HighSchoolExamination.Logs.Log;
import com.pegien.HighSchoolExamination.Logs.LogRepository;
import com.pegien.HighSchoolExamination.Users.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private AuthService authService;

    public void recordLog(String log)
    {
        Log myLog=Log.builder()
                .date(new Date().getTime())
                .user(authService.getActiveUser())
                .log(log)
                .build();

        logRepository.save(myLog);
    }

    public ResponseEntity<List<Log>> listLogs() {

        return ResponseEntity.ok(logRepository.findTop200LastN(200));

    }


//    private User currentUser()
//    {
//        Long userId = Long.valueOf(SecurityContextHolder.getContext().getAuthentication().getName());
//        Optional<User> optionalUser=userRepository.findById(userId);
//        if(optionalUser.isPresent()) {
//            User currUser = optionalUser.get();
//            return currUser;
//        }
//        else{
//            return null;
//        }
//    }

//    public User currentUser()
//    {
//        Long userId = ConvertionUtils.getLong(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
//        Optional<User> optionalUser=userRepository.findById(userId);
//        if(optionalUser.isPresent()) {
//            User currUser = optionalUser.get();
//            return currUser;
//        }
//        else{
//            return null;
//        }
//    }

}
