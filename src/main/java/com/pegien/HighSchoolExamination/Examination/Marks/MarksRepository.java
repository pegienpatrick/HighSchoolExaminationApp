package com.pegien.HighSchoolExamination.Examination.Marks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MarksRepository extends JpaRepository<Marks,Long> {

    List<Marks> findByExaminationAndStudentId(Long examination,Long studentId);

    Optional<Marks> findByExaminationAndStudentIdAndSubjectCode(Long examination, Long studentId,int subjectCode);


}
