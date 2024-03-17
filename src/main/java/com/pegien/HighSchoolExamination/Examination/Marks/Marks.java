package com.pegien.HighSchoolExamination.Examination.Marks;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.internal.IgnoreForbiddenApisErrors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Marks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;

    @NotNull
    private Long studentId;

    @NotNull
    private Long examination;


    private Double stage;

    @Column(nullable = true)
    private Double marks;

    @NotNull
    private int subjectCode;

    private Long lastUpdate;

    @Transient
    private String rep;

    @Transient
    private Long subjectTeacher;


}
