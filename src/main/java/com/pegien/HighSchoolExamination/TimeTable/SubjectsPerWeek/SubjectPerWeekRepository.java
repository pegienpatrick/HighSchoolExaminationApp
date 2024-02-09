package com.pegien.HighSchoolExamination.TimeTable.SubjectsPerWeek;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubjectPerWeekRepository extends JpaRepository<SUbjectPerWeek,Long> {

    List<SUbjectPerWeek> findByGrade(Double grade);

    Optional<SUbjectPerWeek> findByGradeAndSubjectCode();
}
