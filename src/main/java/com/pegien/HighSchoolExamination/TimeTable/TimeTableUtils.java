package com.pegien.HighSchoolExamination.TimeTable;//package com.pegien.HighSchoolExamination.TimeTable;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.VerticalText;
import com.pegien.HighSchoolExamination.StudySubjects.StudySubject;
//import com.pegien.HighSchoolExamination.StudySubjects.DummyRepo;
import com.pegien.HighSchoolExamination.TimeTable.TimeTableLesson.TimeTableLesson;
import org.springframework.security.access.method.P;

import java.io.File;
import java.io.FileOutputStream;
import java.util.*;
import java.util.List;

public class TimeTableUtils {

//    private static DummyRepo DummyRepo=new DummyRepo();
    public static HashMap<String, HashMap<Integer,Long>> subjectTeachers=new HashMap<>();

    private static HashMap<String,HashMap<Integer,TimeTableLesson[]>> classesTimeTables=new HashMap<>();

    private static HashMap<Long,HashMap<Integer,TimeTableLesson[]>> teachersTimeTables=new HashMap<>();

    public static HashMap<String,HashMap<Integer,TimeTableLesson[]>> venues=new HashMap<>();

    private static int teachers=25;
    private static int subjectsNum=2;

    static List<StudySubject> subjects=DummyRepo.allAvailable();


    public static HashMap<Long,String> teachersName=new HashMap<>();

    public static HashMap<Long, int[]> teacherSubjects=new HashMap<Long, int[]>();


    private static String[] streams={"A","B","C"};

    private static int[] grades={4,3,2,1};

    private static int days=5;
    private static int lessonsPerDay=9;

    public static HashMap<Integer,HashMap<Integer,Integer>> lessonsPerWeek=new HashMap<>();

    public static HashMap<Integer,HashMap<Integer,String>> subjectVenues=new HashMap<>();

    public static HashMap<Integer,HashMap<Integer,String>> practicalSubjects=new HashMap<>();

    public static HashMap<Integer,List<Integer>> streamJointSubjects=new HashMap<>();

    public static List<Integer> selectedSubjectsGrades= new ArrayList<>();//Arrays.asList(3, 4);


    public static void main(String[] args)
    {
//        addTeachers();
//        addSubjectTeachers();

        printAllTeachers();
        printClassesAndTeachers();
        prepareTeacherEngagements();
//        generateTimeTable();
        SubjectWiseTimeTable();
        printTimeTable();
        printTeacherTimeTable();
        printVenuesTimeTable();

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
                System.out.print( DummyRepo.findBySubjectCode(j).getSubjectRep()+" : "+teachersName.get(subjectTeachers.get(i).get(j))+", ");
        }
    }

    private static void printAllTeachers() {
        for(Long i:teachersName.keySet()) {
            System.out.print(String.format("\n%d. Teacher Name : %s Teaching Subjects : ", i,teachersName.get(i)));
            try {
                for (int j : teacherSubjects.get(i))
                    System.out.print(String.format(" %s , ", DummyRepo.findBySubjectCode(j).getSubjectRep()));
            }catch (Exception es){}
        }
    }

    private static void addSubjectTeachers() {
        Random random=new Random();

        for(StudySubject s:subjects)
        {//fetch techers for that subject.
            List<Long> itsTeachers=new ArrayList<>();
            if(s.getSubjectCode()!=999)
            {
                for (Long i : teacherSubjects.keySet())
                    for (Integer j : teacherSubjects.get(i))
                        if (Objects.equals(j, s.getSubjectCode()))
                            itsTeachers.add(i);
            }
            else
                itsTeachers.addAll(teacherSubjects.keySet());

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
                    else
                        System.out.println(" Subject "+s.getSubjectRep()+" Lacked Teachers");
                }
        }
    }

    private static void addTeachers() {

        int[][] teachSubjects={
                {101},
                {231,233},
                {121,232},
                {102,311},
                {311,314},
                {451},
                {121,565},
                {312,565},
                {503},
                {231,443},
        } ;
        for(int i=1;i<=teachers;i++)
        {
            teachersName.put((long) i,"Teacher "+i);
            Random random=new Random();
            int[] rands= teachSubjects[random.nextInt(teachSubjects.length)];
//            new int[subjectsNum];
//            for(int j=0;j<subjectsNum;j++)
//            {
//                int randIndex = random.nextInt(subjects.size());
//                rands[j]=subjects.get(randIndex).getSubjectCode();
//            }
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
                            timeTableLesson[lIndx] = new TimeTableLesson(teacher, i * 1.0, j, nextSubject, k, lIndx, 40.0,false,null);
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

    private static boolean classEngaged(String classStream, int day, int lesson) {

        Boolean ans = classesTimeTables.get(classStream).get(day)[lesson]!=null;
//        System.out.println(String.format("Class : %s , day:%d,lesson:%d Result %s, what : %s",classStream,day,lesson,ans,classesTimeTables.get(classStream).get(day)[lesson]));
        return ans;
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


    public static String timetablefolder="./timetableFolder/";

    private static void printTimeTable() {
        List<Integer> repreSentedSubject=new ArrayList<>();

        HashMap<Integer,List<Integer>> representing=new HashMap<>();

        for(int form=1;form<=4;form++) {
            if (selectedSubjectsGrades.contains(form)) {
                for (String catg : DummyRepo.selectionOptions().keySet()) {
                    StudySubject[] all = DummyRepo.selectionOptions().get(catg);
                    int index = all[0].getSubjectCode();
                    List<Integer> represented = new ArrayList<>();
                    for (int m = 1; m < all.length; m++)
                        represented.add(all[m].getSubjectCode());
                    repreSentedSubject.addAll(represented);
                    representing.put(index, represented);
                }
            }
        }

        try{
            try{
                new File(timetablefolder).mkdirs();

            }catch (Exception esss){}
            FileOutputStream fileOutputStream=new FileOutputStream(new File(timetablefolder,"classtimeTable.pdf"));
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
                        Boolean lastDouble=false;
                        for(TimeTableLesson l:classTimeTable.get(d))
                        {
                            if(lastDouble)
                            {
                                lastDouble=false;
                                continue;
                            }

                            if(l!=null) {
                                PdfPCell pdfPCell=null;
                                if(selectedSubjectsGrades.contains((int)(l.getGrade()/1))&&representing.containsKey(l.getSubjectCode()))
                                {
                                    int height=60/(representing.get(l.getSubjectCode()).size()+1);
                                   PdfPTable dmTable=new PdfPTable(1);
                                   PdfPCell rep;
                                   Phrase phrase=new Phrase(Phrase.getInstance(DummyRepo.findBySubjectCode(l.getSubjectCode()).getSubjectRep()));
//                                   Cell cell
                                    rep = new PdfPCell(phrase);
                                    rep.setHorizontalAlignment(Element.ALIGN_CENTER);
                                   rep.setVerticalAlignment(Element.ALIGN_CENTER);
                                   rep.setFixedHeight(height);
                                   dmTable.addCell(rep);
                                    rep.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                                   int all=1;
                                   for(Integer ll:representing.get(l.getSubjectCode())) {
//                                       (DummyRepo.findBySubjectCode(ll).getSubjectRep());
//                                       PdfPCell rep;
                                       rep = new PdfPCell(Phrase.getInstance(DummyRepo.findBySubjectCode(ll).getSubjectRep()));

                                       rep.setHorizontalAlignment(Element.ALIGN_CENTER);
                                       rep.setVerticalAlignment(Element.ALIGN_MIDDLE);
                                       rep.setFixedHeight(height);
                                       dmTable.addCell(rep);
                                   }

//                                   timeTable.addCell(dmTable);
//                                    dmTable.set
                                    pdfPCell=new PdfPCell(dmTable);
//                                   pdfPCell.setFixedHeight();
                                }
                                else
                                    pdfPCell=new PdfPCell(Phrase.getInstance(DummyRepo.findBySubjectCode(l.getSubjectCode()).getSubjectRep()));

                                if(l.getIsDouble()) {
                                    pdfPCell.setColspan(2);
                                    lastDouble=true;
                                }
                                pdfPCell.setFixedHeight(60);
                                pdfPCell.setMinimumHeight(60);

                                pdfPCell.setVerticalAlignment(Element.ALIGN_CENTER);
                                pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                                pdfPCell.setVerticalAlignment(Element.ALIGN_MIDDLE);

                                timeTable.addCell(pdfPCell);
                            }
                            else
                                timeTable.addCell("XXXXXXXXXXXXXXXXX");
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
            FileOutputStream fileOutputStream=new FileOutputStream(new File(timetablefolder,"TeachersTimeTable.pdf"));
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
                            teacherTable.addCell(DummyRepo.findBySubjectCode(l.getSubjectCode()).getSubjectRep()+"\n"+((int)(l.getGrade()/1))+l.getStream());
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

    private static void printVenuesTimeTable() {

        try{
            FileOutputStream fileOutputStream=new FileOutputStream(new File(timetablefolder,"venuesTimeTable.pdf"));
            Document document=new Document(PageSize.A4.rotate());
            PdfWriter.getInstance(document,fileOutputStream);
            document.open();
            document.newPage();

            for(String venue:venues.keySet())
            {
                document.newPage();
                document.add(new Paragraph(venue));

                PdfPTable teacherTable=new PdfPTable(10);
                for(int day:venues.get(venue).keySet())
                {
                    teacherTable.addCell(dayNames[day]);
                    for(TimeTableLesson l:venues.get(venue).get(day))
                    {
                        if(l!=null)
                        {
                            teacherTable.addCell(DummyRepo.findBySubjectCode(l.getSubjectCode()).getSubjectRep()+"\n"+((int)(l.getGrade()/1))+l.getStream());
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



    private static void setLessonsPerWeek() {

        for(int form=1;form<=4;form++)
        {
            HashMap<Integer,Integer> lessons=new HashMap<>();
            int j=0;
            for(StudySubject i: DummyRepo.allAvailable())
            {
                j++;
                int num;
                if(j<=3)
                    num=6;
                else if(j<=5)
                    num=5;
                else if(j<=12)
                    if(selectedSubjectsGrades.contains(form))
                        num=5;
                    else
                        num=3;
                else
                    num=1;

                lessons.put(i.getSubjectCode(),num);
            }

            lessonsPerWeek.put(form,lessons);
        }

        setSubjectVenues();

        setPracticalSubjects();


        setStreamJointSubjects();


    }

    private static void setStreamJointSubjects() {
        List<Integer> joints=new ArrayList<>();
        for(StudySubject[] sa:DummyRepo.selectionOptions().values())
            for(StudySubject s:sa)
                joints.add(s.getSubjectCode());

        for(int form:selectedSubjectsGrades)
            streamJointSubjects.put(form,joints);
    }

    private static void setPracticalSubjects() {
//        practicalSubjects.put(231,"Bio Lab");
//        practicalSubjects.put(232,"Phy Lab");
//        practicalSubjects.put(233,"Chem Lab");
    }

    private static void setSubjectVenues() {
//        subjectVenues.put(451,"Comp Lab");
    }



    private static boolean subjectOverLoaded(String s, int subj, int day, int lesson) {
        TimeTableLesson[] lessonsInDay=classesTimeTables.get(s).get(day);
        int subjectsInADay=0;
        for(TimeTableLesson l:lessonsInDay)
            if(l!=null&&l.getSubjectCode()==subj)
                subjectsInADay++;

        if (lesson > 0 &&lessonsInDay[lesson - 1]!=null&& lessonsInDay[lesson - 1].getSubjectCode() == subj)
            return true;

        if(subjectsInADay>5) {
            return (subjectsInADay>1);
        }
        else
            return subjectsInADay>0;
    }


///    private static HashMap<Long,HashMap<Integer,TimeTableLesson[]>> teachersTimeTables=new HashMap<>();
//
//    private static HashMap<String,HashMap<Integer,TimeTableLesson[]>> venues=new HashMap<>();

    private static void clearTeacherScedule(int form) {
        HashMap<Long,HashMap<Integer,TimeTableLesson[]>> tobe=new HashMap<>();
        for(Long teacher:teachersTimeTables.keySet())
        {
            tobe.put(teacher,new HashMap<>());
            for(int day=0;day<days;day++)
            {
                TimeTableLesson[] newtimeTableLessons=new TimeTableLesson[lessonsPerDay];
                for(int l=0;l<teachersTimeTables.get(teacher).get(day).length;l++)
                {
                    if(teachersTimeTables.get(teacher).get(day)[l]!=null&&teachersTimeTables.get(teacher).get(day)[l].getGrade()!=form)
                        newtimeTableLessons[l]=teachersTimeTables.get(teacher).get(day)[l];
                }
                tobe.get(teacher).put(day,newtimeTableLessons);
            }
        }
        teachersTimeTables=tobe;
    }

    private static void clearVenuesShedule(int form) {
        HashMap<String,HashMap<Integer,TimeTableLesson[]>> newTobe=new HashMap<>();
        for(String venue:venues.keySet())
        {
            newTobe.put(venue,new HashMap<>());
            for(int day=0;day<days;day++)
            {
                TimeTableLesson[] newtimeTableLessons=new TimeTableLesson[lessonsPerDay];
                for(int l=0;l<venues.get(venue).get(day).length;l++)
                {
                    if(venues.get(venue).get(day)[l]!=null&&venues.get(venue).get(day)[l].getGrade()!=form)
                        newtimeTableLessons[l]=venues.get(venue).get(day)[l];
                }
                newTobe.get(venue).put(day,newtimeTableLessons);
            }
        }
        venues=newTobe;
    }

    private static Boolean venueEngaged(String venue,int day,int lesson) {
        if(venue==null||venue.length()==0)
            return false;





//        System.out.println(venues.keySet());
//        System.out.println(String.format("Requesting venue : %s, day: %d ,lesson:%d",venue,day,lesson));
        return (venues.get(venue).get(day)
                [lesson]!=null);
    }


    private static void prepareVenuesEngagements() {
        List<String> venuesP=new ArrayList<>();
//        Collection<HashMap<Integer, String>> a = subjectVenues.values();
//        venuesP.addAll(getValuesFromMap(subjectVenues));
//        venuesP.addAll(getValuesFromMap(practicalSubjects));

//        for (Map<Integer, String> subjectVenue : subjectVenues.values()) {
//            venuesP.addAll(subjectVenue.values());
//        }
//
//        for (Map<Integer, String> practicalSubject : practicalSubjects.values()) {
//            venuesP.addAll(practicalSubject.values());
//        }
        for(int form=1;form<=4;form++)
        {
            venuesP.addAll(subjectVenues.get(form).values());
            venuesP.addAll(practicalSubjects.get(form).values());
        }


        for(String i:venuesP)
        {
            HashMap<Integer, TimeTableLesson[]> day=new HashMap<>();
            for(int d=0;d<days;d++) {
                day.put(d,new TimeTableLesson[lessonsPerDay]);
            }
            venues.put(i,day);
        }
    }



    private static void setDefaultClassTimeTable() {
        for(int form=4;form>0;form--) {
            for(String stream:streams)
            {
                HashMap<Integer,TimeTableLesson[]> lessons=new HashMap<>();
                for(int day=0;day<days;day++)
                {
                    lessons.put(day,new TimeTableLesson[lessonsPerDay]);
                }
                classesTimeTables.put(form+stream,lessons);
            }
        }
    }


    private static void SubjectWiseTimeTable() {
        prepareVenuesEngagements();
//        setLessonsPerWeek();
        setDefaultClassTimeTable();
        int spaces=lessonsPerDay*days;

        Random random=new Random();

        int fmaxTrials=0;
        int ftrial=0;

        int bestdefects=156;
//        HashMap<String,HashMap<Integer,TimeTableLesson[]>> bestTimeTable=new HashMap<>();
        HashMap<Integer,HashMap<String,HashMap<Integer,TimeTableLesson[]>>> bestClassTimeTable=new HashMap<>();
        HashMap<Integer,HashMap<Long,HashMap<Integer,TimeTableLesson[]>>> bestTeacherTimeTable=new HashMap<>();
        HashMap<Integer,HashMap<String,HashMap<Integer,TimeTableLesson[]>>> bestVenueTimeTable=new HashMap();



        for(int form=4;form>0;form--)
        {
            ftrial++;
            int defects=0;
            Boolean hasDefect=false;
            HashMap<Integer,Integer> lessons=lessonsPerWeek.get(form);

            List<Integer> repreSentedSubject=new ArrayList<>();

            HashMap<Integer,List<Integer>> representing=new HashMap<>();

            if(selectedSubjectsGrades.contains(form)) {
                for (String catg : DummyRepo.selectionOptions().keySet()) {
                    StudySubject[] all=DummyRepo.selectionOptions().get(catg);
                    int index=all[0].getSubjectCode();
                    List<Integer> represented=new ArrayList<>();
                    for(int m=1;m<all.length;m++)
                        represented.add(all[m].getSubjectCode());
                    repreSentedSubject.addAll(represented);
                    representing.put(index,represented);
                }
            }




            List<Integer> joint_subjects;
            if(streamJointSubjects.containsKey(form))
                joint_subjects=streamJointSubjects.get(form);
            else
                joint_subjects=new ArrayList<>();

            if(lessons==null) {

                System.out.println(lessonsPerWeek.keySet());
                continue;
            }
            for(int subj:lessons.keySet()) {
                if(repreSentedSubject.contains(subj))
                    continue;

                int doubles = 0;
                {//double session searching
                    if (practicalSubjects.get(form).containsKey(subj)) {//locate Double subjects
                        doubles = 2;

                        for (String stream : streams) {//looking for double lessons

                            if(joint_subjects.contains(subj)&&!stream.equals(streams[0]))
                                continue;
                            int day, lesson, trial = 0, matTrials = 1500;
                            Long teacher;
                            String joint = form + stream;
                            String venue;
                            Boolean inValidFirst, inValidSecond,otherStreams;
                            venue = practicalSubjects.get(form).get(subj);
                            try {
                                teacher = subjectTeachers.get(joint).get(subj);
                            }catch (Exception es){
                                teacher=null;
                            }

                            List<Integer> subjectsToCheck=new ArrayList<>();
                            subjectsToCheck.add(subj);
                            if(representing.containsKey(subj))
                                subjectsToCheck.addAll(representing.get(subj));

                            int nextLesson;

                            do {
                                trial++;
//                            int space=random.nextInt(spaces);
//                            System.out.println("Subject : "+DummyRepo.findBySubjectCode(subj).getSubjectRep()+" Class "+form+stream+" Space "+space);
                                day = random.nextInt(days);
                                lesson = random.nextInt(lessonsPerDay - 1);
                                nextLesson=lesson+1;


                                otherStreams=false;

                                for(int subjectToCheck:subjectsToCheck) {
                                    Long newTeacher;
                                    try {

                                        newTeacher = subjectTeachers.get(joint).get(subjectToCheck);
                                    }catch (Exception es){
                                        newTeacher=null;
                                    }
                                    String newVenue="";
                                    if(practicalSubjects.get(form).containsKey(subjectToCheck))
                                        newVenue=practicalSubjects.get(form).get(subjectToCheck);

                                    inValidFirst = classEngaged(joint, day, lesson) || teacherEngaged(newTeacher, day, lesson) || venueEngaged(newVenue, day, lesson);
                                    inValidSecond = classEngaged(joint, day, nextLesson) || teacherEngaged(newTeacher, day, nextLesson) || venueEngaged(newVenue, day, nextLesson);

                                    otherStreams = inValidFirst || inValidSecond;

                                    if (joint_subjects.contains(subjectToCheck) && !stream.equalsIgnoreCase(streams[0]) && !otherStreams) {
                                        for (String streamIn : streams) {
                                            if (!streamIn.equals(streams[0]) && !otherStreams) {
                                                Boolean inValidFirstIn = classEngaged(form + streamIn, day, lesson);
                                                Boolean inValidSecondIn = classEngaged(form + streamIn, day, nextLesson);
                                                if (!otherStreams)
                                                    otherStreams = inValidSecondIn || inValidFirstIn;
                                            }
                                        }
                                    }
                                    if(otherStreams)
                                        break;;
                                }


                            } while ((otherStreams) && trial < matTrials);

                            if (trial < matTrials)//successful
                            {
                                TimeTableLesson abve = new TimeTableLesson(teacher, form * 1.0, stream, subj, day, lesson, 40.0 * 2, true, venue);
                                TimeTableLesson abve1 = new TimeTableLesson(teacher, form * 1.0, stream, subj, day, nextLesson, 40.0 * 2, true, venue);

                                if(joint_subjects.contains(subj))
                                {//write incase of joint subjects;
                                    for(String polishStream:streams)
                                    {
                                        classesTimeTables.get(form+polishStream).get(day)[lesson] = abve;
                                        classesTimeTables.get(form+polishStream).get(day)[nextLesson] = abve1;
                                    }

                                }else{
                                classesTimeTables.get(joint).get(day)[lesson] = abve;
                                classesTimeTables.get(joint).get(day)[nextLesson] = abve1;
                                 }
                                for(int subjectToVenue:subjectsToCheck) {
                                    String newVenue=null;
                                    if(practicalSubjects.get(form).containsKey(subjectToVenue))
                                        newVenue=practicalSubjects.get(form).get(subjectToVenue);

                                    if (newVenue != null) {
                                        venues.get(newVenue).get(day)[lesson] = abve;
                                        venues.get(newVenue).get(day)[nextLesson] = abve1;
                                    }

                                    Long newTeacher=null;
                                    try {
                                        if (subjectTeachers.get(joint).containsKey(subjectToVenue))
                                            newTeacher = subjectTeachers.get(joint).get(subjectToVenue);
                                    }catch (Exception es){}
                                    if (newTeacher != null) {//set Teacher Occupied
                                        teachersTimeTables.get(newTeacher).get(day)[lesson] = abve;
                                        teachersTimeTables.get(newTeacher).get(day)[nextLesson] = abve1;
                                    }
                                }
                            } else {
                                hasDefect = true;
                                defects++;
                            }
                        }

                    }
                }
            }
            for(int subj:lessons.keySet())
            {
                if(repreSentedSubject.contains(subj))
                    continue;

                int doubles = 0;
                //double session searching
                    if (practicalSubjects.get(form).containsKey(subj)) {//locate Double subjects
                        doubles = 2;
                    }

                for(int lessonCount=0;lessonCount<lessons.get(subj)-doubles;lessonCount++) {
                    for (String stream : streams) {

                        if(joint_subjects.contains(subj)&&!stream.equals(streams[0]))
                            continue;
                        int day, lesson, trial = 0, matTrials = 600;
                        Long teacher;
                        String joint = form + stream;
                        String venue;
                        Boolean inValidFirst, inValidSecond,otherStreams;
                        venue = practicalSubjects.get(form).get(subj);
                        try {
                            teacher = subjectTeachers.get(joint).get(subj);
                        }catch (Exception es)
                        {
                            teacher=null;
                        }

                        List<Integer> subjectsToCheck=new ArrayList<>();
                        subjectsToCheck.add(subj);
                        if(representing.containsKey(subj))
                            subjectsToCheck.addAll(representing.get(subj));

                        int nextLesson;

                        do {
                            trial++;
//                            int space=random.nextInt(spaces);
//                            System.out.println("Subject : "+DummyRepo.findBySubjectCode(subj).getSubjectRep()+" Class "+form+stream+" Space "+space);
                            day = random.nextInt(days);
                            lesson = random.nextInt(lessonsPerDay);
                            nextLesson=lesson;


                            otherStreams=false;

                            for(int subjectToCheck:subjectsToCheck) {
                                Long newTeacher=null;
                                try {
                                    newTeacher = subjectTeachers.get(joint).get(subjectToCheck);
                                }catch (Exception es){}
                                String newVenue="";
                                if(practicalSubjects.get(form).containsKey(subjectToCheck))
                                    newVenue=practicalSubjects.get(form).get(subjectToCheck);

                                inValidFirst = classEngaged(joint, day, lesson) || teacherEngaged(newTeacher, day, lesson) || venueEngaged(newVenue, day, lesson);
                                inValidSecond =subjectOverLoaded(form+stream,subj,day,lesson); //classEngaged(joint, day, nextLesson) || teacherEngaged(newTeacher, day, nextLesson) || venueEngaged(newVenue, day, nextLesson);

                                otherStreams = inValidFirst || inValidSecond;

                                if (joint_subjects.contains(subjectToCheck) && !stream.equalsIgnoreCase(streams[0]) && !otherStreams) {
                                    for (String streamIn : streams) {
                                        if (!streamIn.equals(streams[0]) && !otherStreams) {
                                            Boolean inValidFirstIn = classEngaged(form + streamIn, day, lesson);
                                            Boolean inValidSecondIn = subjectOverLoaded(form+streamIn,subj,day,lesson);
                                            if (!otherStreams)
                                                otherStreams = inValidSecondIn || inValidFirstIn;
                                        }
                                    }
                                }
                                if(otherStreams)
                                    break;;
                            }


                        } while ((otherStreams) && trial < matTrials);

                        if (trial < matTrials)//successful
                        {
                            TimeTableLesson abve = new TimeTableLesson(teacher, form * 1.0, stream, subj, day, lesson, 40.0 , false, "");
                            TimeTableLesson abve1 = new TimeTableLesson(teacher, form * 1.0, stream, subj, day, nextLesson, 40.0 , false, "");

                            if(joint_subjects.contains(subj))
                            {//write incase of joint subjects;
                                for(String polishStream:streams)
                                {
                                    classesTimeTables.get(form+polishStream).get(day)[lesson] = abve;
                                    classesTimeTables.get(form+polishStream).get(day)[nextLesson] = abve1;
                                }

                            }else{
                                classesTimeTables.get(joint).get(day)[lesson] = abve;
                                classesTimeTables.get(joint).get(day)[nextLesson] = abve1;
                            }
                            for(int subjectToVenue:subjectsToCheck) {
                                String newVenue=null;
                                if(subjectVenues.get(form).containsKey(subjectToVenue))
                                    newVenue=subjectVenues.get(form).get(subjectToVenue);

                                if (newVenue != null) {
                                    venues.get(newVenue).get(day)[lesson] = abve;
                                    venues.get(newVenue).get(day)[nextLesson] = abve1;
                                }

                                Long newTeacher=null;
                                try {
                                    if (subjectTeachers.get(joint).containsKey(subjectToVenue))
                                        newTeacher = subjectTeachers.get(joint).get(subjectToVenue);
                                }catch (Exception es){}
                                if (newTeacher != null) {//set Teacher Occupied
                                    teachersTimeTables.get(newTeacher).get(day)[lesson] = abve;
                                    teachersTimeTables.get(newTeacher).get(day)[nextLesson] = abve1;
                                }
                            }
                        } else {
                            hasDefect = true;
                            defects++;
                        }


//                        if(joint_subjects.contains(subj)&&!stream.equals(streams[0]))
//                            continue;
//                        int day,lesson,trial=0,matTrials=10000;
//                        Long teacher;
//                        String joint=form+stream;
//                        String venue;
//                        Boolean falted;
//                        do{
//                            trial++;
////                            int space=random.nextInt(spaces);
////                            System.out.println("Subject : "+DummyRepo.findBySubjectCode(subj).getSubjectRep()+" Class "+form+stream+" Space "+space);
//                            day=random.nextInt(days);
//                            lesson=random.nextInt(lessonsPerDay);
//                            teacher=subjectTeachers.get(joint).get(subj);
//                            venue=null;
//                            if(subjectVenues.get(form).containsKey(subj))
//                                venue=subjectVenues.get(subj);
//                            falted=false;
//
//                            falted=classEngaged(joint,day,lesson)||teacherEngaged(teacher,day,lesson)||subjectOverLoaded(form+stream,subj,day,lesson)||venueEngaged(venue,day,lesson);
//
//                            if(joint_subjects.contains(subj)&&!stream.equalsIgnoreCase(streams[0])&&!falted)
//                            {
//                                for(String streamIn:streams)
//                                {
//                                    if(!streamIn.equals(streams[0])&&!falted)
//                                    {
//                                        Boolean inValidFirstIn = classEngaged(form+streamIn, day, lesson);
//                                        Boolean inValidSecondIn = subjectOverLoaded(form+streamIn,subj,day,lesson);
//                                        if(!falted)
//                                            falted=inValidSecondIn||inValidFirstIn;
//                                    }
//                                }
//                            }
//
//                        }while (falted&&trial<matTrials);
//
//                        if(trial<matTrials)//successful
//                        {
//                            TimeTableLesson abve=new TimeTableLesson(teacher, form * 1.0, stream, subj, day, lesson, 40.0,false,venue);
////                            classesTimeTables.get(joint).get(day)[lesson]=abve;
//                            if(joint_subjects.contains(subj))
//                            {//write incase of joint subjects;
//                                for(String polishStream:streams)
//                                {
//                                    classesTimeTables.get(form+polishStream).get(day)[lesson] = abve;
//                                }
//                            }else{
//                                classesTimeTables.get(joint).get(day)[lesson] = abve;
//                            }
//
//                            if(venue!=null)
//                                venues.get(venue).get(day)[lesson]=abve;
//
//                            if(teacher!=null){//set Teacher Occupied
//                                teachersTimeTables.get(teacher).get(day)[lesson] =abve;
//                            }
//                        }
//                        else {
//                            hasDefect = true;
//                            defects++;
//                        }
                    }
                }
            }
            {//find best timetable version
                if(defects<bestdefects)
                {
                        bestdefects=defects;
//                    for(String stream:streams) {
//                        bestTimeTable.put(form+stream,classesTimeTables.get(form+stream));
                        bestClassTimeTable.put(form, (HashMap<String, HashMap<Integer, TimeTableLesson[]>>) classesTimeTables.clone());
                        bestTeacherTimeTable.put(form, (HashMap<Long, HashMap<Integer, TimeTableLesson[]>>) teachersTimeTables.clone());
                        bestVenueTimeTable.put(form, (HashMap<String, HashMap<Integer, TimeTableLesson[]>>) venues.clone());
//                        System.out.println("\n\nSaving Best to : \n"+bestClassTimeTable+" \n\n"+bestTeacherTimeTable+"\n\n"+bestVenueTimeTable);
//                    }
                }

            }
            if(hasDefect)
            {

                if(ftrial<fmaxTrials)
                {//delete data
                    for(String stream:streams)
                    {//delete class timeTable data
                        HashMap<Integer,TimeTableLesson[]> lessonsd=new HashMap<>();
                        for(int day=0;day<days;day++)
                        {
                            lessonsd.put(day,new TimeTableLesson[lessonsPerDay]);
                        }
                        classesTimeTables.put(form+stream,lessonsd);
                    }
                    {//clear teacher schedule
                        clearTeacherScedule(form);
                        clearVenuesShedule(form);
                    }
                    form++;
                    continue;
                }
            }
            System.out.println("\n Finished Form "+form);
            ftrial=0;

//            System.out.println("\n\n\n Retrieving Best as : \n"+bestClassTimeTable+" \n\n"+bestTeacherTimeTable+"\n\n"+bestVenueTimeTable);
            classesTimeTables=bestClassTimeTable.get(form);
            teachersTimeTables=bestTeacherTimeTable.get(form);
            venues=bestVenueTimeTable.get(form);

            bestdefects=156;
            defects=0;
            hasDefect=false;

//            bestTimeTable = new HashMap<>();
            bestClassTimeTable=new HashMap<>();
            bestTeacherTimeTable = new HashMap<>();
            bestVenueTimeTable = new HashMap<>();
        }
    }


}
