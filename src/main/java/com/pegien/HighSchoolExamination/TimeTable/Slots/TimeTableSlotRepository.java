package com.pegien.HighSchoolExamination.TimeTable.Slots;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TimeTableSlotRepository extends JpaRepository<TimeTableSlot,Long> {


    @Query("select s from TimeTableSlot s order by s.num asc")
    List<TimeTableSlot> listAsc();
}
