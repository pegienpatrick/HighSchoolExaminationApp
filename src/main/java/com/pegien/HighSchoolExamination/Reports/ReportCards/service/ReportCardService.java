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



    public ResponseEntity<byte[]> viewReport(Long examination, int admNo) {
        try {
            // Generate the PDF report
            byte[] pdfBytes = generateStudentReport(examination, admNo);

            // Set the response headers
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "student_report.pdf");

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

            Paragraph hh=new Paragraph("TAKABA BOYS HIGH SCHOOL");
            hh.setAlignment(Element.ALIGN_CENTER);
            hh.setFont(new Font(Font.FontFamily.COURIER,48, Font.FontStyle.BOLD.ordinal(),BaseColor.BLACK));

            document.add(hh);
            Paragraph box=new Paragraph("P.O.BOX 123- 123, Nairobi");
            box.setAlignment(Element.ALIGN_CENTER);
            document.add(box);

            Paragraph email=new Paragraph("email@gmail.com");
            email.setAlignment(Element.ALIGN_CENTER);
            document.add(email);

            Paragraph phone=new Paragraph("0713412341234");
            phone.setAlignment(Element.ALIGN_CENTER);
            document.add(phone);





            Optional<Examination> examination1=examinationRepository.findById(examination);
            if(examination1.isEmpty())
                return null;

            Paragraph hh2=new Paragraph(examination1.get().getTitle()+"  Term ("+examination1.get().getTerm()+") Year : "+examination1.get().getYear());
            hh2.setAlignment(Element.ALIGN_CENTER);
            hh2.setFont(new Font(Font.FontFamily.COURIER,30, Font.UNDERLINE | Font.BOLD,BaseColor.BLACK));

            document.add(hh2);

            Optional<Student> optionalStudent=studentRepository.findByAdmNo(admNo);
            if(optionalStudent.isEmpty())
            {
                System.out.println("Student Null");
                return null;
            }

            Student student=optionalStudent.get();


            MeritListLine meritListLine= meritListService.getMeritLine(student,examination,student.getStage());
            addBold(document,15,"Adm No : "+student.getAdmNo());
            addBold(document,15,"Name : "+student.getName());
            addBold(document,15,"Form : "+meritListLine.getStage()+" "+meritListLine.getStream());
            addBold(document,15,"Kcpe Marks : "+meritListLine.getKcpeMarks());
            addBold(document,15,"Gender : "+student.getGender());
            if(student.getDateOfBirth()!=null) {
                Long ageDays = TimeUnit.MILLISECONDS.toDays(new Date().getTime()-new Date(student.getDateOfBirth()).getTime());
                float age=Float.valueOf(ageDays)/365f;
                if(age<100f&&age>1f)
                    addBold(document, 15, "Age : " +age);
            }

            int classStudents=meritListLineRepository.countByStageAndExaminationOrderByClassRankAsc(meritListLine.getStage(),examination);
            int streamStudents=meritListLineRepository.countByStageAndExaminationAndStreamOrderByClassRankAsc(meritListLine.getStage(), examination,meritListLine.getStream());




            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(100);
            table.addCell("Aggregate Grade");
            table.addCell("Aggregate Points");
            table.addCell("Stream Position");
            table.addCell("Overall Class Position");
            table.addCell("KCPE MArks");

            table.addCell(meritListLine.getAggregateGrade());
            table.addCell(meritListLine.getPoints()+"");
            table.addCell(meritListLine.getStreamRank()+" / "+streamStudents);
            table.addCell(meritListLine.getClassRank()+" / "+classStudents);
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
                int rank=marksRepository.countRank(examination, meritListLine.getStage(), i.getSubjectCode(),marks)+1;
                tableMarks.addCell(studySubjectsRepository.findBySubjectCode(i.getSubjectCode()).getSubjectName());
                tableMarks.addCell(marks+" % ");
                tableMarks.addCell(meritListLine.getSubjectGrades().get(i.getSubjectCode()));
                tableMarks.addCell(rank+" / "+classStudents);
                tableMarks.addCell(" ");
                tableMarks.addCell(" ");

            }

            tableMarks.setWidthPercentage(100);




            document.add(tableMarks);
            document.close();

            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private PdfPCell CreateHeaderCell(String i) {
        PdfPCell headerCell = new PdfPCell();
        headerCell.addElement(new com.itextpdf.text.Paragraph(i));
        headerCell.setGrayFill(0.7f); // Set background color
        return headerCell;
    }

    private void addBold(Document document, int i, String s) throws Exception {
        Paragraph hh=new Paragraph(s);

        hh.setFont(new Font(Font.FontFamily.COURIER,i, Font.FontStyle.BOLD.ordinal(),BaseColor.BLACK));
        document.add(hh);
    }


    private List<Subject> getSampleSubjects() {
        // Replace this method with logic to fetch actual subject data from your system or database
        // For demonstration purposes, returning sample data
        return List.of(
                new Subject("Math", 90, "A", 1, "Excellent"),
                new Subject("Science", 85, "B", 2, "Good"),
                new Subject("English", 92, "A", 1, "Excellent")
                // Add more subjects as needed
        );
    }

}

@Data
@AllArgsConstructor
class Subject {
    private String name;
    private int score;
    private String grade;
    private int rank;
    private String comment;

    // Constructors, getters, setters
}

