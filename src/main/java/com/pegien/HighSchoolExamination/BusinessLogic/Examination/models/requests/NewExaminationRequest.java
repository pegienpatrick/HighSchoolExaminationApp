package com.pegien.HighSchoolExamination.BusinessLogic.Examination.models.requests;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.pegien.HighSchoolExamination.BusinessLogic.Examination.ExaminationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


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


    private ExaminationType examinationType;


    private Double marksTo;

    @NotNull
    private List<Integer> grades;
}
