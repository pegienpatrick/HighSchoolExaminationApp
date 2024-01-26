package com.pegien.HighSchoolExamination.Examination;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExaminationRepository extends JpaRepository<Examination,Long> {

    @Query("select e from Examination e order by e.num desc")
    List<Examination> listAll();

}
