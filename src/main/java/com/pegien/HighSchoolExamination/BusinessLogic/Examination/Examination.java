package com.pegien.HighSchoolExamination.BusinessLogic.Examination;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Examination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;

    private String title;

    private int year;

    private int term;


    private String date;

    @Column(columnDefinition = "text default 'normal'")
    private String type;

    @Column(columnDefinition = "Boolean default false")
    private Boolean deleted;



    private String grades;

    private String reportCardMsg;

    private Boolean active = false;

    private Boolean pinned = false;

    private Double marksTo = 100.0;

    private ExaminationType examinationType = ExaminationType.Exam;

    public void setGrade(List<Integer> grades) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            this.grades = objectMapper.writeValueAsString(grades!=null?grades:Arrays.asList(1,2,3,4));
        } catch (IOException e) {
            // Handle the exception appropriately
//            e.printStackTrace();
        }
    }

    public List<Integer> getGrade() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(grades, new TypeReference<List<Integer>>() {});
        } catch (Exception e) {
            // Handle the exception appropriately
//            e.printStackTrace();
            return Arrays.asList(1,2,3,4);
        }
    }

}
