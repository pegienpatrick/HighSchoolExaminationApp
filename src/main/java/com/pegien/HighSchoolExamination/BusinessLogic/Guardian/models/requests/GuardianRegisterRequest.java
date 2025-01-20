package com.pegien.HighSchoolExamination.BusinessLogic.Guardian.models.requests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pegien.HighSchoolExamination.enums.Gender;
import com.pegien.HighSchoolExamination.enums.GuardianRelationship;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GuardianRegisterRequest {

    @NotNull
    private int admNo;

    @NotEmpty
    private String fullName;

    private String idNo;

    private Gender gender;

    private String phone;

    private String email;

    private GuardianRelationship relationship;

}
