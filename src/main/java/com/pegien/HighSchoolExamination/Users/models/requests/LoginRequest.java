package com.pegien.HighSchoolExamination.Users.models.requests;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Required;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor

public class LoginRequest {


    @NotNull
    @NotEmpty(message = "username cannot be empty")
    private String username;

    @NotNull
    @NotEmpty(message = "password cannot be empty")
    private String password;

}
