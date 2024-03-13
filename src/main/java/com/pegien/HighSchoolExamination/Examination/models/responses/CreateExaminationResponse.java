package com.pegien.HighSchoolExamination.Examination.models.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CreateExaminationResponse {
    private Long examinationId;
    private String message;
}
