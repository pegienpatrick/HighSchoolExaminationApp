package com.pegien.HighSchoolExamination.TimeTable.TimeTableLesson;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TimeTableLesson {

    private Long teacher;
    private Double grade;
    private String stream;
    private int subjectCode;

    private int day;
    private int lesson;
    private Double duration;



}
