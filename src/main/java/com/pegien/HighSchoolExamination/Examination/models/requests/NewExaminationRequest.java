package com.pegien.HighSchoolExamination.Examination.models.requests;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewExaminationRequest {

    @NotNull
    private String Title;

    @NotNull
    private int year;

    @NotNull
    private int term;
}
