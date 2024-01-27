package com.pegien.HighSchoolExamination.StudySubjects.SubjectGrade.model.responses;

import com.pegien.HighSchoolExamination.StudySubjects.SubjectGrade.SubjectGrading;
import lombok.Data;



public class SubjectGradingResponse extends SubjectGrading {

    private String subjectName;

    private String subjectRep;

    public SubjectGradingResponse(int subjectCode, int aMarks, int eMarks, String subjectName, String subjectRep) {
        super(subjectCode, aMarks, eMarks);
        this.subjectName = subjectName;
        this.subjectRep = subjectRep;
    }

    public SubjectGradingResponse(String subjectName, String subjectRep) {
        this.subjectName = subjectName;
        this.subjectRep = subjectRep;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectRep() {
        return subjectRep;
    }

    public void setSubjectRep(String subjectRep) {
        this.subjectRep = subjectRep;
    }
}
