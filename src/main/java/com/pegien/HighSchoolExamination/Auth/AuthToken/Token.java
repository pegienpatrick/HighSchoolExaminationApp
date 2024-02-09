package com.pegien.HighSchoolExamination.Auth.AuthToken;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor

@Entity
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;

    @Column(unique = true)
    private String value;

    private Long lastAccess;

    @Column(columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean loggedOut;

    private Long inActiveTime= TimeUnit.MINUTES.toMillis(10);

    public Boolean isUsable()
    {
        Long expiryTime=lastAccess+inActiveTime;
        return (!loggedOut&&new Date().before(new Date(expiryTime)));
    }

    private Long userId;


}
