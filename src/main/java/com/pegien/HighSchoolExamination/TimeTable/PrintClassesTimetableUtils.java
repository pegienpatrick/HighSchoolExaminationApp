package com.pegien.HighSchoolExamination.TimeTable;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.pegien.HighSchoolExamination.StudySubjects.StudySubject;
import com.pegien.HighSchoolExamination.TimeTable.Slots.SlotType;
import com.pegien.HighSchoolExamination.TimeTable.Slots.TimeTableSlot;
import com.pegien.HighSchoolExamination.TimeTable.TimeTableLesson.TimeTableLesson;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.pegien.HighSchoolExamination.TimeTable.TimeTableUtils.*;

public class PrintClassesTimetableUtils
{
    public static void printTimeTable() {
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
                    PdfPTable timeTable=new PdfPTable(slots.length+1);
                    HashMap<Integer, TimeTableLesson[]> classTimeTable = classesTimeTables.get(i + j);
                    if(classTimeTable==null)
                        continue;

                    //Add Big Title

                    Font headFont=new Font(Font.FontFamily.HELVETICA,20,Font.BOLD,BaseColor.BLUE);
                    Paragraph phrase= new Paragraph("Class "+i+j,headFont);
                    phrase.setFont(headFont);

                    PdfPCell pdfPCell=new PdfPCell(phrase);
                    pdfPCell.setFixedHeight(30);
                    pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    pdfPCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    pdfPCell.setColspan(slots.length+1);



                    timeTable.addCell(pdfPCell);




                    timeTable.addCell("");
                    //prnt Times
                    for(TimeTableSlot s:slots)
                    {
                        Phrase timePhrase=new Phrase(s.getStart()+" - "+s.getEnd());
                        PdfPCell timeCell=new PdfPCell(timePhrase);
                        timeCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        timeCell.setHorizontalAlignment(Element.ALIGN_CENTER);

                        timeTable.addCell(timeCell);
                    }



                    Boolean hasBreaks=false;
                    for (int d:classTimeTable.keySet())
                    {

                        Font dayFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.BLUE);
                        Paragraph dayPhrase = new Paragraph(dayNames[d], dayFont); // Set font during paragraph creation
                        PdfPCell dayCell = new PdfPCell(dayPhrase);

                        dayCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        dayCell.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        timeTable.addCell(dayCell);

                        Boolean lastDouble=false;



                        TimeTableLesson[] allLessons=classTimeTable.get(d);
//                        for(TimeTableLesson l:)
//                        {
//                            if(lastDouble)
//                            {
//                                lastDouble=false;
//                                continue;
//                            }
//
//
//                            if(l.getIsDouble())
//                                lastDouble=true;
//
//                            printLesson(l,timeTable,representing);
//                        }
                        int lessonIndex=0;
                        for(int indexSlot=0;indexSlot<slots.length;indexSlot++)
                        {
                            TimeTableSlot cSlot=slots[indexSlot];
                            if(cSlot.getSlotType()== SlotType.LESSON)
                            {
                                TimeTableLesson l=allLessons[lessonIndex];
                                if(l!=null)
                                {
                                    if (lastDouble) {
                                        lastDouble = false;

                                    }
                                    else {

                                        if (l.getIsDouble())
                                            lastDouble = true;

                                        printLesson(l, timeTable, representing);
                                    }
                                }
                                else
                                    timeTable.addCell(" XXXXXXXX ");

                                lessonIndex++;
                            }
                            else {//for Breaks
                                if(!hasBreaks)
                                {

                                    Paragraph breakPhrase=new Paragraph(cSlot.getTitle());

//                                    breakPhrase.


                                    PdfPCell breakCell=new PdfPCell();
                                    breakCell.setRowspan(days);
//                                    breakCell.setRotation(270);
                                    breakCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                                    breakCell.setHorizontalAlignment(Element.ALIGN_CENTER);

                                    for(char l:cSlot.getTitle().toUpperCase().toCharArray()) {
                                        Paragraph paragraph=new Paragraph(l + "");
                                        paragraph.setAlignment(Element.ALIGN_CENTER);
                                        paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN,13,Font.BOLD,BaseColor.BLUE));
                                        breakCell.addElement(paragraph);
                                    }


                                    timeTable.addCell(breakCell);
                                }

                            }
                        }
                        hasBreaks=true;

                    }
//                    document.add(new Paragraph("Class "+i+j));
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

    private static void printLesson(TimeTableLesson l, PdfPTable timeTable, HashMap<Integer, List<Integer>> representing) {
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
//                lastDouble=true;
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
