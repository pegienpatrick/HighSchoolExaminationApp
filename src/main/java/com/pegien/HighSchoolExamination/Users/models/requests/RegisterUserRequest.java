package com.pegien.HighSchoolExamination.Users.models.requests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pegien.HighSchoolExamination.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserRequest {

    private String fullname;

    @NotNull(message = "Gender cannot be null")
    private Gender gender;

    @NotEmpty(message = "Username cannot be Empty")
    private String username;

    @NotEmpty(message = "password cannot be empty")
    @Size(min = 6,message = "password must contain at least 6 characters long")
    private String password;

    private String email;

    private String phone;
}
