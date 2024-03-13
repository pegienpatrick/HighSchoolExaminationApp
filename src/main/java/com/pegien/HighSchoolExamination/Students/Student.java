package com.pegien.HighSchoolExamination.Students;


import com.pegien.HighSchoolExamination.Cohorts.Cohort;
import com.pegien.HighSchoolExamination.Guardian.Guardian;
import com.pegien.HighSchoolExamination.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;

    @Column(unique = true)
    private int admNo;

    private String surname;

    private String firstName;

    private String otherName;

    private Long dateOfBirth;

    private String birthCertno;

    private String ifmisNo;

    private Gender gender;

    private String stream;

    private Double stage;

    private Long dateOfAdm;

    private Long leaveDate;

    private int kcpeMarks;

    private int cohort;


    @ManyToMany
    private List<Guardian> guardians;


    private String reserved;

    public String getName() {
        return getSurname().toUpperCase()+", "+firstName+" "+otherName;
    }


//    private List<Integer> subjects;



}
