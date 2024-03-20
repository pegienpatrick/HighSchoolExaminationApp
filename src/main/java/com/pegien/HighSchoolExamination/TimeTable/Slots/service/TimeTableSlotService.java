package com.pegien.HighSchoolExamination.TimeTable.Slots.service;


import com.pegien.HighSchoolExamination.Settings.Setting;
import com.pegien.HighSchoolExamination.Settings.service.SettingsService;
import com.pegien.HighSchoolExamination.TimeTable.Slots.TimeTableSlot;
import com.pegien.HighSchoolExamination.TimeTable.Slots.TimeTableSlotRepository;
import com.pegien.HighSchoolExamination.TimeTable.Slots.model.requests.LessonsPerDayRequest;
import com.pegien.HighSchoolExamination.TimeTable.Slots.model.requests.UpdateTimeTableSlotRequest;
import com.pegien.HighSchoolExamination.TimeTable.Slots.model.responses.LessonsPerDayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static com.pegien.HighSchoolExamination.TimeTable.Slots.SlotType.BREAK;
import static com.pegien.HighSchoolExamination.TimeTable.Slots.SlotType.LESSON;

@Service
public class TimeTableSlotService {

    @Autowired
    private TimeTableSlotRepository timeTableSlotRepository;

    @Autowired
    private SettingsService settingsService;


    private static String KEY_LESSONS_PER_DAY="lESSSONSpERdAY";

    private static String KEY_LESSONS_DURATION="lESSSONSDURATION";

    private static String KEY_START_HOUR="startHour";

    private static String KEY_START_MINUTE="startMinute";


    public ResponseEntity<LessonsPerDayResponse> getLessonsPerDay() {
        return ResponseEntity.ok(LessonsPerDayResponse.builder().lessons(lessonsPerDay()).duration(lessonsDuration()).startTime(new Time(lessonsStartHour(),lessonsStartMinute(),0)).build());
    }

    public int lessonsPerDay()
    {
        return settingsService.getSetting(KEY_LESSONS_PER_DAY, Setting.builder().integerValue(9).build()).getIntegerValue();
    }
    public int lessonsDuration()
    {
        return settingsService.getSetting(KEY_LESSONS_DURATION, Setting.builder().integerValue(40).build()).getIntegerValue();
    }

    public int lessonsStartHour()
    {
        return settingsService.getSetting(KEY_START_HOUR, Setting.builder().integerValue(8).build()).getIntegerValue();
    }

    public int lessonsStartMinute()
    {
        return settingsService.getSetting(KEY_START_MINUTE, Setting.builder().integerValue(0).build()).getIntegerValue();
    }

    public ResponseEntity<String> updateLessonsPerWeek(LessonsPerDayRequest lessonsPerDayRequest) {
        settingsService.set(Setting.builder().settingName(KEY_LESSONS_PER_DAY).integerValue(lessonsPerDayRequest.getLessons()).build());
        settingsService.set(Setting.builder().settingName(KEY_LESSONS_DURATION).integerValue(lessonsPerDayRequest.getDuration()).build());
        settingsService.set(Setting.builder().settingName(KEY_START_HOUR).integerValue(lessonsPerDayRequest.getStartTime().getHours()).build());
        settingsService.set(Setting.builder().settingName(KEY_START_MINUTE).integerValue(lessonsPerDayRequest.getStartTime().getMinutes()).build());
        return ResponseEntity.ok("Saved Successfully");
    }


    public TimeTableSlot[] listSlots()
    {
        ArrayList<TimeTableSlot> fine=new ArrayList<>();
        List<TimeTableSlot> slots = timeTableSlotRepository.listAsc();
        int lessonIndex=0;
        HashMap<Long,TimeTableSlot> allSlots=new HashMap<>();
        HashMap<Long,Long> afters=new HashMap<>();
        List<TimeTableSlot> lessonSlots=new ArrayList<>();
        for(TimeTableSlot slot:slots)//get slo
        {
            allSlots.put(slot.getNum(), slot);
            if(slot.getAfter()!=null)
                afters.put(slot.getAfter(), slot.getNum());
            if(slot.getSlotType()== LESSON)
                lessonSlots.add(slot);
        }
        if(lessonSlots.size()<lessonsPerDay())
            for(int i=lessonSlots.size();i<lessonsPerDay();i++)
            {
                TimeTableSlot timeTableSlot= TimeTableSlot.builder()
                        .slotType(LESSON)
                        .build();
                timeTableSlotRepository.saveAndFlush(timeTableSlot);
                allSlots.put(timeTableSlot.getNum(), timeTableSlot);
                lessonSlots.add(timeTableSlot);
            }

        HashSet<Long> addedKeys=new HashSet<>();

        //check for break before lessons
        if(afters.containsKey(-1L))
        {
            Long newKey=afters.get(-1L);
            if(!addedKeys.contains(newKey)) {
                fine.add(allSlots.get(newKey));
                addedKeys.add(newKey);
                checkIfAfterExists(afters,allSlots.get(newKey),addedKeys,fine,allSlots);
            }

        }
        //Loop Migrating the Array
        for(int i=0;i<lessonsPerDay();i++)
        {
            TimeTableSlot curr=lessonSlots.get(i);
            curr.setDuration(lessonsDuration());
            curr.setTitle(String.format("Lesson %d",i+1));

            if(!addedKeys.contains(curr.getNum())) {
                fine.add(curr);
                addedKeys.add(curr.getNum());
                checkIfAfterExists(afters,curr,addedKeys,fine,allSlots);
            }

        }
        //add Junkies
        for(TimeTableSlot ss:slots)
            if(!addedKeys.contains(ss.getNum())&&(ss.getSlotType()==BREAK ||fine.size()<lessonsPerDay())) {
                fine.add(ss);
                addedKeys.add(ss.getNum());
//                checkIfAfterExists(ss);
                checkIfAfterExists(afters,ss,addedKeys,fine,allSlots);
            }

        Time start=new Time(lessonsStartHour(),lessonsStartMinute(),00);
        Long startCumm=start.getTime();
        //setTime for all slots
        for(TimeTableSlot tableSlot:fine)
        {
            Time startTime=new Time(startCumm);
            tableSlot.setStartHour(startTime.getHours());
            tableSlot.setStartMinute(startTime.getMinutes());
            startCumm+= TimeUnit.MINUTES.toMillis(tableSlot.getDuration());
        }


        return fine.toArray(new TimeTableSlot[0]);
    }

    private void checkIfAfterExists(HashMap<Long, Long> afters, TimeTableSlot curr, HashSet<Long> addedKeys, ArrayList<TimeTableSlot> fine, HashMap<Long, TimeTableSlot> allSlots) {
        if (afters.containsKey(curr.getNum())) {
            Long newKey=afters.get(curr.getNum());
            if(!addedKeys.contains(newKey)) {
                fine.add(allSlots.get(newKey));
                addedKeys.add(newKey);
                checkIfAfterExists(afters,allSlots.get(newKey),addedKeys,fine,allSlots);
            }
        }
    }

    public ResponseEntity<String> addBreak(String title) {
        TimeTableSlot timeTableSlot= TimeTableSlot.builder()
                .slotType(BREAK)
                .title(title)
                .build();
        timeTableSlotRepository.save(timeTableSlot);

        return ResponseEntity.ok("Added Successfully");
    }

    public ResponseEntity<String> move(Long slot, String direction) {
        Optional<TimeTableSlot> timeTableSlotOptional=timeTableSlotRepository.findById(slot);
        if(timeTableSlotOptional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Such SLot");
        if(timeTableSlotOptional.get().getSlotType()==LESSON)
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Cannot Move Lesson");


        TimeTableSlot[] allSlots = listSlots();
        for(int i=0;i< allSlots.length;i++)
        {
            if(allSlots[i].getNum().equals(slot))
            {
                TimeTableSlot current=allSlots[i];
                if(direction.equals("left")) {


                    //avoid dragging
                    if(i+1< allSlots.length&&allSlots[i+1].getSlotType()==BREAK) {
                        allSlots[i + 1].setAfter(current.getAfter());
                        timeTableSlotRepository.save(allSlots[i+1]);
                    }


                    //detach existing follower
                    int after = i - 2;
                    if(after>-1)
                        current.setAfter(allSlots[after].getNum());
                    else
                        current.setAfter(-1L);

                    timeTableSlotRepository.save(current);
                    if(allSlots[after+1].getSlotType()==BREAK) {
                        allSlots[after + 1].setAfter(current.getNum());
                        timeTableSlotRepository.save(allSlots[after+1]);
                    }


                }else {

                    //avoid dragging
                    if(i+1< allSlots.length&&allSlots[i+1].getSlotType()==BREAK) {
                        allSlots[i + 1].setAfter(current.getAfter());
                        timeTableSlotRepository.save(allSlots[i+1]);
                    }



                    int after = i + 1;
                    current.setAfter(allSlots[after].getNum());
                    timeTableSlotRepository.save(current);

                    if(after+1< allSlots.length&&allSlots[after+1].getSlotType()==BREAK) {
                        allSlots[after + 1].setAfter(current.getNum());
                        timeTableSlotRepository.save(allSlots[after+1]);
                    }

                }
            }

        }
        return ResponseEntity.ok("Move Successful");

    }

    public ResponseEntity<String> updateSlot(UpdateTimeTableSlotRequest updateTimeTableSlotRequest) {
        Optional<TimeTableSlot> timeTableSlotOptional=timeTableSlotRepository.findById(updateTimeTableSlotRequest.getNum());
        if(timeTableSlotOptional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Such SLot");
        if(timeTableSlotOptional.get().getSlotType()==LESSON)
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Cannot Edit Lesson here");

        TimeTableSlot timeTableSlot=timeTableSlotOptional.get();
        timeTableSlot.setTitle(updateTimeTableSlotRequest.getTitle());
        timeTableSlot.setDuration(updateTimeTableSlotRequest.getDuration());

        timeTableSlotRepository.save(timeTableSlot);


        return ResponseEntity.ok("Updated Successfully");
    }

    public ResponseEntity<String> deleteBreak(Long breakId) {
        Optional<TimeTableSlot> timeTableSlotOptional=timeTableSlotRepository.findById(breakId);
        if(timeTableSlotOptional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Such SLot");
        timeTableSlotRepository.delete(timeTableSlotOptional.get());
        return ResponseEntity.ok("Deleted Successfully");
    }
}
