package com.pegien.HighSchoolExamination.TimeTable.TimeTableLesson;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.lang.reflect.Array;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity

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
