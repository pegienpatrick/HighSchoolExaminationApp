package com.pegien.HighSchoolExamination.Guardian;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pegien.HighSchoolExamination.Students.Student;
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
import java.util.List;


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

    @JsonIgnore
    private Integer students;

    private GuardianRelationship relationship;


}
