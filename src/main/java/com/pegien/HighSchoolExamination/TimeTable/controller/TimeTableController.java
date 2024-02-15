package com.pegien.HighSchoolExamination.TimeTable.controller;


import com.pegien.HighSchoolExamination.TimeTable.service.TimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @PostMapping("/setSpecializedGrades")
    public ResponseEntity<String> setSpecializedGrades(@RequestBody @Valid Integer[] specialized)
    {
        return timeTableService.setSpecializedGrades(specialized);
    }

    @GetMapping("/getSpecializedGrades")
    public ResponseEntity<Integer[]> getSpecializedGrades()
    {
        return timeTableService.getSpecializedgrades();
    }





 }
