package com.pegien.HighSchoolExamination.Teachers;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubjectTeacherRepository extends JpaRepository<SubjectTeacher,Long> {



    Optional<SubjectTeacher> findByGradeAndStreamAndSubjectCode(Double grade,String stream,int subjectCode);

    Optional<SubjectTeacher> findByIsClassTeacherTrueAndGradeAndStream(Double grade,String stream);

    List<SubjectTeacher> findByTeacher(Long teacher);
}
