package com.pegien.HighSchoolExamination.TimeTable.SubjectsPerWeek;


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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class SUbjectPerWeek {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;

    @NotNull
    private Double grade;

    @NotNull
    private int subjectCode;

    @NotNull
    private int lessonsPerWeek;

}
