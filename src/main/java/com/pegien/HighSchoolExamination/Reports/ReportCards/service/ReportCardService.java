package com.pegien.HighSchoolExamination.Reports.ReportCards.service;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.pegien.HighSchoolExamination.Examination.Examination;
import com.pegien.HighSchoolExamination.Examination.ExaminationRepository;
import com.pegien.HighSchoolExamination.Examination.Marks.MarksRepository;
import com.pegien.HighSchoolExamination.Examination.Marks.service.MarksService;
import com.pegien.HighSchoolExamination.Examination.service.ExaminationService;
import com.pegien.HighSchoolExamination.Reports.MeritList.MeritListItem.MeritListLine;
import com.pegien.HighSchoolExamination.Reports.MeritList.MeritListItem.MeritListLineRepository;
import com.pegien.HighSchoolExamination.Reports.MeritList.service.MeritListService;
import com.pegien.HighSchoolExamination.Students.Student;
import com.pegien.HighSchoolExamination.Students.StudentRepository;
import com.pegien.HighSchoolExamination.Students.service.StudentsService;
import com.pegien.HighSchoolExamination.StudySubjects.StudySubjectsRepository;
import com.pegien.HighSchoolExamination.StudySubjects.SubjectGrade.SubjectGrading;
import com.pegien.HighSchoolExamination.StudySubjects.SubjectGrade.service.SubjectGradingService;
import com.pegien.HighSchoolExamination.Utils.GradingUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;


import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;


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


            addFooter(document);
            document.close();

            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public byte[] generatebulkReport(Long examination, Double stage,String stream) {

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

                addFooter(document);

                document.newPage();
            }








            document.close();

            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void addFooter(Document document) throws Exception {

        //class teacher sign
        PdfPTable pdfPTable=new PdfPTable(2);
        pdfPTable.setWidthPercentage(100);
        pdfPTable.setWidths(new int[]{80, 20});

        int rowHeight=40;
        pdfPTable.addCell( CreateHeaderCell("ClassTeacher`s Remarks") );
        pdfPTable.addCell(CreateHeaderCell("Signature"));
        addEmptyCell(pdfPTable,rowHeight);
        addEmptyCell(pdfPTable,rowHeight);

        pdfPTable.setSpacingBefore(10);

        document.add(pdfPTable);

        //headTeacher sign

        pdfPTable = new PdfPTable(2);
        pdfPTable.setWidthPercentage(100);
        pdfPTable.setWidths(new int[]{80, 20});


        pdfPTable.addCell( CreateHeaderCell("HeadTeacher`s Remarks") );
        pdfPTable.addCell(CreateHeaderCell("Signature"));
        addEmptyCell(pdfPTable,rowHeight);
        addEmptyCell(pdfPTable,rowHeight);

        pdfPTable.setSpacingBefore(10);
        document.add(pdfPTable);

    }

    private void addEmptyCell(PdfPTable pdfPTable, int rowHeight) {
        PdfPCell pdfPCell=new PdfPCell();
        pdfPCell.setFixedHeight(rowHeight);
        pdfPTable.addCell(pdfPCell);
    }


    private void addTables(Document document, MeritListLine meritListLine, int classStudents, int streamStudents) throws Exception {
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100);
        table.addCell("Aggregate Grade");
        table.addCell("Aggregate Points");
        table.addCell("Stream Position");
        table.addCell("Overall Class Position");
        table.addCell("KCPE MArks");

        table.addCell(meritListLine.getAggregateGrade());
        table.addCell(meritListLine.getPoints()+"");
        if(meritListLine.getAggregateGrade().equalsIgnoreCase("z")) {
            table.addCell(meritListLine.getStreamRank() + " / " + streamStudents);
            table.addCell(meritListLine.getClassRank() + " / " + classStudents);
        }
        else{
            table.addCell( "- / " + streamStudents);
            table.addCell( "- / " + classStudents);

        }
        table.addCell(meritListLine.getKcpeMarks()+" / 500");


        document.add(new Paragraph(" "));
        document.add(table);

        document.add(new Paragraph(" "));



        String[] columns={"SUBJECTS","MARKS","GRADE","RANK","COMMENT","TEACHERS COMMENTS"};
        PdfPTable tableMarks=new PdfPTable(6);
        for(String i:columns)
            tableMarks.addCell(CreateHeaderCell(i));

        float[] columnWidths = {20f, 10f, 10f,10f,20f,30f};
        tableMarks.setWidths(columnWidths);

        for(SubjectGrading i:subjectGradingService.viewGradings())
        {
            Double marks=meritListLine.getSubjectMarks().get(i.getSubjectCode());
            if(marks==null)
                marks=0.0;
            int rank=marksRepository.countRank(meritListLine.getExamination(), meritListLine.getStage(), i.getSubjectCode(),marks)+1;
            tableMarks.addCell(studySubjectsRepository.findBySubjectCode(i.getSubjectCode()).getSubjectName());
            tableMarks.addCell(marks>0?marks+" % ":" __ ");
            tableMarks.addCell(marks>0?meritListLine.getSubjectGrades().get(i.getSubjectCode()):" __ ");
            tableMarks.addCell(marks>0?rank+" / "+classStudents:" __ ");
            tableMarks.addCell(GradingUtils.getComment(marks));
            tableMarks.addCell(" ");

        }

        tableMarks.setWidthPercentage(100);

        document.add(tableMarks);


    }

    private void addStudentInfo(Document document, Student student, MeritListLine meritListLine) throws Exception {


        addBold(document,15,"Adm No : "+student.getAdmNo());
        addBold(document,15,"Name : "+student.getName());
        addBold(document,15,"Form : "+((int)(meritListLine.getStage()/1))+" "+meritListLine.getStream());
        addBold(document,15,"Kcpe Marks : "+meritListLine.getKcpeMarks());
        addBold(document,15,"Gender : "+student.getGender());
        if(student.getDateOfBirth()!=null&&false) {
            Long ageDays = TimeUnit.MILLISECONDS.toDays(new Date().getTime()-new Date(student.getDateOfBirth()).getTime());
            float age=Float.valueOf(ageDays)/365f;
            if(age<100f&&age>1f)
                addBold(document, 15, "Age : " +age);
        }
    }

    public static void addExamTitle(Document document, Examination examination) throws Exception{
        Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 22, Font.BOLD | Font.UNDERLINE);
        Paragraph hh2=new Paragraph(examination.getTitle()+"  Term ("+examination.getTerm()+") Year : "+examination.getYear(),boldFont);
        document.addTitle(examination.getTitle()+"  Term ("+examination.getTerm()+") Year : "+examination.getYear());
        hh2.setAlignment(Element.ALIGN_CENTER);
//        hh2.setFont(new Font(Font.FontFamily.COURIER,30, Font.UNDERLINE | Font.BOLD,BaseColor.BLACK));

        document.add(hh2);
    }





    private PdfPCell CreateHeaderCell(String i) {
        PdfPCell headerCell = new PdfPCell();
        headerCell.addElement(new com.itextpdf.text.Paragraph(i));
        headerCell.setGrayFill(0.7f); // Set background color
        headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        headerCell.setVerticalAlignment(Element.ALIGN_CENTER);
        return headerCell;
    }

    private void addBold(Document document, int i, String s) throws Exception {
        Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, i, Font.BOLD);
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




        Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
        Paragraph hh=new Paragraph(schoolName,boldFont);
        hh.setAlignment(Element.ALIGN_LEFT);
//        hh.setFont(new Font(Font.FontFamily.COURIER,48, Font.FontStyle.BOLD.ordinal(),BaseColor.BLACK));
        hh.setIndentationLeft(identLeft);

        document.add(hh);
//        document.setMargins(0,0,0,0);

        boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
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
                logo=Image.getInstance(ClassLoader.getSystemResourceAsStream("images/logo.png").readAllBytes());

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





}



