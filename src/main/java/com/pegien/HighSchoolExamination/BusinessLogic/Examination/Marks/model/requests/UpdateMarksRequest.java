package com.pegien.HighSchoolExamination.BusinessLogic.Examination.Marks.model.requests;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UpdateMarksRequest {

    @NotNull
    private Long num;


    private Long studentId;


    private Long examination;


    private Double stage;

    @Column(nullable = true)
    private Double marks;

    private int subjectCode;

}
