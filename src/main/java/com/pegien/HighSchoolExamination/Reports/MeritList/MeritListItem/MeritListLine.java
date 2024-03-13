package com.pegien.HighSchoolExamination.Reports.MeritList.MeritListItem;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class MeritListLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;

    private int admNo;

    private Long studentId;

    private Long examination;

    @Transient
    private String studentName;


    @Transient
    private int kcpeMarks;

    private Double stage;

    private String stream;

    private int classRank;

    private int streamRank;

    private int points;

    private String aggregateGrade;

    private HashMap<Integer,Double> subjectMarks;

    private HashMap<Integer,String> subjectGrades;


}
