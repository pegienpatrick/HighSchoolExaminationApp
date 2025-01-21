package com.pegien.HighSchoolExamination.Users.models.responses;

import com.pegien.HighSchoolExamination.enums.Gender;
import lombok.Data;

import java.util.HashSet;

@Data
public class ListUserModel {
    private Long num;

    private String username;

    private String fname;

    private Gender gender;

    private String email;

    private String phone;

    private String authorization;

    private String userType;

    private HashSet<String> roles;
}
