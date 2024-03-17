package com.pegien.HighSchoolExamination.TimeTable.Slots.controller;


import com.pegien.HighSchoolExamination.TimeTable.Slots.TimeTableSlot;
import com.pegien.HighSchoolExamination.TimeTable.Slots.model.requests.LessonsPerDayRequest;
import com.pegien.HighSchoolExamination.TimeTable.Slots.model.requests.UpdateTimeTableSlotRequest;
import com.pegien.HighSchoolExamination.TimeTable.Slots.model.responses.LessonsPerDayResponse;
import com.pegien.HighSchoolExamination.TimeTable.Slots.service.TimeTableSlotService;
import com.pegien.HighSchoolExamination.Utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/slots")
public class TimeTableSlotController {


    @Autowired
    private TimeTableSlotService timeTableSlotService;

    @GetMapping("/lessonsPerDay")
    public ResponseEntity<LessonsPerDayResponse> getLessonsPerDay()
    {
        return timeTableSlotService.getLessonsPerDay();
    }

    @PutMapping("/lessonsPerDay")
    public ResponseEntity<String> updateLessonsPerDay(@RequestBody @Valid LessonsPerDayRequest lessonsPerDayRequest, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MyUtils.createErrorMessage(bindingResult));

        return timeTableSlotService.updateLessonsPerWeek(lessonsPerDayRequest);
    }


    @GetMapping("/listSlots")
    public ResponseEntity<TimeTableSlot[]> listSlots()
    {
        return ResponseEntity.ok(timeTableSlotService.listSlots());
    }

    @RequestMapping("/addBreak")
    public ResponseEntity<String> addBreak(@RequestParam(value = "title")String title)
    {
        return timeTableSlotService.addBreak(title);
    }

    @GetMapping("/move/{slot}/{direction}")
    public ResponseEntity<String> move(@PathVariable("slot") Long slot,@PathVariable("direction") String direction)
    {
        return timeTableSlotService.move(slot,direction);
    }


    @PutMapping("/updateSlot")
    public ResponseEntity<String> updateSlot(@RequestBody @Valid UpdateTimeTableSlotRequest updateTimeTableSlotRequest,BindingResult result)
    {
        if(result.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MyUtils.createErrorMessage(result));

        return timeTableSlotService.updateSlot(updateTimeTableSlotRequest);
    }



}
