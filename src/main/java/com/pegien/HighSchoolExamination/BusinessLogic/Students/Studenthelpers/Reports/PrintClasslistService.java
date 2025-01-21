package com.pegien.HighSchoolExamination.BusinessLogic.Students.Studenthelpers.Reports;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.pegien.HighSchoolExamination.BusinessLogic.Students.entity.Student;
import com.pegien.HighSchoolExamination.BusinessLogic.Students.models.requests.PrintClassListRequest;
import com.pegien.HighSchoolExamination.BusinessLogic.Students.repository.StudentRepository;
import com.pegien.HighSchoolExamination.Utils.ConvertionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

import static com.pegien.HighSchoolExamination.BusinessLogic.Reports.MeritList.service.MeritListService.createCell;
import static com.pegien.HighSchoolExamination.BusinessLogic.Reports.ReportCards.service.ReportCardService.addSchoolHeader;

@Service
public class PrintClasslistService {

    @Autowired
    private StudentRepository studentRepository;


    public List<Student> fetchStudentsList(String stage, String stream) {
        Double stageV = ConvertionUtils.getDouble(stage);
        List<Student> studentsList = Collections.emptyList();

        if (stageV == null || stageV <= 0) {
            if (stream == null || stream.isEmpty()) {
                studentsList = studentRepository.findByStageInOrderByAdmNo(new double[]{1.0,2.0,3.0,4.0});
            }
        } else {
            if (stream == null || stream.isEmpty()) {
                studentsList = studentRepository.findByStageOrderByAdmNo(stageV);
            } else {
                studentsList = studentRepository.findByStageAndStreamOrderByAdmNo(stageV, stream);
            }
        }
        return studentsList;
    }

    public ResponseEntity<byte[]> printClassLists(String stage, String stream, @Valid PrintClassListRequest printClassListRequest) {

        byte[] excelBytes = generateStudentsPDF(stage, stream,printClassListRequest);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);

        String sanitizedStage = (stage != null && !stage.isEmpty()) ? stage : "All";
        String sanitizedStream = (stream != null && !stream.isEmpty()) ? stream : "All";
        String formattedDateTime = new SimpleDateFormat("ddMMMyyyyHHmmss").format(new Date());
        String fileName = "Students_List_" + sanitizedStage + "_" + sanitizedStream + "_AddDate_" + formattedDateTime + ".pdf";

        headers.setContentDispositionFormData("attachment", fileName);

        return new ResponseEntity<>(excelBytes, headers, HttpStatus.OK);
    }

    private byte[] generateStudentsPDF(String stage, String stream, @Valid PrintClassListRequest printClassListRequest) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            com.itextpdf.text.Document document = new Document();
            PdfWriter.getInstance(document, byteArrayOutputStream);

            document.open();

//            document.setMargins(20,10,10,20);
            addSchoolHeader(document);

            // Add Title
            Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD | Font.UNDERLINE);
            Paragraph title = new Paragraph("Class List - Stage: " + stage + ", Stream: " + stream, titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(20);
            document.add(title);

            // Define Headers
            String[] defaultHeaders = {"Sr. No.", "Adm No", "Surname", "First Name", "Other Name"};
            HashSet<String> extraColumns = printClassListRequest.getExtraColumns();
            List<String> headers = new ArrayList<>(List.of(defaultHeaders));
            if (extraColumns != null) {
                headers.addAll(extraColumns);
            }

            // Create Table
            PdfPTable table = new PdfPTable(headers.size());
            table.setWidthPercentage(100);

            // Add Table Header
            for (String header : headers) {
                PdfPCell headerCell = CreateHeaderCell(header);
                table.addCell(headerCell);
            }

            // Fetch Students and Populate Table
            List<Student> students = fetchStudentsList(stage, stream);
            Font dataFont = new Font(Font.FontFamily.TIMES_ROMAN, 10);
            int serialNumber = 1;

            for (Student student : students) {
                table.addCell(createCell(String.valueOf(serialNumber++), dataFont)); // Sr. No.
                table.addCell(createCell(String.valueOf(student.getAdmNo()), dataFont)); // Adm No.
                table.addCell(createCell(student.getSurname(), dataFont)); // Surname
                table.addCell(createCell(student.getFirstName(), dataFont)); // First Name
                table.addCell(createCell(student.getOtherName(), dataFont)); // Other Name

                // Add Extra Columns
                if (extraColumns != null) {
                    for (String column : extraColumns) {
                        String value = getStudentFieldValue(student, column.toLowerCase().trim());
                        table.addCell(createCell(value != null ? value : " ", dataFont));
                    }
                }
            }

            // Add Table to Document
            document.add(table);

            document.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error generating class list PDF", e);
        }
    }

    private String getStudentFieldValue(Student student, String fieldName) {
        try {
            switch (fieldName.toLowerCase()) {
                case "birthcertno":
                    return student.getBirthCertno();
                case "nemisno":
                    return student.getNemisNo();
                case "dateofbirth":
                    return student.getDateOfBirth() != null ? student.getDateOfBirth().toString() : null;
                case "gender":
                    return student.getGender() != null ? student.getGender().toString() : null;
                case "stream":
                    return student.getStream();
                case "stage":
                case "class":
                    return student.getStage() != null ? student.getStage().toString() : null;
                case "kcpeMarks":
                    return String.valueOf(student.getKcpeMarks());
                default:
                    return " "; // Space for manual entry
            }
        } catch (Exception e) {
            return " "; // Space for manual entry if an error occurs
        }
    }

    public PdfPCell CreateHeaderCell(String i) {
        PdfPCell headerCell = new PdfPCell();
        headerCell.addElement(new com.itextpdf.text.Paragraph(i,new Font(Font.FontFamily.TIMES_ROMAN, 5)));
        headerCell.setGrayFill(0.7f); // Set background color
        headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        headerCell.setVerticalAlignment(Element.ALIGN_CENTER);
        headerCell.setNoWrap(false);
        headerCell.setFixedHeight(20);
        if(!i.contains("ame"))
            headerCell.setRotation(90);
        return headerCell;
    }

}
