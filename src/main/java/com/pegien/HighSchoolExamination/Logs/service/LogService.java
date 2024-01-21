package com.pegien.HighSchoolExamination.Logs.service;


import com.pegien.HighSchoolExamination.Logs.Log;
import com.pegien.HighSchoolExamination.Logs.LogRepository;
import com.pegien.HighSchoolExamination.Users.User;
import com.pegien.HighSchoolExamination.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Optional;

@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;

    @Autowired
    private UserRepository userRepository;


    public void recordLog(String log)
    {
        Log myLog=Log.builder()
                .date(new Date().getTime())
                .user(currentUser())
                .log(log)
                .build();

        logRepository.save(myLog);
    }


    private User currentUser()
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
