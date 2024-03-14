package com.pegien.HighSchoolExamination.TimeTable.Slots.service;


import com.pegien.HighSchoolExamination.Settings.Setting;
import com.pegien.HighSchoolExamination.Settings.service.SettingsService;
import com.pegien.HighSchoolExamination.TimeTable.Slots.TimeTableSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TimeTableSlotService {

    @Autowired
    private TimeTableSlotRepository timeTableSlotRepository;

    @Autowired
    private SettingsService settingsService;


    private static String KEY_LESSONS_PER_DAY="lESSSONSpERdAY";


    public ResponseEntity<String> getLessonsPerDay() {
        return ResponseEntity.ok(String.valueOf(lessonsPerDay()));
    }

    public int lessonsPerDay()
    {
        return settingsService.getSetting(KEY_LESSONS_PER_DAY, Setting.builder().integerValue(9).build()).getIntegerValue();
    }
}
