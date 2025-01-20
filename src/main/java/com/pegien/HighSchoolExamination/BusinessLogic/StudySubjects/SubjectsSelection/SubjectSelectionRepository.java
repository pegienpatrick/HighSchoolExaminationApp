package com.pegien.HighSchoolExamination.BusinessLogic.StudySubjects.SubjectsSelection;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubjectSelectionRepository extends JpaRepository<SubjectSelection,Long> {

    Optional<SubjectSelection> findByStudentId(Long studentId);



}
