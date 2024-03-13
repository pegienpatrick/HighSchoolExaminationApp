package com.pegien.HighSchoolExamination.TimeTable.Venues.service;


import com.pegien.HighSchoolExamination.TimeTable.Venues.Venue;
import com.pegien.HighSchoolExamination.TimeTable.Venues.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class VenueService {

    @Autowired
    private VenueRepository venueRepository;



    public ResponseEntity<List<Venue>> listVenues() {

        return ResponseEntity.ok(venueRepository.findAll());
    }

    @Transactional
    public ResponseEntity<String> updateVenue(Venue venue) {
        venueRepository.save(venue);
        return ResponseEntity.ok("Saved successfully");
    }

    public ResponseEntity<String> deleteVenue(Long venueId) {
        Optional<Venue> optionalVenue=venueRepository.findById(venueId);
        if(optionalVenue.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Venue Found");

        Venue venue=optionalVenue.get();
        venueRepository.delete(venue);
        return ResponseEntity.ok("Deleted Successfully");
    }

    public ResponseEntity<String> addVenue(Venue venue) {
        if(venue.getNum()!=null)
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Unexpected Id value");

        venue.setName(venue.getName().trim());
        Optional<Venue> existing=venueRepository.findByNameIgnoreCase(venue.getName());
        if(existing.isPresent())
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Venue Already exists");
        venueRepository.saveAndFlush(venue);

        return ResponseEntity.status(HttpStatus.CREATED).body("Created Successfully");
    }
}
