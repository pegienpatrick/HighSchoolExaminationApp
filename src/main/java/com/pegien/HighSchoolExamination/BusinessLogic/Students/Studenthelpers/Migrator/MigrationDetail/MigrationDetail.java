package com.pegien.HighSchoolExamination.BusinessLogic.Students.Studenthelpers.Migrator.MigrationDetail;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MigrationDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uid;

    private Long doneOn;

    private Long doneBy;

    private String title;

    private HashSet<Integer> stages;
}
