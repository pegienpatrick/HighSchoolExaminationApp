package com.pegien.HighSchoolExamination.Guardian.models.requests;

import com.pegien.HighSchoolExamination.enums.Gender;
import com.pegien.HighSchoolExamination.enums.GuardianRelationship;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GuardianUpdateRequest {
    @NotEmpty
    private String fullName;

    private String idNo;

    private Gender gender;

    private String phone;

    private String email;

    private GuardianRelationship relationship;

}
