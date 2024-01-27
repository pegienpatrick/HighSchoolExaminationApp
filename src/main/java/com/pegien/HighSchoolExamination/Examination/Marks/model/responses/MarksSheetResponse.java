package com.pegien.HighSchoolExamination.Examination.Marks.model.responses;

import java.util.HashMap;

import com.pegien.HighSchoolExamination.Examination.Marks.Marks;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MarksSheetResponse {

    private int admNo;

    private String studentName;

    private String stream;

    private Long examination;

    private Double form;

    private HashMap<Integer,Marks> marks;

}
