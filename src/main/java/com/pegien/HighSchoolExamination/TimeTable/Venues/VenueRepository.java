package com.pegien.HighSchoolExamination.TimeTable.Venues;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VenueRepository extends JpaRepository<Venue,Long> {


    Optional<Venue> findByNameIgnoreCase(String name);

}
