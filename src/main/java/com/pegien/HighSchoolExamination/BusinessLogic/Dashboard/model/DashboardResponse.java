package com.pegien.HighSchoolExamination.BusinessLogic.Dashboard.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DashboardResponse {

    private int students;

    private int users;

    private int exams;

}
