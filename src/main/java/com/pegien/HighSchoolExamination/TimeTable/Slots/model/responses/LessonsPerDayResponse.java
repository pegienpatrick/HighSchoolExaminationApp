package com.pegien.HighSchoolExamination.TimeTable.Slots.model.responses;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LessonsPerDayResponse {
    private int lessons;
    private int duration;
    private int startHour;
    private int startMinute;
}
