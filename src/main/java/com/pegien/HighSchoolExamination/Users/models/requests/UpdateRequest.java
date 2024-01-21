package com.pegien.HighSchoolExamination.Users.models.requests;

import com.pegien.HighSchoolExamination.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRequest {

    private String fullname;

    private Gender gender;

    @NotEmpty(message = "Username cannot be Empty")
    private String username;

    private String email;

    private String phone;
}
