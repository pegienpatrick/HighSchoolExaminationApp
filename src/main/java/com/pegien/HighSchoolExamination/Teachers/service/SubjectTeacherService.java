package com.pegien.HighSchoolExamination.Teachers.service;

import com.pegien.HighSchoolExamination.StudySubjects.StudySubject;
import com.pegien.HighSchoolExamination.StudySubjects.StudySubjectsRepository;
import com.pegien.HighSchoolExamination.Teachers.SubjectTeacher;
import com.pegien.HighSchoolExamination.Teachers.SubjectTeacherRepository;
import com.pegien.HighSchoolExamination.Teachers.model.responses.ClassSubjectTeachers;
import com.pegien.HighSchoolExamination.Users.User;
import com.pegien.HighSchoolExamination.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public class SubjectTeacherService {

    @Autowired
    private SubjectTeacherRepository subjectTeacherRepository;

    @Autowired
    private StudySubjectsRepository studySubjectsRepository;

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<ClassSubjectTeachers> getSubjectTeachers(Double grade, String stream) {

        ClassSubjectTeachers classSubjectTeachers=new ClassSubjectTeachers();
        classSubjectTeachers.setGrade(grade);
        classSubjectTeachers.setStream(stream);
        classSubjectTeachers.setClassTeacher(forceGetClassTeacher(grade,stream));

        HashMap<String,SubjectTeacher> subjects=new HashMap<>();
        for(StudySubject i:studySubjectsRepository.allAvailable())
            subjects.put(i.getSubjectName(),forceGetSUbjectTeacher(grade,stream,i.getSubjectCode()));

        classSubjectTeachers.setSubjectTeachers(subjects);
        return ResponseEntity.ok(classSubjectTeachers);
    }


    SubjectTeacher forceGetClassTeacher(Double grade,String stream)
    {
        Optional<SubjectTeacher> optionalSubjectTeacher=subjectTeacherRepository.findByIsClassTeacherTrueAndGradeAndStream(grade,stream);
        if(optionalSubjectTeacher.isPresent())
            return optionalSubjectTeacher.get();

        System.out.println("Didn't find class Teacher "+grade+" "+stream);


        SubjectTeacher subjectTeacher= SubjectTeacher.builder()
                .grade(grade)
                .teacher(null)
                .subjectCode(-1)
                .stream(stream)
                .isClassTeacher(true)
                .build();

        subjectTeacherRepository.saveAndFlush(subjectTeacher);
        return subjectTeacher;
    }

    SubjectTeacher forceGetSUbjectTeacher(Double grade,String stream,int subject)
    {
        Optional<SubjectTeacher> optionalSubjectTeacher=subjectTeacherRepository.findByGradeAndStreamAndSubjectCode(grade,stream,subject);
        if(optionalSubjectTeacher.isPresent())
            return optionalSubjectTeacher.get();

        SubjectTeacher subjectTeacher= SubjectTeacher.builder()
                .grade(grade)
                .teacher(null)
                .subjectCode(subject)
                .isClassTeacher(false)
                .stream(stream)
                .build();

        subjectTeacherRepository.saveAndFlush(subjectTeacher);
        return subjectTeacher;
    }


    public ResponseEntity<String> updateSubjectTeacher(SubjectTeacher subjectTeacher) {

        if(subjectTeacher.getNum()==null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Corrupted Data");

        if(subjectTeacher.getTeacher()!=null)
        {
            Optional<User> optionalUser=userRepository.findById(subjectTeacher.getTeacher());
            if(optionalUser.isEmpty())
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Teacher Not found");

            subjectTeacherRepository.save(subjectTeacher);
            return ResponseEntity.ok("Saved Successfully");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Select Teacher First");
    }

    public ResponseEntity<HashMap<Long, String>> allTeachers() {
        HashMap<Long, String> teachers=new HashMap<>();
        for(User s: userRepository.findAll())
            teachers.put(s.getNum(),s.getFname()==null||s.getFname().length()==0?s.getUsername():s.getFname());

        return ResponseEntity.ok(teachers);
    }
}
