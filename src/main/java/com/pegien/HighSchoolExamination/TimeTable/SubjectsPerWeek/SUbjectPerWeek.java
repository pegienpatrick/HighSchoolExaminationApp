package com.pegien.HighSchoolExamination.TimeTable.SubjectsPerWeek;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    private String subjectName;

    @Column(columnDefinition = "Boolean default false")
    private Boolean joinStreams;

    @Column(columnDefinition = "Boolean default false")
    private Boolean hasDouble;

    private String doubleVenue;

    @Column(columnDefinition = "Boolean default false")
    private Boolean hasDedicatedVenue;

    private String DedicatedVenues;

}
