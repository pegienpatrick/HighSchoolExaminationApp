package com.pegien.HighSchoolExamination.Users.ForgotPassword;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor

@Entity
public class PasswordResetCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;

    private Long userId;

    private String passwordResetCode;

    private Long expiryTime= TimeUnit.MINUTES.toMillis(10);

    private Long created;

    public Boolean isUsable()
    {
        Long toExpire=created+expiryTime;
        return (new Date().before(new Date(toExpire)));
    }

}
