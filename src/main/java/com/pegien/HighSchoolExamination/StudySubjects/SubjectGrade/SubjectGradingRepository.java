package com.pegien.HighSchoolExamination.StudySubjects.SubjectGrade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SubjectGradingRepository extends JpaRepository<SubjectGrading,Integer> {


    Optional<SubjectGrading> findBySubjectCode(int subjectCode);



    @Query("select g from SubjectGrading g order by g.subjectCode asc")
    List<SubjectGrading> findAllOrderedBySubjectCode();
}
