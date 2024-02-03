//package com.pegien.HighSchoolExamination.TimeTable;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPage;
import com.itextpdf.text.pdf.PdfWriter;
import com.pegien.HighSchoolExamination.StudySubjects.StudySubject;
import com.pegien.HighSchoolExamination.StudySubjects.StudySubjectsRepository;
import com.pegien.HighSchoolExamination.TimeTable.DummyRepo;
import com.pegien.HighSchoolExamination.TimeTable.TimeTableLesson.TimeTableLesson;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import javax.persistence.Table;
import java.io.FileOutputStream;
import java.util.*;
import java.util.function.Function;

public class TimeTableUtils {

    private static StudySubjectsRepository studySubjectsRepository=new DummyRepo();
    private static HashMap<String, HashMap<Integer,Long>> subjectTeachers=new HashMap<>();

    private static HashMap<String,HashMap<Integer,TimeTableLesson[]>> classesTimeTables=new HashMap<>();

    private static HashMap<Long,HashMap<Integer,TimeTableLesson[]>> teachersTimeTables=new HashMap<>();

    private static int teachers=20;
    private static int subjectsNum=2;

    static List<StudySubject> subjects=studySubjectsRepository.allAvailable();


    private static HashMap<Long,String> teachersName=new HashMap<>();

    private static HashMap<Long,Integer[]> teacherSubjects=new HashMap<>();


    private static String[] streams={"A","B","C"};

    private static int[] grades={4,3,2,1};

    private static int days=5;
    private static int lessonsPerDay=9;



    public static void main(String[] args)
    {
        addTeachers();
        addSubjectTeachers();

        printAllTeachers();
        printClassesAndTeachers();
        prepareTeacherEngagements();
        generateTimeTable();
        printTimeTable();
        printTeacherTimeTable();

    }



//    private static HashMap<Long,HashMap<Integer,TimeTableLesson[]>> teachersTimeTables=new HashMap<>();


    private static void prepareTeacherEngagements() {
        for(Long i:teachersName.keySet())
        {
            HashMap<Integer, TimeTableLesson[]> day=new HashMap<>();
            for(int d=0;d<days;d++) {
                day.put(d,new TimeTableLesson[lessonsPerDay]);
            }
            teachersTimeTables.put(i,day);
        }
    }


    private static void printClassesAndTeachers() {

        for(String i:subjectTeachers.keySet())
        {
            System.out.print("\n Class "+i+" T ");
            for(int j:subjectTeachers.get(i).keySet())
                System.out.print( studySubjectsRepository.findBySubjectCode(j).getSubjectRep()+" : "+teachersName.get(subjectTeachers.get(i).get(j))+", ");
        }
    }

    private static void printAllTeachers() {
        for(Long i:teachersName.keySet()) {
            System.out.print(String.format("\n%d. Teacher Name : %s Teaching Subjects : ", i,teachersName.get(i)));
            for(int j:teacherSubjects.get(i))
                System.out.print(String.format(" %s , ", studySubjectsRepository.findBySubjectCode(j).getSubjectRep()));
        }
    }

    private static void addSubjectTeachers() {
        Random random=new Random();
        for(StudySubject s:subjects)
        {//fetch techers for that subject.
            List<Long> itsTeachers=new ArrayList<>();
            {
                for (Long i : teacherSubjects.keySet())
                    for (Integer j : teacherSubjects.get(i))
                        if (j == s.getSubjectCode())
                            itsTeachers.add(i);
            }

            for(int i:grades)
                for(String j:streams)
                {
                    String joint=i+j;
                    if(itsTeachers.size()>0) {
                        int indexT = random.nextInt(itsTeachers.size());
                        if (!subjectTeachers.containsKey(joint))
                            subjectTeachers.put(joint, new HashMap<>());
                        subjectTeachers.get(joint).put(s.getSubjectCode(), itsTeachers.get(indexT));
                    }
                }


        }
    }

    private static void addTeachers() {

        for(int i=1;i<=teachers;i++)
        {
            teachersName.put((long) i,"Teacher "+i);
            Random random=new Random();
            Integer[] rands= new Integer[subjectsNum];
            for(int j=0;j<subjectsNum;j++)
            {
                int randIndex = random.nextInt(subjects.size());
                rands[j]=subjects.get(randIndex).getSubjectCode();
            }
            teacherSubjects.put((long) i,rands);
        }
    }



//    private static HashMap<String,HashMap<Integer,TimeTableLesson[]>> classesTimeTables=new HashMap<>();
//
//    private static HashMap<Long,HashMap<Integer,TimeTableLesson[]>> teachersTimeTables=new HashMap<>();

    private static void generateTimeTable() {
        for(int i:grades) {
            for (String j : streams) {
                HashMap<Integer,TimeTableLesson[]> currect=new HashMap<>();
                String joint=i+j;
                HashMap<Integer, Long> ourTeachers = subjectTeachers.get(joint);
                //days
                HashMap<Integer,TimeTableLesson[]> classTimeTable=new HashMap<>();

                for(int k=0;k<days;k++)
                {
                    TimeTableLesson[] timeTableLesson=new TimeTableLesson[lessonsPerDay];
                    int btrials=0;
                    int bmaxtrials=500;

                    for(int lIndx=0;lIndx<9;lIndx++)
                    {
                        Random random=new Random();
                        int nextSubject=-1;
                        Long teacher=0L;
                        int trials=0;
                        int maxTrials=1500;
                        do {
                            trials++;
                            int nextIndex=random.nextInt(subjects.size());
                            nextSubject=subjects.get(nextIndex).getSubjectCode();
                            teacher=ourTeachers.get(nextSubject);
                        }while((!hasNotHeldThatLesson(timeTableLesson,nextSubject)||teacherEngaged(teacher,k,lIndx))&&trials<maxTrials);

                        if(trials<maxTrials) {
                            timeTableLesson[lIndx] = new TimeTableLesson(teacher, i * 1.0, j, nextSubject, k, lIndx, 40.0);
//                        addTeacherEngagement

                            classTimeTable.put(k,timeTableLesson);

                            if(teacher!=null)
                            {
                                teachersTimeTables.get(teacher).get(k)[lIndx] = timeTableLesson[lIndx];
                            }
                        }
                        else{
                            btrials++;
                            if(btrials<bmaxtrials) {
                                for(int del=0;del<lIndx;del++) {
                                    timeTableLesson[del] = null;
                                    if(teacher!=null)
                                        teachersTimeTables.get(teacher).get(k)[del]=null;
                                }
                                lIndx = -1;
                            }
                        }

                    }

                }
                classesTimeTables.put(i+j,classTimeTable);

                System.out.println("Finished "+joint);

            }
        }

    }

    private static boolean teacherEngaged(Long teacher, int day, int lesson) {
//        System.out.println(String.format("teacher : %s , day:%d,lesson:%d",teacher,day,lesson));
        if(teacher==null)
            return false;
        return teachersTimeTables.get(teacher).get(day)[lesson]!=null;
    }

    private static boolean hasNotHeldThatLesson(TimeTableLesson[] timeTableLesson, int nextSubject) {
        for(TimeTableLesson l:timeTableLesson)
            if(l!=null&&l.getSubjectCode()==nextSubject)
                return false;
        return true;
    }

    private static  String[] dayNames={
            "MONDAY",
            "TUESDAY",
            "WEDNESDAY",
            "THURSDAY",
            "FRIDAY"
    };

    private static void printTimeTable() {
        try{
            FileOutputStream fileOutputStream=new FileOutputStream("/home/patrick/Documents/trashes/timeTable.pdf");
            Document document=new Document(PageSize.A4.rotate());
            PdfWriter.getInstance(document,fileOutputStream);

            document.open();
            document.newPage();
            for(int i:grades) {
                for (String j : streams) {
                    document.newPage();
                    PdfPTable timeTable=new PdfPTable(10);
                    HashMap<Integer, TimeTableLesson[]> classTimeTable = classesTimeTables.get(i + j);
                    if(classTimeTable==null)
                        continue;

                    for (int d:classTimeTable.keySet())
                    {
                        timeTable.addCell(dayNames[d]);

                        for(TimeTableLesson l:classTimeTable.get(d))
                        {
                            if(l!=null)
                                timeTable.addCell(studySubjectsRepository.findBySubjectCode(l.getSubjectCode()).getSubjectRep());
                            else
                                timeTable.addCell("UnAvailable");
                        }
                    }
                    document.add(new Paragraph("Class "+i+j));
                    timeTable.setWidthPercentage(100);
                    timeTable.setSpacingBefore(40);
                    document.add(timeTable);

                }
            }



            document.close();
        }catch (Exception es)
        {
            es.printStackTrace();
        }
    }


    private static void printTeacherTimeTable() {
        try{
            FileOutputStream fileOutputStream=new FileOutputStream("/home/patrick/Documents/trashes/TeachersTimeTable.pdf");
            Document document=new Document(PageSize.A4.rotate());
            PdfWriter.getInstance(document,fileOutputStream);
            document.open();
            document.newPage();

            for(Long teacher:teachersTimeTables.keySet())
            {
                document.newPage();
                document.add(new Paragraph(teachersName.get(teacher)));

                PdfPTable teacherTable=new PdfPTable(10);
                for(int day:teachersTimeTables.get(teacher).keySet())
                {
                    teacherTable.addCell(dayNames[day]);
                    for(TimeTableLesson l:teachersTimeTables.get(teacher).get(day))
                    {
                        if(l!=null)
                        {
                            teacherTable.addCell(studySubjectsRepository.findBySubjectCode(l.getSubjectCode()).getSubjectRep()+"\n"+((int)(l.getGrade()/1))+l.getStream());
                        }
                        else
                        {
                            teacherTable.addCell(" ");
                        }
                    }
                }
                teacherTable.setWidthPercentage(100);
                teacherTable.setSpacingBefore(40);

                document.add(teacherTable);

            }



            document.close();
        }catch (Exception es)
        {
            es.printStackTrace();
        }
    }
}
