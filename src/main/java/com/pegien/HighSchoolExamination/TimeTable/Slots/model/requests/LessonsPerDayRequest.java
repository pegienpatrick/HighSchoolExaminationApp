package com.pegien.HighSchoolExamination.TimeTable.Slots.model.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LessonsPerDayRequest {
    private int lessons;
    private int duration;

    private Time startTime;
}
