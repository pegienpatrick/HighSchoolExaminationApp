package com.pegien.HighSchoolExamination.Students;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    Optional<Student> findByAdmNo(int admNo);

    @Query("select max(s.admNo) from Student s")
    int maxAdm();


    List<Student> findByStage(Double grade);

}
