package com.pegien.HighSchoolExamination.BusinessLogic.Examination.models.responses;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Term {

    private int year;

    private int term;

}
