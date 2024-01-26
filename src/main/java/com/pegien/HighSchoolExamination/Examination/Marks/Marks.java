package com.pegien.HighSchoolExamination.Examination.Marks;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Marks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;

    @NotNull
    private Long student;

    @NotNull
    private Long examination;


    private Double stage;

    @Column(nullable = true)
    private Double marks;

    @NotNull
    private int subject;

    private Long lastUpdate;


}
