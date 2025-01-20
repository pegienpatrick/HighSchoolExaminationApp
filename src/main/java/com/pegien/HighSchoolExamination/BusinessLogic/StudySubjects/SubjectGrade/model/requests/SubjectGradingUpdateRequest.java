package com.pegien.HighSchoolExamination.BusinessLogic.StudySubjects.SubjectGrade.model.requests;

import com.pegien.HighSchoolExamination.BusinessLogic.StudySubjects.SubjectGrade.SubjectGrading;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubjectGradingUpdateRequest {

    @NotNull
    private List<SubjectGrading> subjectGradings;

}
