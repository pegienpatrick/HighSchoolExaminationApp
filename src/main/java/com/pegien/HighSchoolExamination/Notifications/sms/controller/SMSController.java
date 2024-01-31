package com.pegien.HighSchoolExamination.Notifications.sms.controller;


import com.pegien.HighSchoolExamination.Notifications.sms.model.requests.SMSGuardiansRequest;
import com.pegien.HighSchoolExamination.Notifications.sms.service.SmsService;
import com.pegien.HighSchoolExamination.Utils.SMSUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/sms")
public class SMSController {

    @Autowired
    private SMSLogRepository smsLogRepository;


    @GetMapping("/balance")
    public ResponseEntity<String> getBalance()
    {
        return ResponseEntity.ok(SMSUtils.getBalance());
    }

    @Autowired
    private SmsService smsService;

//    @PostMapping("/")

    @GetMapping("/latest")
    public List<SMSLog> getLatestLogs() {
        return smsLogRepository.findTop200ByOrderBySentOnDesc();
    }

    @GetMapping("/countSentToday")
    public int countSentToday()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        Date dateStart = calendar.getTime();
        Long dateEnd=new Date().getTime();
        return smsLogRepository.countBySentToday(dateStart.getTime(), dateEnd);
    }

    @GetMapping("/countFailed")
    public int countFailed() {
        return smsLogRepository.countFailed();
    }

    @GetMapping("/sent")
    public List<SMSLog> getSentLogs() {
        return smsLogRepository.findTop200BySentTrueOrderByNumDesc();
    }

    @GetMapping("/failed")
    public List<SMSLog> getFailedLogs() {
        return smsLogRepository.findTop200BySentFalseAndIgnoredFalseOrderBySentOnDesc();
    }

    @GetMapping("/ignoreFailed")
    public ResponseEntity<String> ignoreFailedLogs() {
        smsLogRepository.ignoreFailed();
        return new ResponseEntity<>("Failed logs ignored successfully.", HttpStatus.OK);
    }

    @PostMapping("/smsGuardians")
    public ResponseEntity<String> smsGuardians(@RequestBody @Valid SMSGuardiansRequest smsGuardiansRequest)
    {
        if(smsGuardiansRequest.getMessage().isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No Message");
//        System.out.println(smsGuardiansRequest);
        return smsService.smsGuardians(smsGuardiansRequest);
    }

    @PostMapping("/smsClassGuardians/{stage}/{stream}")
    public ResponseEntity<String> smsClassGuardians(@RequestBody String message,@PathVariable("stage") Double stage,@PathVariable("stream") String stream){
        if(message.isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No Message");
        return smsService.smsClassGuardians(stage,stream,message);
    }







}
