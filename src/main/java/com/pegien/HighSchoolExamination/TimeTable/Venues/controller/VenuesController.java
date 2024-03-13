package com.pegien.HighSchoolExamination.TimeTable.Venues.controller;


import com.pegien.HighSchoolExamination.TimeTable.Venues.Venue;
import com.pegien.HighSchoolExamination.TimeTable.Venues.service.VenueService;
import com.pegien.HighSchoolExamination.Utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController

@RequestMapping("/api/v1/venue")
public class VenuesController {

    @Autowired
    private VenueService venueService;

    @GetMapping("/listVenues")
    public ResponseEntity<List<Venue>> listVenues()
    {
        return venueService.listVenues();
    }

    @PutMapping("/updateVenue")
    public ResponseEntity<String> updateVenue(@RequestBody @Valid Venue venue, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MyUtils.createErrorMessage(bindingResult));

        return venueService.updateVenue(venue);
    }

    @DeleteMapping("/deleteVenue/{venueId}")
    public ResponseEntity<String> deleteVenue(@PathVariable("venueId") Long venueId)
    {
        return venueService.deleteVenue(venueId);
    }


    @PostMapping("/addVenue")
    public ResponseEntity<String> addVenue(@RequestBody @Valid Venue venue, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MyUtils.createErrorMessage(bindingResult));

        return venueService.addVenue(venue);
    }


}
