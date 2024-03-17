package com.pegien.HighSchoolExamination.TimeTable;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.pegien.HighSchoolExamination.TimeTable.Slots.SlotType;
import com.pegien.HighSchoolExamination.TimeTable.Slots.TimeTableSlot;
import com.pegien.HighSchoolExamination.TimeTable.TimeTableLesson.TimeTableLesson;

import java.io.File;
import java.io.FileOutputStream;

import static com.pegien.HighSchoolExamination.TimeTable.TimeTableUtils.*;

public class VenuesTimeTableUtils {

    public static void printVenuesTimeTable() {
        try{
            FileOutputStream fileOutputStream=new FileOutputStream(new File(timetablefolder,"venuesTimeTable.pdf"));
//            Document document=new Document(PageSize.A4.rotate());
            Document document=new Document(PageSize.A4.rotate());
            PdfWriter.getInstance(document,fileOutputStream);
            document.open();
            document.newPage();

            for(String venue:venues.keySet())
            {
                document.newPage();

//                document.add(new Paragraph(teachersName.get(teacher)));

                PdfPTable teacherTable=new PdfPTable(slots.length+1);

                Font headFont=new Font(Font.FontFamily.HELVETICA,20,Font.BOLD, BaseColor.BLUE);
                Paragraph phrase= new Paragraph("Venue : "+venue,headFont);
                phrase.setFont(headFont);

                PdfPCell pdfPCell=new PdfPCell(phrase);
                pdfPCell.setFixedHeight(30);
                pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                pdfPCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                pdfPCell.setColspan(slots.length+1);

                teacherTable.addCell(pdfPCell);


                teacherTable.addCell("");
                //prnt Times
                for(TimeTableSlot s:slots)
                {
                    Phrase timePhrase=new Phrase(s.getStart()+" - "+s.getEnd());
                    PdfPCell timeCell=new PdfPCell(timePhrase);
                    timeCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    timeCell.setHorizontalAlignment(Element.ALIGN_CENTER);

                    teacherTable.addCell(timeCell);
                }



                Boolean hasBreaks=false;

                for(int day:venues.get(venue).keySet())
                {
//                    teacherTable.addCell(dayNames[day]);
                    Font dayFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.BLUE);
                    Paragraph dayPhrase = new Paragraph(dayNames[day], dayFont); // Set font during paragraph creation
                    PdfPCell dayCell = new PdfPCell(dayPhrase);

                    dayCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    dayCell.setVerticalAlignment(Element.ALIGN_MIDDLE);

                    dayCell.setFixedHeight(60);

                    teacherTable.addCell(dayCell);

                    Boolean lastDouble=false;



                    TimeTableLesson[] allLessons=venues.get(venue).get(day);



//                    for(TimeTableLesson l:)
//                    {
//                        if(l!=null)
//                        {
//                            teacherTable.addCell(DummyRepo.findBySubjectCode(l.getSubjectCode()).getSubjectRep()+"\n"+((int)(l.getGrade()/1))+l.getStream());
//                        }
//                        else
//                        {
//                            teacherTable.addCell(" ");
//                        }
//                    }
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




                                    pdfPCell=new PdfPCell();
                                    Paragraph subject=new Paragraph(DummyRepo.findBySubjectCode(l.getSubjectCode()).getSubjectRep());
                                    subject.setAlignment(Element.ALIGN_CENTER);
                                    Paragraph classStream=new Paragraph(((int)(l.getGrade()/1))+l.getStream());
                                    classStream.setAlignment(Element.ALIGN_CENTER);

                                    pdfPCell.addElement(subject);
                                    pdfPCell.addElement(classStream);

                                    pdfPCell.setFixedHeight(60);
                                    pdfPCell.setMinimumHeight(60);

                                    pdfPCell.setVerticalAlignment(Element.ALIGN_CENTER);
                                    pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                                    pdfPCell.setVerticalAlignment(Element.ALIGN_MIDDLE);

                                    if (l.getIsDouble()) {
                                        lastDouble = true;
                                        pdfPCell.setColspan(2);
                                    }

                                    teacherTable.addCell(pdfPCell);

                                }
                            }
                            else
                                teacherTable.addCell("  ");

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


                                teacherTable.addCell(breakCell);
                            }

                        }
                    }
                    hasBreaks=true;
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


    //    private static void printVenuesTimeTable() {
//
//        try{
//            FileOutputStream fileOutputStream=new FileOutputStream(new File(timetablefolder,"venuesTimeTable.pdf"));
//            Document document=new Document(PageSize.A4.rotate());
//            PdfWriter.getInstance(document,fileOutputStream);
//            document.open();
//            document.newPage();
//
//            for(String venue:venues.keySet())
//            {
//                document.newPage();
//                document.add(new Paragraph(venue));
//
//                PdfPTable teacherTable=new PdfPTable(10);
//                for(int day:venues.get(venue).keySet())
//                {
//                    teacherTable.addCell(dayNames[day]);
//                    for(TimeTableLesson l:venues.get(venue).get(day))
//                    {
//                        if(l!=null)
//                        {
//                            teacherTable.addCell(DummyRepo.findBySubjectCode(l.getSubjectCode()).getSubjectRep()+"\n"+((int)(l.getGrade()/1))+l.getStream());
//                        }
//                        else
//                        {
//                            teacherTable.addCell(" ");
//                        }
//                    }
//                }
//                teacherTable.setWidthPercentage(100);
//                teacherTable.setSpacingBefore(40);
//
//                document.add(teacherTable);
//
//            }
//
//
//
//            document.close();
//        }catch (Exception es)
//        {
//            es.printStackTrace();
//        }
//    }
}
