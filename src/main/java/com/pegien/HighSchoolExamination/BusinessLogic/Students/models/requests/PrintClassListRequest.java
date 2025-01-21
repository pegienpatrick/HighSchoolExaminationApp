package com.pegien.HighSchoolExamination.BusinessLogic.Students.models.requests;

import lombok.Data;

import javax.validation.constraints.Null;
import java.util.HashSet;
import java.util.List;

@Data
public class PrintClassListRequest {

    private HashSet<String> extraColumns;
}
