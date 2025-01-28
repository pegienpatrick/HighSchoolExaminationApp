package com.pegien.HighSchoolExamination.Logs;


import com.pegien.HighSchoolExamination.Users.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;

    private Long date;

    @ManyToOne
    private User user;

    @Column(columnDefinition = "TEXT")
    private String log;


}
