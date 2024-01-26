package com.pegien.HighSchoolExamination.StudySubjects.SubjectGrade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor


@Entity
public class SubjectGrading {

    @Id
    private int subjectCode;

    private int aMarks;

    private int eMarks;

}
