package com.pegien.HighSchoolExamination.BusinessLogic.Students.service;

import com.pegien.HighSchoolExamination.BusinessLogic.Guardian.service.GuardianService;
import com.pegien.HighSchoolExamination.BusinessLogic.Students.Studenthelpers.Reports.ExcelExportService;
import com.pegien.HighSchoolExamination.BusinessLogic.Students.Studenthelpers.Reports.PrintClasslistService;
import com.pegien.HighSchoolExamination.BusinessLogic.Students.models.requests.PrintClassListRequest;
import com.pegien.HighSchoolExamination.Logs.service.LogService;
import com.pegien.HighSchoolExamination.BusinessLogic.Students.entity.Student;
import com.pegien.HighSchoolExamination.BusinessLogic.Students.repository.StudentRepository;
import com.pegien.HighSchoolExamination.BusinessLogic.Students.models.requests.StudentRegisterRequest;
import com.pegien.HighSchoolExamination.BusinessLogic.Students.models.requests.StudentUpdateRequest;
import com.pegien.HighSchoolExamination.BusinessLogic.Students.models.responses.StudentRegisterResponse;
import com.pegien.HighSchoolExamination.Utils.ConvertionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StudentsService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private GuardianService guardianService;

    @Autowired
    private LogService logService;


    @Autowired
    private ExcelExportService excelExportService;

    @Autowired
    private PrintClasslistService printClasslistService;


    public int getNextAdmission()
    {
        int next=0;
        try {
            next=studentRepository.maxAdm();
        }catch (Exception es)
        {

        }
        return next+1;
    }


    public ResponseEntity<StudentRegisterResponse> registerStudent(StudentRegisterRequest studentRegisterRequest) {

        int requestedAdm=studentRegisterRequest.getAdmNo();
        if(requestedAdm>0)
            if(studentRepository.findByAdmNo(studentRegisterRequest.getAdmNo()).isPresent())
                return ResponseEntity.status(HttpStatus.CONFLICT).body(StudentRegisterResponse.builder().admNo(requestedAdm).message("Admission Number "+requestedAdm+" already Exists. leave it blank to generate a new").build());
        if(requestedAdm>0)
        {

        }else
            requestedAdm=getNextAdmission();

        if(studentRegisterRequest.getDateOfBirth()==null)
            studentRegisterRequest.setDateOfBirth(new Date(0));

        Student student= Student.builder()
                .admNo(requestedAdm)
                .firstName(studentRegisterRequest.getFirstName())
                .surname(studentRegisterRequest.getSurname())
                .otherName(studentRegisterRequest.getOtherName())
                .gender(studentRegisterRequest.getGender())
                .birthCertno(studentRegisterRequest.getBirthCertno())
                .cohort(studentRegisterRequest.getCohort())
                .dateOfBirth(studentRegisterRequest.getDateOfBirth().getTime())
                .kcpeMarks(studentRegisterRequest.getKcpeMarks())
                .nemisNo(studentRegisterRequest.getNemisNo())
                .stage(studentRegisterRequest.getStage())
                .stream(studentRegisterRequest.getStream())
                .dateOfAdm(new Date().getTime())
                .build();

        studentRepository.saveAndFlush(student);
        logService.recordLog("Registered Student "+student);

        return ResponseEntity.ok(StudentRegisterResponse.builder().admNo(requestedAdm).message("Student Registered Successfully").build());
    }

    public ResponseEntity<String> updateStudent(StudentUpdateRequest studentUpdateRequest,int oldAdm) {


        Optional<Student> optionalStudent=studentRepository.findByAdmNo(oldAdm);

        if(optionalStudent.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Admission "+oldAdm+" Does not exist");

        int requestedAdm= studentUpdateRequest.getAdmNo();
        if(requestedAdm!=oldAdm)
        {
            if(studentRepository.findByAdmNo(requestedAdm).isPresent())
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Admission "+requestedAdm+" has another student registered");
        }


        Student student=optionalStudent.get();

        String prevStudent=student.toString();

        if(studentUpdateRequest.getDateOfBirth()==null)
            studentUpdateRequest.setDateOfBirth(new Date(0));

        student.setAdmNo(requestedAdm);
        student.setCohort(studentUpdateRequest.getCohort());
        student.setGender(studentUpdateRequest.getGender());
        student.setBirthCertno(studentUpdateRequest.getBirthCertno());
        student.setDateOfBirth(studentUpdateRequest.getDateOfBirth().getTime());
        student.setNemisNo(studentUpdateRequest.getNemisNo());
        student.setFirstName(studentUpdateRequest.getFirstName());
        student.setSurname(studentUpdateRequest.getSurname());
        student.setOtherName(studentUpdateRequest.getOtherName());
        student.setKcpeMarks(studentUpdateRequest.getKcpeMarks());
        student.setStage(studentUpdateRequest.getStage());
        student.setStream(studentUpdateRequest.getStream());

        studentRepository.saveAndFlush(student);
        logService.recordLog("Updated Student "+student+" previously "+prevStudent);

        return ResponseEntity.ok("Student Registered Successfully");
    }

    public List<Student> allStudents() {
        return studentRepository.findAll();
    }

    public ResponseEntity<Student> viewStudent(int admNo) {
        Optional<Student> optionalStudent=studentRepository.findByAdmNo(admNo);

        if(optionalStudent.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        else
            return ResponseEntity.ok(optionalStudent.get());

    }

    public ResponseEntity<String> deleteStudent(int admNo) {
        Optional<Student> optionalStudent=studentRepository.findByAdmNo(admNo);

        if(optionalStudent.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student Not Found");

        logService.recordLog("Delete Student : "+optionalStudent.get());
        studentRepository.delete(optionalStudent.get());

        return ResponseEntity.ok("Student Deleted Successfully");
    }

    public ResponseEntity<List<Student>> listStudents(String stage, String stream) {
        List<Student> studentsList = fetchStudentsList(stage, stream);
        return ResponseEntity.ok(studentsList);
    }

   /* public List<Student> fetchStudentsList(String stage, String stream) {
        Double stageV= ConvertionUtils.getDouble(stage);
        List<Student> studentsList = Collections.emptyList();
        if(stageV<=0&&(stream ==null|| stream.isEmpty()))
            studentsList = studentRepository.findByStageInOrderByAdmNo(new double[]{1.0,2.0,3.0,4.0});
        else if (stageV>0&&(stream ==null|| stream.isEmpty()))
            studentsList = studentRepository.findByStageOrderByadmNo(stageV);
        else if (stageV>0&&(stream !=null&&!stream.isEmpty()))
            studentsList = studentRepository.findByStageAndStreamOrderByadmNo(stageV, stream);

        return studentsList;
    }*/

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
        return excelExportService.exportStudents(stage,stream);
    }

    public ResponseEntity<byte[]> printStudentsList(String stage, String stream, @Valid PrintClassListRequest printClassListRequest) {
        return printClasslistService.printClassLists(stage,stream,printClassListRequest);
    }
}
