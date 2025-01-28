package com.pegien.HighSchoolExamination.BusinessLogic.TimeTable.service;


import com.pegien.HighSchoolExamination.Settings.Setting;
import com.pegien.HighSchoolExamination.Settings.service.SettingsService;
import com.pegien.HighSchoolExamination.BusinessLogic.StudySubjects.StudySubject;
import com.pegien.HighSchoolExamination.BusinessLogic.Teachers.SubjectTeacher;
import com.pegien.HighSchoolExamination.BusinessLogic.Teachers.SubjectTeacherRepository;
import com.pegien.HighSchoolExamination.BusinessLogic.Teachers.service.SubjectTeacherService;
import com.pegien.HighSchoolExamination.BusinessLogic.TimeTable.DummyRepo;
import com.pegien.HighSchoolExamination.BusinessLogic.TimeTable.Slots.service.TimeTableSlotService;
import com.pegien.HighSchoolExamination.BusinessLogic.TimeTable.SubjectsPerWeek.SUbjectPerWeek;
import com.pegien.HighSchoolExamination.BusinessLogic.TimeTable.SubjectsPerWeek.service.SubjectsPerWeekService;
import com.pegien.HighSchoolExamination.BusinessLogic.TimeTable.TimeTableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class TimeTableService {


    @Autowired
    private SubjectTeacherRepository subjectTeacherRepository;

    @Value("timetableFolder")
    private String timetablefolder;

    public static String SPECIALIZED_GRADES_SETTINGS="SPECIALIZEDGRADESETTING";

    @Autowired
    private SubjectTeacherService subjectTeacherService;


    @Autowired
    private SettingsService settingsService;

    @Autowired
    private SubjectsPerWeekService subjectsPerWeekService;

    @Autowired
    private TimeTableSlotService timeTableSlotService;

    public ResponseEntity<byte[]> viewClassTimeTable() {
        try {
            // Generate the PDF report
            byte[] pdfBytes = new FileInputStream(new File(timetablefolder,"classtimeTable.pdf")).readAllBytes();

            // Set the response headers
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "Class Time Table.pdf");

            return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<byte[]> viewTeachersTimeTable() {
        try {
            // Generate the PDF report
            byte[] pdfBytes = new FileInputStream(new File(timetablefolder,"TeachersTimeTable.pdf")).readAllBytes();

            // Set the response headers
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "Teachers Time Table.pdf");

            return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    public ResponseEntity<byte[]> viewVenuesTimeTable() {
        try {
            // Generate the PDF report
            byte[] pdfBytes = new FileInputStream(new File(timetablefolder,"venuesTimeTable.pdf")).readAllBytes();

            // Set the response headers
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "Venues Time Table.pdf");

            return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    public ResponseEntity<String> regenerate() {

        TimeTableUtils.subjectTeachers=new HashMap<>();
        if(TimeTableUtils.teachersName==null)
            TimeTableUtils.teachersName=new HashMap<>();
        for(SubjectTeacher t:subjectTeacherRepository.findAll())
        {
            String joint=((int)(t.getGrade()/1))+t.getStream();
            if(!TimeTableUtils.subjectTeachers.containsKey(joint))
                TimeTableUtils.subjectTeachers.put(joint,new HashMap<>());
            HashMap<Integer, Long> ctt=TimeTableUtils.subjectTeachers.get(joint);
            if(t.getIsClassTeacher())
                ctt.put(999,t.getTeacher());
            else
                ctt.put(t.getSubjectCode(),t.getTeacher());
        }
        TimeTableUtils.timetablefolder=timetablefolder;
        TimeTableUtils.teachersName=subjectTeacherService.allTeacher();


        //set grades that have selected subjects
        TimeTableUtils.selectedSubjectsGrades= List.of(settingsService.getSetting(SPECIALIZED_GRADES_SETTINGS, Setting.builder().integerArrayValue(new Integer[]{3, 4}).build()).getIntegerArrayValue());


        TimeTableUtils.lessonsPerDay = timeTableSlotService.lessonsPerDay();
        TimeTableUtils.arrangeSlots(timeTableSlotService.listSlots());
        //set subjects per week
       for(int grd=1;grd<=4;grd++)
       {
           TimeTableUtils.streamJointSubjects.put(grd,new ArrayList<>());
           TimeTableUtils.lessonsPerWeek.put(grd,new HashMap<>());
           TimeTableUtils.subjectVenues.put(grd,new HashMap<>());
           TimeTableUtils.practicalSubjects.put(grd,new HashMap<>());

            for(StudySubject s: DummyRepo.allAvailable()) {
                SUbjectPerWeek sUbjectPerWeek=subjectsPerWeekService.forceGet((double) grd, s.getSubjectCode(), s.getSubjectName());
                if(sUbjectPerWeek.getJoinStreams()!=null&&sUbjectPerWeek.getJoinStreams())
                    TimeTableUtils.streamJointSubjects.get(grd).add(sUbjectPerWeek.getSubjectCode());
                TimeTableUtils.lessonsPerWeek.get(grd).put(sUbjectPerWeek.getSubjectCode(),sUbjectPerWeek.getLessonsPerWeek());
                if(sUbjectPerWeek.getHasDedicatedVenue()!=null&&sUbjectPerWeek.getHasDedicatedVenue())
                    TimeTableUtils.subjectVenues.get(grd).put(sUbjectPerWeek.getSubjectCode(),sUbjectPerWeek.getDedicatedVenues());
                if(sUbjectPerWeek.getHasDouble()!=null&&sUbjectPerWeek.getHasDouble())
                    TimeTableUtils.practicalSubjects.get(grd).put(sUbjectPerWeek.getSubjectCode(),sUbjectPerWeek.getDoubleVenue());

            }
       }











        TimeTableUtils.main(new String[]{"pats"});
        return ResponseEntity.ok("Completed Successfully");
    }


    public ResponseEntity<String> setSpecializedGrades(Integer[] specialized) {

        Setting setting= Setting.builder()
                .integerArrayValue(specialized)
                .settingName(SPECIALIZED_GRADES_SETTINGS)
                .build();

        settingsService.set(setting);
        return ResponseEntity.ok("Saved Successfully");
    }

    public ResponseEntity<Integer[]> getSpecializedgrades() {
        return ResponseEntity.ok(settingsService.getSetting(SPECIALIZED_GRADES_SETTINGS, Setting.builder().integerArrayValue(new Integer[]{3,4}).build()).getIntegerArrayValue());
    }

}
