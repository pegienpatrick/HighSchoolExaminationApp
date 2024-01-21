package com.pegien.HighSchoolExamination.Users;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pegien.HighSchoolExamination.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;

    private Gender gender;

    private String fname;

    @Column(unique = true)
    private String username;

    @JsonIgnore
    private String password;

    private HashSet<String> roles;

    private String email;

    private String phone;

}
