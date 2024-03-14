package com.pegien.HighSchoolExamination.TimeTable.Slots;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TimeTableSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;

    private SlotType slotType;


    private int Duration;

    private int startHour;
    private int startMinute;

    private Long after;

    @Column(length = 10000)
    private String title;

    public String getStart()
    {
        return (startHour<10?"0":"")+startHour+":"+(startMinute<10?"0":"")+startMinute;
    }

    public String getEnd()
    {
        int exmin=startMinute+getDuration();
        int stopHr=startHour+((int)(exmin/60));
        int minStop=exmin%60;
        return (stopHr<10?"0":"")+stopHr+":"+(minStop<10?"0":"")+minStop;
    }


}


