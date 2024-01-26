package com.pegien.HighSchoolExamination.StudySubjects;


import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class StudySubject {

    @Id
    private Integer subjectCode;

    private String subjectName;

    private String subjectRep;


}
