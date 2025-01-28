package com.pegien.HighSchoolExamination.BusinessLogic.TimeTable.Slots.model.responses;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LessonsPerDayResponse {
    private int lessons;
    private int duration;
//    private int startHour;
//    private int startMinute;
    private Time startTime;
}
