package com.pegien.HighSchoolExamination.Users.models.requests;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor

public class LoginRequest {

    private String username;

    private String password;

}
