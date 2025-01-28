package com.pegien.HighSchoolExamination.BusinessLogic.Students.Studenthelpers.Migrator;


import com.pegien.HighSchoolExamination.BusinessLogic.Students.Studenthelpers.Migrator.MigrationDetail.MigrationDetail;
import com.pegien.HighSchoolExamination.BusinessLogic.Students.Studenthelpers.Migrator.models.ListMigrationModel;
import com.pegien.HighSchoolExamination.BusinessLogic.Students.Studenthelpers.Migrator.models.MigrateStudentsRequest;
import com.pegien.HighSchoolExamination.Utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/studentsMigration")
@PreAuthorize("students:migrate")
public class StudentsMigratorController {

    @Autowired
    private StudentsMigrationService studentsMigrationService;


    @PostMapping("/migrateStudents")
    public ResponseEntity<String> migrateStudents(@RequestBody @Valid MigrateStudentsRequest migrateStudentsRequest, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MyUtils.createErrorMessage(bindingResult));
        return studentsMigrationService.migrateStudents(migrateStudentsRequest);
    }

    @DeleteMapping("/undoMigration/{migrationId}")
    public ResponseEntity<String> undoMigration(@PathVariable("migrationId")UUID migrationId)
    {
        return studentsMigrationService.undoMigration(migrationId);
    }


    @GetMapping("/listMigrations")
    public ResponseEntity<List<ListMigrationModel>> listMigrations()
    {
        return studentsMigrationService.listMigrationsModels();
    }

}
