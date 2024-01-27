package com.pegien.HighSchoolExamination.Examination.models.requests;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewExaminationRequest {

    @NotEmpty
    @Size(min = 2)
    private String Title;

    @NotNull
    private int year;

    @NotNull
    private int term;
}
