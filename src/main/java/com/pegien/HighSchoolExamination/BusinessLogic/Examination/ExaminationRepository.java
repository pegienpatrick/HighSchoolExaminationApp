package com.pegien.HighSchoolExamination.BusinessLogic.Examination;

import com.pegien.HighSchoolExamination.BusinessLogic.Examination.models.responses.Term;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExaminationRepository extends JpaRepository<Examination,Long> {

    @Query("select e from Examination e order by e.num desc")
    List<Examination> listAll();


    @Query("select new com.pegien.HighSchoolExamination.BusinessLogic.Examination.models.responses.Term(e.year,e.term) from Examination e where e.deleted=false  group by e.year,e.term order By e.year,e.term desc")
    List<Term> listTerms();

    @Query("select e from Examination e where e.deleted=false and e.year=?1 and e.term=?2 order by e.num desc")
    List<Examination> listTermExams(int year,int term);

    int countByDeletedFalse();
}
