package com.pegien.HighSchoolExamination.BusinessLogic.Students.Studenthelpers.Migrator;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentMigration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uid;

    private UUID migrationDetail;

    private Long studentId;

    private Double fromStage;

    private Double toStage;



}
