package com.pegien.HighSchoolExamination.BusinessLogic.Guardian;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pegien.HighSchoolExamination.enums.Gender;
import com.pegien.HighSchoolExamination.enums.GuardianRelationship;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity

public class Guardian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;

    private String fullName;

    private String idNo;

    private Gender gender;

    private String phone;

    private String email;

    @NotNull
    @JsonIgnore
    private Long student;

    private GuardianRelationship relationship;


}
