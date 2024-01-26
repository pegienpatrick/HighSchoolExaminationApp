package com.pegien.HighSchoolExamination.StudySubjects.SubjectsSelection.models.requests;

import com.pegien.HighSchoolExamination.StudySubjects.SubjectsSelection.SubjectSelection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubjectSelectionRequest {

    @NotNull
    private Long studentId;

    @NotNull
    private Boolean hasSelected;

    private int sciences;

    private int humanities;

    private int applied;

}
