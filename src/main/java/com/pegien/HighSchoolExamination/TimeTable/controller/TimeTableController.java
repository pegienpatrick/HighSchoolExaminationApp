package com.pegien.HighSchoolExamination.TimeTable.controller;


import com.pegien.HighSchoolExamination.TimeTable.service.TimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/api/v1/timetable")
public class TimeTableController {

  @Autowired
  private TimeTableService timeTableService;

    @GetMapping("/classTimeTable")
    public ResponseEntity<byte[]> classTimetables()
    {
       return timeTableService.viewClassTimeTable();
    }

    @GetMapping("/teachersTimeTable")
    public ResponseEntity<byte[]> teachersTimeTable()
    {
     return timeTableService.viewTeachersTimeTable();
    }

    @GetMapping("/venuesTimeTable")
    public ResponseEntity<byte[]> venuesTimeTable()
    {
     return timeTableService.viewVenuesTimeTable();
    }

    @GetMapping("/regenerate")
 public ResponseEntity<String> regenerate()
    {
     return timeTableService.regenerate();
    }


 }
