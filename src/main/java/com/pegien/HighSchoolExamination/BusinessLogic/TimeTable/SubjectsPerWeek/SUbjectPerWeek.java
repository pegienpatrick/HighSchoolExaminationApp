package com.pegien.HighSchoolExamination.BusinessLogic.TimeTable.SubjectsPerWeek;


import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    private Long doubleVenueId;

    @Transient
    private String doubleVenue;

    @Column(columnDefinition = "Boolean default false")
    private Boolean hasDedicatedVenue;

    @JsonIgnore
    private Long dedicatedVenueId;

    @Transient
    private String DedicatedVenues;

}
