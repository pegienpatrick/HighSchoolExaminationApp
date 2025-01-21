package com.pegien.HighSchoolExamination.BusinessLogic.Students.Studenthelpers.Migrator.models;

import lombok.Data;

import java.util.HashSet;
import java.util.UUID;

@Data
public class ListMigrationModel {
    private UUID uid;

    private String title;

    private String doneOn;

    private HashSet<Integer> classes;
}
