package com.pegien.HighSchoolExamination.BusinessLogic.StudySubjects.SubjectGrade.model.responses;

import com.pegien.HighSchoolExamination.BusinessLogic.StudySubjects.SubjectGrade.SubjectGrading;


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

    public SubjectGradingResponse(SubjectGrading subjectGrading)
    {
        setSubjectCode(subjectGrading.getSubjectCode());
        setAMarks(subjectGrading.getAMarks());
        setEMarks(subjectGrading.getEMarks());
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
