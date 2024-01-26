package com.pegien.HighSchoolExamination.StudySubjects.SubjectsSelection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class SubjectSelection {

    @Id
    private Long studentId;

    @Column(columnDefinition = "default false")
    private Boolean hasSelected;


    private int sciences;

    private int humanities;

    private int applied;

}
