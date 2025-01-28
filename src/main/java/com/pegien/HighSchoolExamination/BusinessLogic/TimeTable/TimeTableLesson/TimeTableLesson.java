package com.pegien.HighSchoolExamination.BusinessLogic.TimeTable.TimeTableLesson;


import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Null;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TimeTableLesson {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY);
//    private Long num;

    private Long teacher;
    private Double grade;
    private String stream;
    private int subjectCode;

    private int day;
    private int lesson;
    private Double duration;

    @Nullable
    @Column(columnDefinition = "Boolean default false")
    private Boolean isDouble;

    @Nullable
    private String venue;



}
