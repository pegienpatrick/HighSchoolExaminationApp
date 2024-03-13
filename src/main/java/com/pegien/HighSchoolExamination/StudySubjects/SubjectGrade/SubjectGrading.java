package com.pegien.HighSchoolExamination.StudySubjects.SubjectGrade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
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

    @Column(columnDefinition = "Integer default 80")
    private int aMarks;

    @Column(columnDefinition = "Integer default 29")
    private int eMarks;

}
