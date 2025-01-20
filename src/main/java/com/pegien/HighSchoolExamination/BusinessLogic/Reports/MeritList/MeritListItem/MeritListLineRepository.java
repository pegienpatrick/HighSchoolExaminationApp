package com.pegien.HighSchoolExamination.BusinessLogic.Reports.MeritList.MeritListItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface MeritListLineRepository extends JpaRepository<MeritListLine,Long> {
    Optional<MeritListLine> findByStudentIdAndExamination(Long studentId, Long examination);

//    List<MeritListLine> listByStageAndExaminationOrderByClassRankAsc(Double stage,Long examination);
//
//    List<MeritListLine> listByStageAndExaminationAndStreamOrderByClassRankAsc(Double stage,Long examination,String stream);

    List<MeritListLine> findByStageAndExaminationOrderByClassRankAsc(Double stage, Long examination);

    List<MeritListLine> findByStageAndExaminationAndStreamOrderByClassRankAsc(Double stage, Long examination, String stream);

    int countByStageAndExaminationOrderByClassRankAsc(Double stage, Long examination);

    int countByStageAndExaminationAndStreamOrderByClassRankAsc(Double stage, Long examination, String stream);


    @Transactional
    void deleteByStageAndExaminationOrderByClassRankAsc(Double stage, Long examination);
}
