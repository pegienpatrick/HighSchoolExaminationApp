package com.pegien.HighSchoolExamination.BusinessLogic.TimeTable.TimeTableLesson;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@Entity

public class CollectiveLesson {

    //    @Id
    //    @GeneratedValue(strategy = GenerationType.IDENTITY);
    //    private Long num;

    private Long teacher;
    private Double grade;
    private String stream;

    private int day;
    private int lesson;

    private TimeTableLesson[] lessons;



}
