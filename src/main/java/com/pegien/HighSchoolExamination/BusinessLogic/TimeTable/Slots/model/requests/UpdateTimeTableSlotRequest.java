package com.pegien.HighSchoolExamination.BusinessLogic.TimeTable.Slots.model.requests;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
public class UpdateTimeTableSlotRequest {
    @NotNull
    private Long num;

    @NotNull
    @NotEmpty
    private String title;

    @NotNull
    private int duration;

}
