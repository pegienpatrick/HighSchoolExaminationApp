package com.pegien.HighSchoolExamination.Users.models.requests;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ResetPasswordRequest {

    @NotEmpty(message = "we need the password Reset code please")
    private String resetCode;

    @Size(min = 6,message = "password must contain at least 6 characters long")
    private String newPassword;

    private String confirmPassword;
}
