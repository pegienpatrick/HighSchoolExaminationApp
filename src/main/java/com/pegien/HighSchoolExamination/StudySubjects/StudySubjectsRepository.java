package com.pegien.HighSchoolExamination.StudySubjects;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface StudySubjectsRepository extends JpaRepository<StudySubject,Long> {


    default int[] getGroupSubjects(String group) {
        switch (group.toUpperCase()) {
            case "A":
                return new int[]{101, 102, 121, 231, 232, 233, 311, 312, 313, 314, 401};
            case "B":
                return new int[]{501, 502, 503, 504, 505, 506, 507, 508, 509, 510, 511};
            case "C":
                return new int[]{601, 602, 603, 604, 605, 606, 607, 608, 609, 610, 611};
            default:
                return new int[0];
        }
    }

    default List<StudySubject> listCompulsory()
    {
        List<StudySubject> studySubjects = new ArrayList<>();

        studySubjects.add(new StudySubject(101, "English", "ENG"));
        studySubjects.add(new StudySubject(102, "Kiswahili", "KIS"));
        studySubjects.add(new StudySubject(121, "Mathematics", "MAT"));
        studySubjects.add(new StudySubject(232, "Chemistry", "CHE"));


        studySubjects.add(new StudySubject(314, "Islamic Religious Education", "IRE"));

        return studySubjects;
    }

    default HashMap<String,StudySubject[]> selectionOptions()
    {
        HashMap<String,StudySubject[]> choices=new HashMap<>();

        choices.put("sciences",new StudySubject[]{new StudySubject(233, "Physics", "PHY"),new StudySubject(231, "Biology", "BIO")});
        choices.put("humanities",new StudySubject[]{new StudySubject(311, "History and Government", "HIS"),new StudySubject(312, "Geography", "GEO")});
        choices.put("applied",new StudySubject[]{new StudySubject(504, "Business Studies", "BST"),new StudySubject(501, "Computer Studies/ICT", "ICT")});

        return choices;
    }

    default List<StudySubject> allAvailable()
    {
        List<StudySubject> studySubjects = new ArrayList<>();

        // Adding StudySubjects to the list
        studySubjects.add(new StudySubject(101, "English", "ENG"));
        studySubjects.add(new StudySubject(102, "Kiswahili", "KIS"));
        studySubjects.add(new StudySubject(121, "Mathematics", "MAT"));
        studySubjects.add(new StudySubject(232, "Chemistry", "CHE"));


        studySubjects.add(new StudySubject(314, "Islamic Religious Education", "IRE"));

        studySubjects.add(new StudySubject(231, "Biology", "BIO"));
        studySubjects.add(new StudySubject(233, "Physics", "PHY"));

        studySubjects.add(new StudySubject(504, "Business Studies", "BST"));
        studySubjects.add(new StudySubject(501, "Computer Studies/ICT", "ICT"));

        studySubjects.add(new StudySubject(311, "History and Government", "HIS"));
        studySubjects.add(new StudySubject(312, "Geography", "GEO"));

//        studySubjects.add(new StudySubject(313, "Christian Religious Education", "CRE"));


        return studySubjects;
    }

    StudySubject findBySubjectCode(int code);

    StudySubject findBySubjectRep(String rep);



    default List<StudySubject> findAll()
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
        studySubjects.add(new StudySubject(314, "IRE", "IRE"));
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
        studySubjects.add(new StudySubject(451, "Computer Studies", "Comp. Studies"));
        studySubjects.add(new StudySubject(501, "French", "FRE"));
        studySubjects.add(new StudySubject(502, "German", "GER"));
        studySubjects.add(new StudySubject(503, "Arabic", "ARAB"));
        studySubjects.add(new StudySubject(504, "Sign Language", "Sign Lang"));
        studySubjects.add(new StudySubject(511, "Music", "MUSIC"));
        studySubjects.add(new StudySubject(565, "Business Studies", "Bus. Studies"));


        return studySubjects;
    }

}
