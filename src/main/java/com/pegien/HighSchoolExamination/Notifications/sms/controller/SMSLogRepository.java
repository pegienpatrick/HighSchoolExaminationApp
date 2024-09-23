package com.pegien.HighSchoolExamination.Notifications.sms.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SMSLogRepository extends JpaRepository<SMSLog,Long> {



    List<SMSLog> findTop200ByOrderByNumDesc();

    @Query("select count(*) from SMSLog where sent=true and sentOn>?1 and sentOn<?2")
    int countBySentToday(Long dateStart,Long dateEnd);

    @Query("select count(*) from SMSLog where sent=false and (ignored=false or ignored is null)")
    int countFailed();

//    @Query("select count(*) from SMSLog where sent=true order by sentOn desc")
//    List<SMSLog> findSent();
    List<SMSLog> findTop200BySentTrueOrderBySentOnDesc();

//    @Query("select count(*) from SMSLog where sent=false and ignored=false order by sentOn desc having (rank() over(order by sentOn))<200")
//    List<SMSLog> findFailed();

    List<SMSLog> findTop200BySentFalseAndIgnoredFalseOrderBySentOnDesc();


    @Transactional
    @Modifying
    @Query("update SMSLog set ignored=true where sent=false")
    void ignoreFailed();

    @Query("select s from SMSLog s where sent=false and (ignored=false or ignored is null)")
    List<SMSLog> listFailed();


}
