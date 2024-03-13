package com.pegien.HighSchoolExamination.TimeTable.SubjectsPerWeek.service;

import com.pegien.HighSchoolExamination.StudySubjects.StudySubject;
import com.pegien.HighSchoolExamination.TimeTable.DummyRepo;
import com.pegien.HighSchoolExamination.TimeTable.SubjectsPerWeek.SUbjectPerWeek;
import com.pegien.HighSchoolExamination.TimeTable.SubjectsPerWeek.SubjectPerWeekRepository;
import com.pegien.HighSchoolExamination.TimeTable.Venues.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectsPerWeekService {

    @Autowired
    private SubjectPerWeekRepository subjectPerWeekRepository;

    @Autowired
    private VenueRepository venueRepository;


    public ResponseEntity<List<SUbjectPerWeek>> getForGrade(Double grade) {

        List<SUbjectPerWeek> all=new ArrayList<>();
        for(StudySubject s: DummyRepo.allAvailable())
            all.add(forceGet(grade,s.getSubjectCode(),s.getSubjectName()));

        return ResponseEntity.ok(all);
    }

    public ResponseEntity<String> updateSubjectPerWeek(SUbjectPerWeek sUbjectPerWeek) {
        tryGetVenueIds(sUbjectPerWeek);
        subjectPerWeekRepository.save(sUbjectPerWeek);
        return ResponseEntity.ok("Updated Successfully");
    }

    private void tryGetVenueIds(SUbjectPerWeek sUbjectPerWeek) {
        try{//set Dedicated Venue Id
            if(!sUbjectPerWeek.getDedicatedVenues().isEmpty())
                sUbjectPerWeek.setDedicatedVenueId(venueRepository.findByNameIgnoreCase(sUbjectPerWeek.getDedicatedVenues()).get().getNum());
        }catch (Exception es)
        {

        }

        try{//set Double Venue
            if(!sUbjectPerWeek.getDoubleVenue().isEmpty())
                sUbjectPerWeek.setDoubleVenueId(venueRepository.findByNameIgnoreCase(sUbjectPerWeek.getDoubleVenue()).get().getNum());
        }catch (Exception es)
        {

        }
    }


    public SUbjectPerWeek forceGet(Double grade,int subjectCode,String subjectName)
    {
        Optional<SUbjectPerWeek> sUbjectPerWeekOptional=subjectPerWeekRepository.findByGradeAndSubjectCode(grade,subjectCode);
        if(sUbjectPerWeekOptional.isPresent()) {
           SUbjectPerWeek sUbjectPerWeek=sUbjectPerWeekOptional.get();
           trySetVenueNames(sUbjectPerWeek);
           return sUbjectPerWeek;
        }

        SUbjectPerWeek sUbjectPerWeek=SUbjectPerWeek.builder()
                .subjectCode(subjectCode)
                .grade(grade)
                .lessonsPerWeek(1)
                .subjectName(subjectName)
                .build();

        subjectPerWeekRepository.saveAndFlush(sUbjectPerWeek);

        return sUbjectPerWeek;
    }

    private void trySetVenueNames(SUbjectPerWeek sUbjectPerWeek) {
        try{//set double venue
            if(sUbjectPerWeek.getDoubleVenueId()!=null);
                sUbjectPerWeek.setDoubleVenue(venueRepository.findById(sUbjectPerWeek.getDoubleVenueId()).get().getName());
        }catch (Exception es)
        {

        }

        try{//set dedicated Venue venue
            if(sUbjectPerWeek.getDedicatedVenueId()!=null);
            sUbjectPerWeek.setDedicatedVenues(venueRepository.findById(sUbjectPerWeek.getDedicatedVenueId()).get().getName());
        }catch (Exception es)
        {

        }
    }


}
