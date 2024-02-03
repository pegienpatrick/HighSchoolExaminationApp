package com.pegien.HighSchoolExamination.Teachers.model.responses;


import com.pegien.HighSchoolExamination.Teachers.SubjectTeacher;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassSubjectTeachers {

    private Double grade;

    private String stream;

    private SubjectTeacher classTeacher;

    private HashMap<String, SubjectTeacher> subjectTeachers;


}
