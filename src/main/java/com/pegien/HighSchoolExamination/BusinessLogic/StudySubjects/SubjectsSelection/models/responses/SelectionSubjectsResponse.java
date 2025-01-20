package com.pegien.HighSchoolExamination.BusinessLogic.StudySubjects.SubjectsSelection.models.responses;

import com.pegien.HighSchoolExamination.BusinessLogic.StudySubjects.SubjectsSelection.SubjectSelection;
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
