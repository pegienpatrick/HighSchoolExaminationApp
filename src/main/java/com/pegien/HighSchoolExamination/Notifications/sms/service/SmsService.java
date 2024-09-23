package com.pegien.HighSchoolExamination.Notifications.sms.service;


import com.pegien.HighSchoolExamination.Guardian.Guardian;
import com.pegien.HighSchoolExamination.Guardian.GuardianRepository;
import com.pegien.HighSchoolExamination.Notifications.sms.controller.SMSLog;
import com.pegien.HighSchoolExamination.Notifications.sms.controller.SMSLogRepository;
import com.pegien.HighSchoolExamination.Notifications.sms.model.requests.SMSGuardiansRequest;
import com.pegien.HighSchoolExamination.Students.Student;
import com.pegien.HighSchoolExamination.Students.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class SmsService {

    @Autowired
    private SMSLogRepository smsLogRepository;

    @Autowired
    private GuardianRepository guardianRepository;

    @Autowired
    private StudentRepository studentRepository;

    public ResponseEntity<String> smsGuardians(SMSGuardiansRequest smsGuardiansRequest) {

        Optional<Student> optionalStudent=studentRepository.findByAdmNo(smsGuardiansRequest.getAdmNo());
        if (optionalStudent.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student Not found");

        Student student=optionalStudent.get();

        List<Guardian> guardians=guardianRepository.findByStudent(student.getNum());
        for(Guardian guardian:guardians)
        {
            if(guardian.getPhone()!=null&&guardian.getPhone().length()>8)
            {
                SMSLog smsLog= SMSLog.builder()
                        .guardian(guardian.getFullName())
                        .phone(guardian.getPhone())
                        .student(student.getName())
                        .message(smsGuardiansRequest.getMessage())
                        .build();
                smsLog.trySending();
                smsLogRepository.save(smsLog);
            }
        }

        if(guardians.isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("No guardian Found");
        else
            return ResponseEntity.ok("Sending");
    }

    public ResponseEntity<String> smsClassGuardians(Double stage, String stream, String message) {

        List<Student> students;
        if(stream.equalsIgnoreCase("All"))
            students=studentRepository.findByStage(stage);
        else
            students=studentRepository.findByStageAndStream(stage,stream);

        for(Student student:students)
        {
            List<Guardian> guardians=guardianRepository.findByStudent(student.getNum());
            for(Guardian guardian:guardians)
            {
                if(guardian.getPhone()!=null&&guardian.getPhone().length()>8)
                {
                    SMSLog smsLog= SMSLog.builder()
                            .guardian(guardian.getFullName())
                            .phone(guardian.getPhone())
                            .student(student.getName())
                            .message(message)
                            .build();

                    executorService.submit(()->{
                        smsLog.trySending();
                        smsLogRepository.save(smsLog);
                    });
                }
            }

        }
        return ResponseEntity.ok("Sending");
    }


    private ExecutorService executorService= Executors.newCachedThreadPool();

    public ResponseEntity<String> retryFailed() {
        List<SMSLog> smsLogs=smsLogRepository.listFailed();
        for(SMSLog smsLog:smsLogs)
        {
            if(!smsLog.getSent()) {
                executorService.submit(() -> {
                    smsLog.trySending();
                    smsLogRepository.save(smsLog);
                });
            }
        }
        return ResponseEntity.ok("Retrying  ...");
    }
}
