package com.pegien.HighSchoolExamination.BusinessLogic.Examination.Marks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MarksRepository extends JpaRepository<Marks,Long> {

    List<Marks> findByExaminationAndStudentId(Long examination,Long studentId);

    Optional<Marks> findByExaminationAndStudentIdAndSubjectCode(Long examination, Long studentId,int subjectCode);

    @Query("select count(*) from Marks where examination=?1 and subjectCode=?3 and stage=?2 and marks>?4 ")
    int countRank(Long examination,Double stage,int subjectCode,Double marks);


}
