package com.pegien.HighSchoolExamination.Examination.models.requests;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateExamTitleRequest {

    @NotNull
    private Long num;

    @NotEmpty
    private String title;

}
