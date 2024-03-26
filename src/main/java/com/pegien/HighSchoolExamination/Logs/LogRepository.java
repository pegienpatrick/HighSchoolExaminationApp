package com.pegien.HighSchoolExamination.Logs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Log,Long> {

    @Query("select l from Log l order by l.num desc")
    List<Log> findTop200LastN(int limit);
}
