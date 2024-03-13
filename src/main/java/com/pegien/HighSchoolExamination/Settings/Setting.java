package com.pegien.HighSchoolExamination.Settings;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class Setting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;

    @Column(length = 10000)
    private String settingName;

    private String Stringvalue;

    private String[] StringArrayValue;

    private Integer integerValue;

    private Integer[] integerArrayValue;

    private Double doubleValue;

    private Double[] doubleArrayValue;

}
