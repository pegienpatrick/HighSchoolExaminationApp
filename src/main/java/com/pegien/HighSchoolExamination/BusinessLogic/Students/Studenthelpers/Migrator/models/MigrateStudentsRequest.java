package com.pegien.HighSchoolExamination.BusinessLogic.Students.Studenthelpers.Migrator.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MigrateStudentsRequest {



    @NotNull
    private int[] stages;

    private String title;

}
