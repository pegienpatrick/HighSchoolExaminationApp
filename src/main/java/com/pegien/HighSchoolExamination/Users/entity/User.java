package com.pegien.HighSchoolExamination.Users.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pegien.HighSchoolExamination.Users.enums.RolesCategory;
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
@Entity(name="users")
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

    @Transient
    private HashSet<String> roles;

    private String email;

    private String phone;

    private Boolean deleted;


    private Boolean added;

    private Long addedOn;

    private Long actionBy;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "text default 'TEACHER'")
    private RolesCategory rolesCategory = RolesCategory.TEACHER;

}
