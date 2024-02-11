package com.pegien.HighSchoolExamination.TimeTable.SubjectsPerWeek.service;

import com.pegien.HighSchoolExamination.StudySubjects.StudySubject;
import com.pegien.HighSchoolExamination.TimeTable.DummyRepo;
import com.pegien.HighSchoolExamination.TimeTable.SubjectsPerWeek.SUbjectPerWeek;
import com.pegien.HighSchoolExamination.TimeTable.SubjectsPerWeek.SubjectPerWeekRepository;
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


    public ResponseEntity<List<SUbjectPerWeek>> getForGrade(Double grade) {

        List<SUbjectPerWeek> all=new ArrayList<>();
        for(StudySubject s: DummyRepo.allAvailable())
            all.add(forceGet(grade,s.getSubjectCode(),s.getSubjectName()));

        return ResponseEntity.ok(all);
    }

    public ResponseEntity<String> updateSubjectPerWeek(SUbjectPerWeek sUbjectPerWeek) {
        subjectPerWeekRepository.save(sUbjectPerWeek);
        return ResponseEntity.ok("Updated Successfully");
    }




    public SUbjectPerWeek forceGet(Double grade,int subjectCode,String subjectName)
    {
        Optional<SUbjectPerWeek> sUbjectPerWeekOptional=subjectPerWeekRepository.findByGradeAndSubjectCode(grade,subjectCode);
        if(sUbjectPerWeekOptional.isPresent())
            return sUbjectPerWeekOptional.get();

        SUbjectPerWeek sUbjectPerWeek=SUbjectPerWeek.builder()
                .subjectCode(subjectCode)
                .grade(grade)
                .lessonsPerWeek(1)
                .subjectName(subjectName)
                .build();

        subjectPerWeekRepository.saveAndFlush(sUbjectPerWeek);

        return sUbjectPerWeek;
    }



}
