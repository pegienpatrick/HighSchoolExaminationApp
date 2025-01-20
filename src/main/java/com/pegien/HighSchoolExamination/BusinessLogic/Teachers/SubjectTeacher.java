package com.pegien.HighSchoolExamination.BusinessLogic.Teachers;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class SubjectTeacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;

    private Double grade;

    private String stream;

    private int subjectCode;

    private Long teacher;

    @Column(columnDefinition = "Boolean default false")
    private Boolean isClassTeacher;

}
