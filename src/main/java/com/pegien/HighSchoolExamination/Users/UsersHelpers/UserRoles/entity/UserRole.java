package com.pegien.HighSchoolExamination.Users.UsersHelpers.UserRoles.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;

    private Long userId;

    private String roleName;

    private Long assignedBy;

    private Long assignedOn;


}
