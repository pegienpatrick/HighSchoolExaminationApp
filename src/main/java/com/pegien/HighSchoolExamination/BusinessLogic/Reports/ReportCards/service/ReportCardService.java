package com.pegien.HighSchoolExamination.BusinessLogic.Reports.ReportCards.service;


import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;
import com.pegien.HighSchoolExamination.BusinessLogic.Examination.Examination;
import com.pegien.HighSchoolExamination.BusinessLogic.Examination.ExaminationRepository;
import com.pegien.HighSchoolExamination.BusinessLogic.Examination.Marks.MarksRepository;
import com.pegien.HighSchoolExamination.BusinessLogic.Examination.Marks.service.MarksService;
import com.pegien.HighSchoolExamination.BusinessLogic.Examination.service.ExaminationService;
import com.pegien.HighSchoolExamination.BusinessLogic.Guardian.Guardian;
import com.pegien.HighSchoolExamination.BusinessLogic.Guardian.GuardianRepository;
import com.pegien.HighSchoolExamination.BusinessLogic.Notifications.sms.controller.SMSLog;
import com.pegien.HighSchoolExamination.BusinessLogic.Notifications.sms.controller.SMSLogRepository;
import com.pegien.HighSchoolExamination.BusinessLogic.Reports.MeritList.MeritListItem.MeritListLine;
import com.pegien.HighSchoolExamination.BusinessLogic.Reports.MeritList.MeritListItem.MeritListLineRepository;
import com.pegien.HighSchoolExamination.BusinessLogic.Reports.MeritList.service.MeritListService;
import com.pegien.HighSchoolExamination.BusinessLogic.Students.Student;
import com.pegien.HighSchoolExamination.BusinessLogic.Students.StudentPhotos.service.StudentPhotoService;
import com.pegien.HighSchoolExamination.BusinessLogic.Students.StudentRepository;
import com.pegien.HighSchoolExamination.BusinessLogic.Students.service.StudentsService;
import com.pegien.HighSchoolExamination.BusinessLogic.StudySubjects.StudySubject;
import com.pegien.HighSchoolExamination.BusinessLogic.StudySubjects.StudySubjectsRepository;
import com.pegien.HighSchoolExamination.BusinessLogic.StudySubjects.SubjectGrade.service.SubjectGradingService;
import com.pegien.HighSchoolExamination.BusinessLogic.Teachers.model.responses.ClassSubjectTeachers;
import com.pegien.HighSchoolExamination.BusinessLogic.Teachers.service.SubjectTeacherService;
import com.pegien.HighSchoolExamination.Utils.GradingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;


import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Service
public class ReportCardService {

    @Autowired
    private MarksService marksService;

    @Autowired
    private MeritListLineRepository meritListLineRepository;

    @Autowired
    private SubjectGradingService subjectGradingService;

    @Autowired
    private ExaminationRepository examinationRepository;

    @Autowired
    private StudentsService studentsService;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudySubjectsRepository studySubjectsRepository;


    @Autowired
    private ExaminationService examinationService;


    @Autowired
    private MeritListService meritListService;


    @Autowired
    private MarksRepository marksRepository;



    @Autowired
    private GuardianRepository guardianRepository;

    @Autowired
    private SMSLogRepository smsLogRepository;


    @Autowired
    private StudentPhotoService studentPhotoService;

    @Autowired
    private SubjectTeacherService subjectTeacherService;



    public static String schoolName="TAKABA BOYS` SECONDARY SCHOOL";
    public static String schoolEmail="takababoysch@gmail.com";

    public static String schoolMotto="DISCIPLINE AND SUCCESS";
    public static String addr="P.O BOX 101 - 70300, MANDERA";

    public static String schoolPhone="0722 841 386";

    public ResponseEntity<byte[]> viewReport(Long examination, int admNo) {
        try {
            // Generate the PDF report
            byte[] pdfBytes = generateStudentReport(examination, admNo);

            // Set the response headers
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", examination+"student"+admNo+"_report.pdf");

            return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<byte[]> viewBulkReport(Long examination, Double grade, String stream) {
        try {
            // Generate the PDF report
            byte[] pdfBytes = generatebulkReport(examination,grade,stream);

            // Set the response headers
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            String fileName = examination + " Form" + grade + stream + " reports.pdf";
            headers.setContentDispositionFormData("attachment", fileName);


            return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    private byte[] generateStudentReport(Long examination, int admNo) {
        Long start=System.currentTimeMillis();
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Document document = new Document();
            PdfWriter.getInstance(document, byteArrayOutputStream);

            document.open();

//            document.setMargins(20,10,10,20);
            addSchoolHeader(document);

            Optional<Examination> examination1=examinationRepository.findById(examination);
            if(examination1.isEmpty()) {
                System.out.println("exam Null");
                return null;
            }

           addExamTitle(document,examination1.get());

            Optional<Student> optionalStudent=studentRepository.findByAdmNo(admNo);
            if(optionalStudent.isEmpty())
            {
                System.out.println("Student Null");
                return null;
            }
            Student student=optionalStudent.get();


            MeritListLine meritListLine= meritListService.getMeritLine(student,examination,student.getStage());
            addStudentInfo(document,student,meritListLine);

            int classStudents=meritListLineRepository.countByStageAndExaminationOrderByClassRankAsc(meritListLine.getStage(),examination);
            int streamStudents=meritListLineRepository.countByStageAndExaminationAndStreamOrderByClassRankAsc(meritListLine.getStage(), examination,meritListLine.getStream());


           addTables(document,meritListLine,classStudents,streamStudents);


            addFooter(document,meritListLine,examination1.get());
            document.close();
            Long end=System.currentTimeMillis();
            Long duration=end-start;
            System.out.println(examination+" ,"+admNo+" Generate Report Took : "+duration);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public byte[] generatebulkReport(Long examination, Double stage,String stream) {
        Long start=System.currentTimeMillis();
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Document document = new Document();
            PdfWriter.getInstance(document, byteArrayOutputStream);

            document.open();

//            document.setMargins(20,10,10,20);

            Optional<Examination> examination1=examinationRepository.findById(examination);
            if(examination1.isEmpty())
                return null;

            int classStudents=meritListLineRepository.countByStageAndExaminationOrderByClassRankAsc(stage,examination);

            List<MeritListLine> meritListLines;
            if(stream==null||stream.length()==0||stream.trim().equalsIgnoreCase("All"))
                meritListLines=meritListService.viewMeritList(examination,stage);
            else
                meritListLines=meritListService.viewMeritList(examination,stage,stream);

            for(MeritListLine meritListLine:meritListLines)
            {
                addSchoolHeader(document);
                addExamTitle(document,examination1.get());

                Optional<Student> optionalStudent=studentRepository.findByAdmNo(meritListLine.getAdmNo());
                if(optionalStudent.isEmpty())
                {
                    System.out.println("Student Null");
                    return null;
                }
                Student student=optionalStudent.get();
                addStudentInfo(document,student,meritListLine);


                int streamStudents=meritListLineRepository.countByStageAndExaminationAndStreamOrderByClassRankAsc(stage, examination,meritListLine.getStream());

                addTables(document,meritListLine,classStudents,streamStudents);

                addFooter(document,meritListLine,examination1.get());

                document.newPage();
            }
            document.close();
            Long end=System.currentTimeMillis();
            Long duration=end-start;
            System.out.println(examination+" ,"+stage+stream+" Generate Reports Took : "+duration);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Image principle=null;

    private static Image stamp=null;



    private void addFooter(Document document,MeritListLine meritListLine,Examination examination) throws Exception {
        if(principle==null)
            principle=Image.getInstance(ReportCardService.class.getResourceAsStream("/signatures/principle.png").readAllBytes());

        if(stamp==null)
            stamp=Image.getInstance(ReportCardService.class.getResourceAsStream("/stamps/takaba.png").readAllBytes());

        Font boldFont = new Font(Font.FontFamily.COURIER, 11, Font.NORMAL);
        //class teacher sign
        PdfPTable pdfPTable=new PdfPTable(1);
        pdfPTable.setWidthPercentage(100);



        int rowHeight=40;
        String tt="ClassTeacher`s Remarks ";

        Long teach=subjectTeacherService.forceGetClassTeacher(meritListLine.getStage(),meritListLine.getStream()).getTeacher();
        if(teach!=null)
            tt+=" ("+subjectTeacherService.allTeacher().get(teach)+")";

        PdfPCell tchRemarks=CreateHeaderCell(tt);
//        tchRemarks.setFixedHeight(16);
        pdfPTable.addCell(  tchRemarks);
        pdfPTable.addCell(new Paragraph(GradingUtils.klassRemarks.getOrDefault(meritListLine.getAggregateGrade(),"Problem with your Results"),boldFont));



        pdfPTable.setSpacingBefore(4);

        document.add(pdfPTable);

        //headTeacher sign

        pdfPTable = new PdfPTable(2);
        pdfPTable.setWidthPercentage(100);
        pdfPTable.setWidths(new int[]{80, 20});



        pdfPTable.addCell( CreateHeaderCell2("Principle`s Remarks ( Mohamed Adan )") );
        pdfPTable.addCell(CreateHeaderCell2("Signature"));
//        addEmptyCell(pdfPTable,rowHeight);
//        addEmptyCell(pdfPTable,rowHeight);
        pdfPTable.addCell(new Paragraph(GradingUtils.principlesRemarks.getOrDefault(meritListLine.getAggregateGrade(),"Problem with your Results"),boldFont));

        PdfPCell principleCell=new PdfPCell(principle);
        principleCell.setFixedHeight(30);
        pdfPTable.addCell(principleCell);
        pdfPTable.setSpacingBefore(4);
        document.add(pdfPTable);


        PdfPTable msg=new PdfPTable(1);
        msg.setWidthPercentage(100);
        PdfPCell headerCell=CreateHeaderCell("Message");
//        headerCell.setFixedHeight(10);
        msg.addCell(headerCell);
        msg.addCell(new Paragraph(examination.getReportCardMsg(),boldFont));

        msg.setSpacingBefore(4);

        document.add(msg);

        stamp.setAbsolutePosition(document.getPageSize().getWidth()*2/3,80);
        stamp.scalePercent(30);

        document.add(stamp);

    }

    private PdfPCell CreateHeaderCell2(String s) {
        PdfPCell pdfPCell=CreateHeaderCell(s);
//        pdfPCell.setFixedHeight(16);
        return pdfPCell;
    }

    private void addEmptyCell(PdfPTable pdfPTable, int rowHeight) {
        PdfPCell pdfPCell=new PdfPCell();
        pdfPCell.setFixedHeight(rowHeight);
        pdfPTable.addCell(pdfPCell);
    }


    private void addTables(Document document, MeritListLine meritListLine, int classStudents, int streamStudents) throws Exception {
        PdfPTable table = new PdfPTable(5);
        Font boldFont = new Font(Font.FontFamily.COURIER, 12, Font.BOLD);


        table.setWidthPercentage(100);
        table.addCell(createPhrase2("Aggregate Grade",boldFont));
        table.addCell(createPhrase2("Aggregate Points",boldFont));
        table.addCell(createPhrase2("Stream Position",boldFont));
        table.addCell(createPhrase2("Overall Class Position",boldFont));
        table.addCell(createPhrase2("KCPE Marks",boldFont));

        table.addCell(createPhrase(meritListLine.getAggregateGrade(),boldFont));
        table.addCell(createPhrase(meritListLine.getPoints()+"",boldFont));
        if(meritListLine.getPoints()>1) {
            table.addCell(createPhrase(meritListLine.getStreamRank() + " / " + streamStudents,boldFont));
            table.addCell(createPhrase(meritListLine.getClassRank() + " / " + classStudents,boldFont));
        }
        else{
            table.addCell( createPhrase("- / " + streamStudents,boldFont));
            table.addCell( createPhrase("- / " + classStudents,boldFont));

        }
        table.addCell(createPhrase(meritListLine.getKcpeMarks()+" / 500",boldFont));
        table.setHorizontalAlignment(Element.ALIGN_CENTER);


//        document.add(new Paragraph(" "));
        document.add(table);

//        document.add(new Paragraph(" "));



        String[] columns={"SUBJECTS","MARKS","GRADE","RANK","COMMENT","TEACHER"};
        PdfPTable tableMarks=new PdfPTable(6);
        for(String i:columns) {
            PdfPCell headerCell=CreateHeaderCell(i);
//            headerCell.setFixedHeight(16);
            tableMarks.addCell(headerCell);
        }

        float[] columnWidths = {20f, 10f, 10f,12f,30f,20f};
        tableMarks.setWidths(columnWidths);

        HashMap<Long, String> allTeachers = subjectTeacherService.allTeacher();
        ClassSubjectTeachers subjectTeachers = subjectTeacherService.getSubjectTeacher(meritListLine.getStage(),meritListLine.getStream());

//        System.out.println(subjectTeachers);

        for(StudySubject i:studySubjectsRepository.allAvailable())
        {
            Double marks=meritListLine.getSubjectMarks().get(i.getSubjectCode());
            if(marks==null)
                continue;
            int rank=marksRepository.countRank(meritListLine.getExamination(), meritListLine.getStage(), i.getSubjectCode(),marks)+1;
            tableMarks.addCell(createMarks(i.getSubjectName()));
            tableMarks.addCell(createMarks(marks>0?marks+" % ":" __ "));
            tableMarks.addCell(createMarks(marks>0?meritListLine.getSubjectGrades().get(i.getSubjectCode()):" __ "));
            tableMarks.addCell(createMarks(marks>0?rank+"/"+classStudents:" __ "));
            try {
                Paragraph opinionCell=createMarks(GradingUtils.gradingOpinions.get(meritListLine.getSubjectGrades().get(i.getSubjectCode())));
                opinionCell.getFont().setSize(10);
                tableMarks.addCell(opinionCell);
            }catch (Exception es)
            {}
            try {
                tableMarks.addCell(createMarks(allTeachers.get(subjectTeachers.getSubjectTeachers().get(i.getSubjectName()).getTeacher()),8,true));
            }catch (Exception es)
            {
                es.printStackTrace();
                tableMarks.addCell("");
            }

        }

        tableMarks.setWidthPercentage(100);

        tableMarks.setSpacingBefore(5);
        document.add(tableMarks);
    }

    private PdfPCell createPhrase2(String aggregateGrade, Font boldFont) {
        PdfPCell pdfPCell=createPhrase(aggregateGrade,new Font(Font.FontFamily.COURIER, 10, Font.BOLD));
        return pdfPCell;
    }


    private Paragraph createMarks(String s, int i, boolean b) {
        Font boldFont = new Font(Font.FontFamily.COURIER, i, b?Font.BOLD:Font.NORMAL);
        Paragraph paragraph=new Paragraph(s,boldFont);
        return paragraph;
    }

    private Paragraph createMarks(String subjectName) {
        Font boldFont = new Font(Font.FontFamily.COURIER, 11, Font.NORMAL);
        Paragraph paragraph=new Paragraph(subjectName,boldFont);
        return paragraph;
    }

    private PdfPCell createPhrase(String s, Font boldFont) {

        Paragraph phrase=new Paragraph(s,boldFont);
        phrase.setAlignment(Element.ALIGN_CENTER);
        PdfPCell pdfPCell=new PdfPCell(phrase);
        pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        return pdfPCell;
    }



    private void addStudentInfo(Document document, Student student, MeritListLine meritListLine) throws Exception {

        PdfPTable studentDetails=new PdfPTable(3);

        Image leftImage = studentPhotoService.getStudentImageSafe(student.getAdmNo());
        leftImage.scaleToFit(100, 100); // Adjust image size as needed
        PdfPCell pdfPCell=new PdfPCell(leftImage);
        pdfPCell.setRowspan(5);
        pdfPCell.setBorder(Rectangle.NO_BORDER);
        studentDetails.addCell(pdfPCell);

        Font boldFont = new Font(Font.FontFamily.COURIER, 12, Font.BOLD);


        addBold(studentDetails,13,"Adm No : "+student.getAdmNo());


//        studentDetails.addCell(subjectGraph(meritListLine));

        addBold(studentDetails,13,"Name : "+student.getName());
        addBold(studentDetails,13,"Form : "+((int)(meritListLine.getStage()/1))+" "+meritListLine.getStream());
        addBold(studentDetails,13,"Kcpe Marks : "+meritListLine.getKcpeMarks());
        addBold(studentDetails,13,"Gender : "+student.getGender());



        studentDetails.setWidthPercentage(100);
        studentDetails.setSpacingBefore(10);

        document.add(studentDetails);
    }

//    private PdfPCell subjectGraph(MeritListLine meritListLine) {
//
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//
//        // Add data to the dataset
//        dataset.addValue(5, "Series1", "Category1");
//        dataset.addValue(8, "Series1", "Category2");
//        dataset.addValue(3, "Series1", "Category3");
//        dataset.addValue(12, "Series1", "Category4");
//
//        ChartFactory.createBarChart(
//                "", // Chart title
//                "Subjects",         // X-axis label
//                "Marks",            // Y-axis label
//                dataset
//        );
//    }

    private void addBold(PdfPTable studentDetails, int i, String s) {
        Font boldFont = new Font(Font.FontFamily.COURIER, i, Font.BOLD);
//        Paragraph hh=new Paragraph(s,boldFont);

//        hh.setFont(new Font(Font.FontFamily.COURIER,i, Font.FontStyle.BOLD.ordinal(),BaseColor.BLACK));
        PdfPCell pdfPCell=new PdfPCell();
        pdfPCell.setPhrase(new Phrase(s,boldFont));
        pdfPCell.setBorder(Rectangle.NO_BORDER);
        pdfPCell.setColspan(2);

        studentDetails.addCell(pdfPCell);
    }

    private void addBold(Paragraph studentDetails, int i, String s) {
        Font boldFont = new Font(Font.FontFamily.COURIER, i, Font.BOLD);
//        Paragraph hh=new Paragraph(s,boldFont);

//        hh.setFont(new Font(Font.FontFamily.COURIER,i, Font.FontStyle.BOLD.ordinal(),BaseColor.BLACK));
        studentDetails.add(s+"\n");
    }

    public static void addExamTitle(Document document, Examination examination) throws Exception{
        Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD | Font.UNDERLINE ,new BaseColor(0,0,128) );
//        f2=new Font(boldFont.getFamily(), 15, Font.NORMAL, BaseColor.BLUE);
        Paragraph hh2=new Paragraph(examination.getTitle()+"  Term ("+examination.getTerm()+") Year : "+examination.getYear(),boldFont);

        document.addTitle(examination.getTitle()+"  Term ("+examination.getTerm()+") Year : "+examination.getYear());
        hh2.setAlignment(Element.ALIGN_CENTER);
//        hh2.setFont(new Font(Font.FontFamily.COURIER,30, Font.UNDERLINE | Font.BOLD,BaseColor.BLACK));

        document.add(hh2);
    }





    private PdfPCell CreateHeaderCell(String i) {
        PdfPCell headerCell = new PdfPCell();
        Font boldFont = new Font(Font.FontFamily.COURIER, 10, Font.BOLD);
        Paragraph paragraph=new com.itextpdf.text.Paragraph(i,boldFont);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        headerCell.addElement(paragraph);
        headerCell.setGrayFill(0.9f); // Set background color
//        headerCell.setBackgroundColor(new BaseColor(191,191,191));
        headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        headerCell.setVerticalAlignment(Element.ALIGN_CENTER);
        return headerCell;
    }

    private void addBold(Document document, int i, String s) throws Exception {
        Font boldFont = new Font(Font.FontFamily.COURIER, i, Font.BOLD);
        Paragraph hh=new Paragraph(s,boldFont);

//        hh.setFont(new Font(Font.FontFamily.COURIER,i, Font.FontStyle.BOLD.ordinal(),BaseColor.BLACK));
        document.add(hh);
    }


    public static void addSchoolHeader(Document document) throws Exception {

        int ident=100;
        int identLeft=ident;

        Boolean isPortrait=true;

        if(document.getPageSize().getWidth()>document.getPageSize().getHeight()) {
            identLeft += 100;
            isPortrait=false;
        }
        Font boldFont = new Font(Font.FontFamily.COURIER, 18, Font.BOLD);
        Paragraph hh=new Paragraph(schoolName,boldFont);
        hh.setAlignment(Element.ALIGN_LEFT);
//        hh.setFont(new Font(Font.FontFamily.COURIER,48, Font.FontStyle.BOLD.ordinal(),BaseColor.BLACK));
        hh.setIndentationLeft(identLeft);

        document.add(hh);
//        document.setMargins(0,0,0,0);

        boldFont = new Font(Font.FontFamily.COURIER, 14, Font.BOLD);
        Paragraph box=new Paragraph(addr,boldFont);
        box.setAlignment(Element.ALIGN_LEFT);
        box.setIndentationLeft(identLeft);
        document.add(box);

        boldFont = new Font(Font.FontFamily.COURIER, 13, Font.BOLD);
        Paragraph email=new Paragraph("E-MAIL: "+schoolEmail+"    TEL: "+schoolPhone,boldFont);
        email.setAlignment(Element.ALIGN_LEFT);
        email.setIndentationLeft(identLeft);
        document.add(email);

        boldFont = new Font(Font.FontFamily.COURIER, 16, Font.BOLD);
        Paragraph phone=new Paragraph("SCHOOL MOTTO : "+schoolMotto,boldFont);
        phone.setAlignment(Element.ALIGN_LEFT);
        phone.setIndentationLeft(identLeft);
        document.add(phone);

        try{
            int width=ident;


            if(logo==null){
                logo=Image.getInstance(ReportCardService.class.getResourceAsStream("/images/logo.png").readAllBytes());

            float height=logo.getHeight()*width/logo.getWidth();
            logo.scaleAbsolute(width,height );
            logo.setAbsolutePosition(isPortrait?20:100, document.getPageSize().getHeight()-height*4/3);
}

            document.add(logo);



        }catch (Exception es)
        {
            es.printStackTrace();
        }





    }


    public static Image logo=null;



    public ResponseEntity<String> smsReportCard(Long examination, int admNo) {
        Optional<Student> optionalStudent=studentRepository.findByAdmNo(admNo);
        if(optionalStudent.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such student");

        Student student=optionalStudent.get();

       Optional<MeritListLine> optionalMeritListLine=meritListLineRepository.findByStudentIdAndExamination(student.getNum(),examination);
       if(optionalMeritListLine.isEmpty())
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Generate Merit List First");

       MeritListLine meritListLine=optionalMeritListLine.get();
       Optional<Examination> examination1=examinationRepository.findById(examination);
       Examination fineExamination=examination1.get();

       int students=meritListLineRepository.countByStageAndExaminationOrderByClassRankAsc(meritListLine.getStage(),examination);
       int streamStudents=meritListLineRepository.countByStageAndExaminationAndStreamOrderByClassRankAsc(meritListLine.getStage(),examination,meritListLine.getStream());

       String message="TAKABA BOYS, Dear Parent/Guardian of "+student.getAdmNo()+"-"+student.getName()+" class "+((int)(meritListLine.getStage()/1))
               +meritListLine.getStream()+" "+fineExamination.getTitle()+" Term "+fineExamination.getTerm()+","+fineExamination.getYear()
               +" Total Points:"+meritListLine.getPoints()+" AggrGrade: "+meritListLine.getAggregateGrade()+" OverallPosition: "+meritListLine.getClassRank()+"/"+students
               +" StreamPosition: "+meritListLine.getStreamRank()+"/"+streamStudents+" ";

       for(StudySubject s: studySubjectsRepository.allAvailable()) {
           if (meritListLine.getSubjectMarks().containsKey(s.getSubjectCode())) {
               Double marks = meritListLine.getSubjectMarks().get(s.getSubjectCode());
               if (marks == null || marks == 0)
                   continue;
               message += s.getSubjectRep() + " " + marks +" "+ meritListLine.getSubjectGrades().get(s.getSubjectCode()) + ", ";
           }
       }

       if(message.endsWith(", "))
       {
           message=message.substring(0,message.length()-2);
       }

       List<Guardian> guardians=guardianRepository.findByStudent(student.getNum());
       for(Guardian guardian:guardians)
       {
           if(guardian.getPhone()!=null&&guardian.getPhone().length()>8)
           {
               SMSLog smsLog= SMSLog.builder()
                       .guardian(guardian.getFullName())
                       .phone(guardian.getPhone())
                       .student(student.getName())
                       .message(message)
                       .build();
               smsLog.trySending();
               smsLogRepository.save(smsLog);
           }
       }
       if(guardians.size()==0)
           return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("No guardian Registered");
       else
           return ResponseEntity.ok("Sending");

    }






    public ResponseEntity<String> smsReportCards(Long examination, Double grade, String stream) {

        List<MeritListLine> meritListLines;
        if(stream==null||stream.length()==0||stream.trim().equalsIgnoreCase("All"))
            meritListLines=meritListService.viewMeritList(examination,grade);
        else
            meritListLines=meritListService.viewMeritList(examination,grade,stream);

        Optional<Examination> examination1 = examinationRepository.findById(examination);
        Examination fineExamination = examination1.get();

        int students = meritListLineRepository.countByStageAndExaminationOrderByClassRankAsc(grade, examination);
        int streamStudents = meritListLineRepository.countByStageAndExaminationAndStreamOrderByClassRankAsc(grade, examination, stream);


        for(MeritListLine meritListLine:meritListLines) {

            Optional<Student> optionalStudent = studentRepository.findById(meritListLine.getStudentId());
            if (optionalStudent.isEmpty())
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such student");

            Student student = optionalStudent.get();

            String message = "TAKABA BOYS, Dear Parent/Guardian of " + student.getAdmNo() + "-" + student.getName() + " class " + ((int) (grade / 1))
                    + meritListLine.getStream() + " " + fineExamination.getTitle() + " Term " + fineExamination.getTerm() + "," + fineExamination.getYear()
                    + " Total Points:" + meritListLine.getPoints() + " AggrGrade: " + meritListLine.getAggregateGrade() + " OverallPosition: " + meritListLine.getClassRank() + "/" + students
                    + " StreamPosition: " + meritListLine.getStreamRank() + "/" + streamStudents + " ";

            for (StudySubject s : studySubjectsRepository.allAvailable()) {
                if (meritListLine.getSubjectMarks().containsKey(s.getSubjectCode())) {
                    Double marks = meritListLine.getSubjectMarks().get(s.getSubjectCode());
                    if (marks == null || marks == 0)
                        continue;
                    message += s.getSubjectRep() + " " + marks +" "+ meritListLine.getSubjectGrades().get(s.getSubjectCode()) + ", ";
                }
            }

            if (message.endsWith(", ")) {
                message=message.substring(0, message.length() - 2);
            }

            List<Guardian> guardians = guardianRepository.findByStudent(student.getNum());
            for (Guardian guardian : guardians) {
                if (guardian.getPhone() != null && guardian.getPhone().length() > 8) {
                    final SMSLog smsLog = SMSLog.builder()
                            .guardian(guardian.getFullName())
                            .phone(guardian.getPhone())
                            .student(student.getName())
                            .message(message)
                            .build();
                    executorService.submit(()->{
                        smsLog.trySending();
                        smsLogRepository.save(smsLog);
                    });

                }
            }
        }
        if(meritListLines.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cant find Report Cards");
        else
            return ResponseEntity.ok("Sending");
    }

    private ExecutorService executorService= Executors.newCachedThreadPool();
}



