package com.pegien.HighSchoolExamination.BusinessLogic.Students.models.responses;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentRegisterResponse {

    private int admNo;

    private String message;

}
