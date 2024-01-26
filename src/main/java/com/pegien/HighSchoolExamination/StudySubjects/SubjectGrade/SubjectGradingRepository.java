package com.pegien.HighSchoolExamination.StudySubjects.SubjectGrade;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubjectGradingRepository extends JpaRepository<SubjectGrading,Integer> {


    Optional<SubjectGrading> findBySubjectCode(int subjectCode);


}
