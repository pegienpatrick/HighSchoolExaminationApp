package com.pegien.HighSchoolExamination.StudySubjects;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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



    default List<StudySubject> listAllSubjects()
    {
        List<StudySubject> studySubjects = new ArrayList<>();

        // Adding StudySubjects to the list
        studySubjects.add(new StudySubject(101, "English", "ENG"));
        studySubjects.add(new StudySubject(102, "Kiswahili", "KIS"));
        studySubjects.add(new StudySubject(121, "Mathematics", "MAT"));
        studySubjects.add(new StudySubject(231, "Biology", "BIO"));
        studySubjects.add(new StudySubject(232, "Chemistry", "CHE"));
        studySubjects.add(new StudySubject(233, "Physics", "PHY"));
        studySubjects.add(new StudySubject(311, "History and Government", "HIS"));
        studySubjects.add(new StudySubject(312, "Geography", "GEO"));
        studySubjects.add(new StudySubject(313, "Christian Religious Education", "CRE"));
        studySubjects.add(new StudySubject(314, "Islamic Religious Education", "IRE"));
        studySubjects.add(new StudySubject(401, "Physical Education", "PE"));
        studySubjects.add(new StudySubject(501, "Computer Studies/ICT", "ICT"));
        studySubjects.add(new StudySubject(502, "Home Science", "HSC"));
        studySubjects.add(new StudySubject(503, "Agriculture", "AGR"));
        studySubjects.add(new StudySubject(504, "Business Studies", "BST"));
        studySubjects.add(new StudySubject(505, "French", "FRE"));
        studySubjects.add(new StudySubject(506, "German", "GER"));
        studySubjects.add(new StudySubject(507, "Music", "MUS"));
        studySubjects.add(new StudySubject(508, "Art and Design", "ART"));
        studySubjects.add(new StudySubject(509, "Aviation Technology", "AVT"));
        studySubjects.add(new StudySubject(510, "Electricity", "ELE"));
        studySubjects.add(new StudySubject(511, "Woodwork", "WWD"));
        studySubjects.add(new StudySubject(512, "Metalwork", "MWW"));
        studySubjects.add(new StudySubject(513, "Building Construction", "BCN"));
        studySubjects.add(new StudySubject(514, "Power Mechanics", "PME"));
        studySubjects.add(new StudySubject(515, "Drawing and Design", "DD"));
        studySubjects.add(new StudySubject(516, "Additional Mathematics", "ADDM"));

        return studySubjects;
    }

}
