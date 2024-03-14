package com.pegien.HighSchoolExamination.TimeTable.Slots;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TimeTableSlotRepository extends JpaRepository<TimeTableSlot,Long> {


}
