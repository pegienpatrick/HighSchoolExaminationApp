package com.pegien.HighSchoolExamination.BusinessLogic.Examination.models.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UpdateReportCardMessageRequest {

    @NotNull
    Long examinationId;

    @NotNull
    String reportCardMsg;
}
