package com.pegien.HighSchoolExamination.Users.models.responses;

import com.pegien.HighSchoolExamination.Users.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseModel {
    private User user;
    private String message;
    private String Authorization;
}