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


}


