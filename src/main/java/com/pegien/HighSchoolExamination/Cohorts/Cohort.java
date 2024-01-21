package com.pegien.HighSchoolExamination.Cohorts;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cohort {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;


    @Column(unique = true)
    private int yearOfAdmission;

    private String Comment;

    private Long dateOfCreation;



}
