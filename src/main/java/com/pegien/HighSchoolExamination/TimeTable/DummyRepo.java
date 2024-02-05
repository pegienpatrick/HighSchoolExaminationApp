package com.pegien.HighSchoolExamination.TimeTable;

import com.pegien.HighSchoolExamination.StudySubjects.StudySubject;
import com.pegien.HighSchoolExamination.StudySubjects.StudySubjectsRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public  class DummyRepo {


    public static  List<StudySubject> listCompulsory()
    {
        List<StudySubject> studySubjects = new ArrayList<>();

        int[] subjects={101,102,121,233,314};
        for(int i:subjects)
            studySubjects.add(findBySubjectCode(i));

        return studySubjects;
    }

    public static  HashMap<String,StudySubject[]> selectionOptions()
    {
        HashMap<String,StudySubject[]> choices=new HashMap<>();

        choices.put("sciences",new StudySubject[]{findBySubjectCode(231),findBySubjectCode(232)});
        choices.put("humanities",new StudySubject[]{findBySubjectCode(311),findBySubjectCode(312)});
        choices.put("applied",new StudySubject[]{findBySubjectCode(451),findBySubjectCode(565),findBySubjectCode(503)});

        return choices;
    }

    public static  List<StudySubject> allAvailable()
    {
        List<StudySubject> studySubjects = new ArrayList<>();

        int[] subjects={101,102,121,231,232,233,311,312,314,451,503,565};
        for(int i:subjects)
            studySubjects.add(findBySubjectCode(i));
//        studySubjects.addAll(listCompulsory());
//        for(StudySubject[] s:selectionOptions().values())
//            studySubjects.addAll(List.of(s));

        return studySubjects;
    }

//    StudySubject findBySubjectCode(int code);
//
//    StudySubject findBySubjectRep(String rep);

    public static  StudySubject findBySubjectCode(int code){

        for(StudySubject studySubject:findAll())
            if(studySubject.getSubjectCode()==code)
                return studySubject;
        return null;

    }

    public static  StudySubject findBySubjectRep(String rep){
        for(StudySubject studySubject:findAll())
            if(studySubject.getSubjectRep().equals(rep))
                return studySubject;

        return null;
    }




    public static  List<StudySubject> findAll()
    {
        List<StudySubject> studySubjects = new ArrayList<>();

        studySubjects.add(new StudySubject(101, "English", "ENG"));
        studySubjects.add(new StudySubject(102, "Kiswahili", "KIS"));
        studySubjects.add(new StudySubject(121, "Mathematics", "MATH"));
        studySubjects.add(new StudySubject(122, "Mathematics, Alternative B", "MATH B"));
        studySubjects.add(new StudySubject(231, "Biology", "BIO"));
        studySubjects.add(new StudySubject(232, "Physics", "PHY"));
        studySubjects.add(new StudySubject(233, "Chemistry", "CHEM"));
        studySubjects.add(new StudySubject(236, "Biology for the Blind", "BIO Blind"));
        studySubjects.add(new StudySubject(237, "General Science", "Science"));
        studySubjects.add(new StudySubject(311, "History", "HIST"));
        studySubjects.add(new StudySubject(312, "Geography", "GEO"));
        studySubjects.add(new StudySubject(313, "CRE", "CRE"));
        studySubjects.add(new StudySubject(314, "ISlamic Religious Education", "IRE"));
        studySubjects.add(new StudySubject(315, "HRE", "HRE"));
        studySubjects.add(new StudySubject(441, "Home Science", "Home Sci"));
        studySubjects.add(new StudySubject(442, "Art and Design", "Art"));
        studySubjects.add(new StudySubject(443, "Agriculture", "AGRI"));
        studySubjects.add(new StudySubject(444, "Wood Work", "Woodwork"));
        studySubjects.add(new StudySubject(445, "Metal Work", "Metalwork"));
        studySubjects.add(new StudySubject(446, "Building Construction", "Building Const."));
        studySubjects.add(new StudySubject(447, "Power Mechanics", "Mechanics"));
        studySubjects.add(new StudySubject(448, "Electricity", "Electricity"));
        studySubjects.add(new StudySubject(449, "Drawing and Design", "Design"));
        studySubjects.add(new StudySubject(450, "Aviation Technology", "Aviation"));
        studySubjects.add(new StudySubject(451, "Computer Studies", "ICT"));
        studySubjects.add(new StudySubject(501, "French", "FRE"));
        studySubjects.add(new StudySubject(502, "German", "GER"));
        studySubjects.add(new StudySubject(503, "Arabic", "ARAB"));
        studySubjects.add(new StudySubject(504, "Sign Language", "Sign Lang"));
        studySubjects.add(new StudySubject(511, "Music", "MUSIC"));
        studySubjects.add(new StudySubject(565, "Business Studies", "BST"));
//        studySubjects.add(ne);


        return studySubjects;
    }
}
