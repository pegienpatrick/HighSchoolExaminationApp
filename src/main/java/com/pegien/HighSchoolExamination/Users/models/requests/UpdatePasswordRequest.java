package com.pegien.HighSchoolExamination.Users.models.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UpdatePasswordRequest {

    private String oldPassword;

    @Size(min = 6,message = "password must contain at least 6 characters long")
    private String newPassword;

    private String confirmPassword;

}
