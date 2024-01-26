package com.pegien.HighSchoolExamination.Students.models.requests;

import com.pegien.HighSchoolExamination.enums.Gender;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentRegisterRequest {

    private int admNo;

    @NotEmpty(message = "Surname cannot Be Empty")
    private String surname;

    @NotEmpty(message = "First Name cannot Be Empty")
    private String firstName;

    private String otherName;

    private Date dateOfBirth;

    private String birthCertno;

    private String ifmisNo;

    @NotNull(message = "You have to select Gender")
    private Gender gender;

    private String stream;

    private Double stage;

    private int kcpeMarks;

    private int cohort;

}
