package com.pegien.HighSchoolExamination.Teachers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SubjectTeacherRepository extends JpaRepository<SubjectTeacher,Long> {


    @Query("select t from SubjectTeacher t where t.grade=?1 and t.stream=?2 and t.subjectCode=?3")
    Optional<SubjectTeacher> findByGradeAndStreamAndSubjectCode(Double grade,String stream,int subjectCode);

    @Query("select t from SubjectTeacher t where t.grade=?1 and t.stream=?2 and t.isClassTeacher=true")
    Optional<SubjectTeacher> findByIsClassTeacherTrueAndGradeAndStream(Double grade,String stream);

    List<SubjectTeacher> findByTeacher(Long teacher);
}
