package com.pegien.HighSchoolExamination.BusinessLogic.Students.Studenthelpers.Reports;

import com.pegien.HighSchoolExamination.BusinessLogic.Students.entity.Student;
import com.pegien.HighSchoolExamination.BusinessLogic.Students.repository.StudentRepository;
import com.pegien.HighSchoolExamination.Utils.ConvertionUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;




@Service
public class ExcelExportService {

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

    public ResponseEntity<byte[]> exportStudents(String stage, String stream) {
        byte[] excelBytes = generateStudentsExcel(stage, stream);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        String sanitizedStage = (stage != null && !stage.isEmpty()) ? stage : "All";
        String sanitizedStream = (stream != null && !stream.isEmpty()) ? stream : "All";
        String formattedDateTime = new SimpleDateFormat("ddMMMyyyyHHmmss").format(new Date());
        String fileName = "Students_List_" + sanitizedStage + "_" + sanitizedStream + "_AddDate_" + formattedDateTime + ".xls";

        headers.setContentDispositionFormData("attachment", fileName);

        return new ResponseEntity<>(excelBytes, headers, HttpStatus.OK);
    }

    private byte[] generateStudentsExcel(String stage, String stream) {
        List<Student> students = fetchStudentsList(stage, stream);

        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("Students List");

        // Create header cell style (bold text, with borders)
        CellStyle headerStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerStyle.setFont(headerFont);
        headerStyle.setBorderTop(BorderStyle.THIN);
        headerStyle.setBorderBottom(BorderStyle.THIN);
        headerStyle.setBorderLeft(BorderStyle.THIN);
        headerStyle.setBorderRight(BorderStyle.THIN);

        // Create data cell style (with borders)
        CellStyle dataStyle = workbook.createCellStyle();
        dataStyle.setBorderTop(BorderStyle.THIN);
        dataStyle.setBorderBottom(BorderStyle.THIN);
        dataStyle.setBorderLeft(BorderStyle.THIN);
        dataStyle.setBorderRight(BorderStyle.THIN);

        // Add header row
        Row headerRow = sheet.createRow(0);
        String[] headers = {
                "Sr. No.", "Adm No", "Surname", "First Name", "Other Name",
                "Date of Birth", "Birth Certificate No", "Nemis No",
                "Gender", "Stream", "Stage", "KCPE Marks"
        };

        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }

        // Add student data rows
        int rowIndex = 1;
        int serialNumber = 1;
        for (Student student : students) {
            Row row = sheet.createRow(rowIndex++);
            int colIndex = 0;

            // Serial number
            Cell cell = row.createCell(colIndex++);
            cell.setCellValue(serialNumber++);
            cell.setCellStyle(dataStyle);

            // Add student details
            row.createCell(colIndex++).setCellValue(student.getAdmNo());
            row.createCell(colIndex++).setCellValue(student.getSurname());
            row.createCell(colIndex++).setCellValue(student.getFirstName());
            row.createCell(colIndex++).setCellValue(student.getOtherName());
            row.createCell(colIndex++).setCellValue(
                    student.getDateOfBirth() != null ? student.getDateOfBirth().toString() : ""
            );
            row.createCell(colIndex++).setCellValue(
                    student.getBirthCertno() != null ? student.getBirthCertno() : ""
            );
            row.createCell(colIndex++).setCellValue(
                    student.getNemisNo() != null ? student.getNemisNo() : ""
            );
            row.createCell(colIndex++).setCellValue(
                    student.getGender() != null ? student.getGender().toString() : ""
            );
            row.createCell(colIndex++).setCellValue(
                    student.getStream() != null ? student.getStream() : ""
            );
            row.createCell(colIndex++).setCellValue(
                    student.getStage() != null ? student.getStage().toString() : ""
            );
            row.createCell(colIndex).setCellValue(student.getKcpeMarks());

            // Apply the data style to all cells in the row
            for (int i = 0; i <= colIndex; i++) {
                row.getCell(i).setCellStyle(dataStyle);
            }
        }

        // Auto-size all columns
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write data to byte array
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            workbook.write(outputStream);
            return outputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("Error while generating Excel file", e);
        }
    }
}
