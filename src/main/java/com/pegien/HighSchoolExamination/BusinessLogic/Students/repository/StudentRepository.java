package com.pegien.HighSchoolExamination.BusinessLogic.Students.repository;

import com.pegien.HighSchoolExamination.BusinessLogic.Students.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    Optional<Student> findByAdmNo(int admNo);

    @Query("select max(s.admNo) from Student s")
    int maxAdm();


    List<Student> findByStage(Double grade);

    List<Student> findByStageAndStream(Double stage, String stream);

    List<Student> findByStageIn(@NotNull int[] stages);

    List<Student> findByStageInOrderByStage(@NotNull int[] stages);
}
