package com.pegien.HighSchoolExamination.BusinessLogic.Teachers.service;

import com.pegien.HighSchoolExamination.BusinessLogic.StudySubjects.StudySubject;
import com.pegien.HighSchoolExamination.BusinessLogic.StudySubjects.StudySubjectsRepository;
import com.pegien.HighSchoolExamination.BusinessLogic.Teachers.SubjectTeacher;
import com.pegien.HighSchoolExamination.BusinessLogic.Teachers.SubjectTeacherRepository;
import com.pegien.HighSchoolExamination.BusinessLogic.Teachers.model.responses.ClassSubjectTeachers;
import com.pegien.HighSchoolExamination.Users.entity.User;
import com.pegien.HighSchoolExamination.Users.Repository.UserRepository;
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
        return ResponseEntity.ok(getSubjectTeacher(grade,stream));
    }

    public ClassSubjectTeachers getSubjectTeacher(Double grade, String stream) {

        ClassSubjectTeachers classSubjectTeachers=new ClassSubjectTeachers();
        classSubjectTeachers.setGrade(grade);
        classSubjectTeachers.setStream(stream);
        classSubjectTeachers.setClassTeacher(forceGetClassTeacher(grade,stream));

        HashMap<String,SubjectTeacher> subjects=new HashMap<>();
        for(StudySubject i:studySubjectsRepository.allAvailable())
            subjects.put(i.getSubjectName(),forceGetSUbjectTeacher(grade,stream,i.getSubjectCode()));

        classSubjectTeachers.setSubjectTeachers(subjects);
        return classSubjectTeachers;
    }


    public SubjectTeacher forceGetClassTeacher(Double grade,String stream)
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
        subjectTeacherRepository.save(subjectTeacher);
        return ResponseEntity.ok("Saved Successfully");
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Select Teacher First");
    }

    public ResponseEntity<HashMap<Long, String>> allTeachers() {

        return ResponseEntity.ok(allTeacher());
    }

    public HashMap<Long, String> allTeacher() {
        HashMap<Long, String> teachers = new HashMap<>();
        for (User s : userRepository.findAll())
            teachers.put(s.getNum(), s.getFname() == null || s.getFname().length() == 0 ? s.getUsername() : s.getFname());
        return teachers;
    }
}
