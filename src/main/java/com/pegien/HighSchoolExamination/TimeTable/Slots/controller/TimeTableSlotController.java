package com.pegien.HighSchoolExamination.TimeTable.Slots.controller;


import com.pegien.HighSchoolExamination.TimeTable.Slots.service.TimeTableSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/slots")
public class TimeTableSlotController {


    @Autowired
    private TimeTableSlotService timeTableSlotService;

    public ResponseEntity<String> getLessonsPerDay()
    {
        return timeTableSlotService.getLessonsPerDay();
    }



}
