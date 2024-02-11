package com.pegien.HighSchoolExamination.TimeTable.SubjectsPerWeek;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectPerWeekRepository extends JpaRepository<SUbjectPerWeek,Long> {

    List<SUbjectPerWeek> findByGrade(Double grade);

    Optional<SUbjectPerWeek> findByGradeAndSubjectCode(Double grade,int subjectCode);
}
