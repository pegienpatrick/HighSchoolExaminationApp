package com.pegien.HighSchoolExamination.BusinessLogic.Students.Studenthelpers.Migrator;


import com.pegien.HighSchoolExamination.Auth.AuthService;
import com.pegien.HighSchoolExamination.BusinessLogic.Students.Studenthelpers.Migrator.MigrationDetail.MigrationDetailRepository;
import com.pegien.HighSchoolExamination.BusinessLogic.Students.Studenthelpers.Migrator.models.ListMigrationModel;
import com.pegien.HighSchoolExamination.BusinessLogic.Students.Studenthelpers.Migrator.models.MigrateStudentsRequest;
import com.pegien.HighSchoolExamination.BusinessLogic.Students.Studenthelpers.Migrator.MigrationDetail.MigrationDetail;
import com.pegien.HighSchoolExamination.BusinessLogic.Students.entity.Student;
import com.pegien.HighSchoolExamination.BusinessLogic.Students.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentsMigrationService {

    @Autowired
    private StudentsMigrationRepository studentsMigrationRepository;

    @Autowired
    private StudentRepository studentRepository;


    @Autowired
    private AuthService authService;

    @Autowired
    private MigrationDetailRepository migrationDetailRepository;


    public ResponseEntity<String> migrateStudents(@Valid MigrateStudentsRequest migrateStudentsRequest) {
        List<Student> students = studentRepository.findByStageInOrderByStage(Arrays.stream(migrateStudentsRequest.getStages())
                .asDoubleStream()
                .toArray());

        MigrationDetail migrationDetail = MigrationDetail.builder()
                .title(migrateStudentsRequest.getTitle())
                .doneBy(authService.getActiveUser().getNum())
                .doneOn(System.currentTimeMillis())
                .stages((HashSet<Integer>) Arrays.stream(migrateStudentsRequest.getStages()).boxed().collect(Collectors.toSet()))
                .build();

        migrationDetailRepository.saveAndFlush(migrationDetail);

        List<StudentMigration> migrations = new LinkedList<>();
        for(int i=0;i<students.size();i++)
        {
            Student student = students.get(i);
            StudentMigration studentMigration = StudentMigration.builder()
                    .studentId(student.getNum())
                    .fromStage(student.getStage())
                    .toStage(student.getStage()+1)
                    .migrationDetail(migrationDetail.getUid())
                    .build();
            migrations.add(studentMigration);
            student.setStage(studentMigration.getToStage());
        }

        studentsMigrationRepository.saveAllAndFlush(migrations);
        studentRepository.saveAll(students);

        return ResponseEntity.ok(migrationDetail.toString());
    }

    public ResponseEntity<String> undoMigration(UUID migrationId) {

        Optional<MigrationDetail> optionalMigrationDetail = migrationDetailRepository.findById(migrationId);
        if(optionalMigrationDetail.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such Migrations");

        MigrationDetail newMigrationDetail = MigrationDetail.builder()
                .title("Revert Migration  "+optionalMigrationDetail.get().getUid())
                .doneBy(authService.getActiveUser().getNum())
                .doneOn(System.currentTimeMillis())
                .stages(optionalMigrationDetail.get().getStages())
                .build();

        migrationDetailRepository.saveAndFlush(newMigrationDetail);

        List<StudentMigration> newMigrations = new LinkedList<>();

        List<StudentMigration> studentmigrations = studentsMigrationRepository.findByMigrationDetail(migrationId);
        for(int i=0;i<studentmigrations.size();i++)
        {
            StudentMigration studentMigration = studentmigrations.get(i);
            Optional<Student> optionalStudent = studentRepository.findById(studentMigration.getStudentId());
            if(optionalStudent.isPresent())
            {
                Student student = optionalStudent.get();
//                if(student.getStage().equals(studentMigration.getToStage()))
                {
                    student.setStage(studentMigration.getFromStage());
                    studentRepository.save(student);
                }
                {
                    StudentMigration newStudentMigration = StudentMigration.builder()
                            .studentId(student.getNum())
                            .fromStage(studentMigration.getToStage())
                            .toStage(studentMigration.getFromStage())
                            .migrationDetail(newMigrationDetail.getUid())
                            .build();
                    newMigrations.add(newStudentMigration);
                }
//                studentsMigrationRepository.delete(studentMigration);
            }
        }

        studentsMigrationRepository.saveAllAndFlush(newMigrations);

//        migrationDetailRepository.delete(optionalMigrationDetail.get());
        return ResponseEntity.ok("Migration Undone");
    }

//    public ResponseEntity<String> undoMigration(UUID migrationId) {
//
//        Optional<MigrationDetail> optionalMigrationDetail = migrationDetailRepository.findById(migrationId);
//        if(optionalMigrationDetail.isEmpty())
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such Migrations");
//
//        List<StudentMigration> studentmigrations = studentsMigrationRepository.findByMigrationDetail(migrationId);
//        for(int i=0;i<studentmigrations.size();i++)
//        {
//            StudentMigration studentMigration = studentmigrations.get(i);
//            Optional<Student> optionalStudent = studentRepository.findById(studentMigration.getStudentId());
//            if(optionalStudent.isPresent())
//            {
//                Student student = optionalStudent.get();
//                if(student.getStage().equals(studentMigration.getToStage()))
//                {
//                    student.setStage(studentMigration.getFromStage());
//                    studentRepository.save(student);
//                }
//                studentsMigrationRepository.delete(studentMigration);
//            }
//        }
//
//        migrationDetailRepository.delete(optionalMigrationDetail.get());
//        return ResponseEntity.ok("Migration Undone");
//    }

    public ResponseEntity<List<MigrationDetail>> listMigrations() {

        return ResponseEntity.ok(migrationDetailRepository.findAllOrderByDoneOn());
    }

    public ResponseEntity<List<ListMigrationModel>> listMigrationsModels() {
        List<MigrationDetail> listing = migrationDetailRepository.findAllOrderByDoneOn();

        List<ListMigrationModel> migrations = new LinkedList<>();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        for(MigrationDetail migrationDetail:listing)
        {
            ListMigrationModel migrationModel = new ListMigrationModel();
            migrationModel.setUid(migrationDetail.getUid());
            migrationModel.setTitle(migrationDetail.getTitle());
            migrationModel.setClasses(migrationDetail.getStages());
            migrationModel.setDoneOn(dateFormatter.format(new Date(migrationDetail.getDoneOn())));

            migrations.add(migrationModel);
        }

        return ResponseEntity.ok(migrations);
    }
}
