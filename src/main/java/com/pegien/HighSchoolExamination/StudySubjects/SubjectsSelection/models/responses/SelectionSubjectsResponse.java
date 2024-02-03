package com.pegien.HighSchoolExamination.StudySubjects.SubjectsSelection.models.responses;

import com.pegien.HighSchoolExamination.StudySubjects.SubjectsSelection.SubjectSelection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SelectionSubjectsResponse {

    private int admNo;

    private String studentName;

    private Double form;

    private String stream;

    private SubjectSelection subjectSelection;

}
