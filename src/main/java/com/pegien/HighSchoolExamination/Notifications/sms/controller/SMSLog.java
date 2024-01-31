package com.pegien.HighSchoolExamination.Notifications.sms.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pegien.HighSchoolExamination.Utils.MyUtils;
import com.pegien.HighSchoolExamination.Utils.SMSUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

@Entity
public class SMSLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;

    private String phone;


    @Column(length = 10000)
    private String message;

    private Boolean sent;

    @JsonIgnore
    private Long sentOn;

    private String sentDate;

    private String student;

    private String guardian;

    @Column(columnDefinition = "Boolean default false")
    private Boolean ignored;



    public void trySending()
    {
        sent=SMSUtils.sendSms(phone,message);
        if(sent)
        {
            sentOn=new Date().getTime();
            sentDate= MyUtils.formatDate(sentOn);
        }
    }

}
