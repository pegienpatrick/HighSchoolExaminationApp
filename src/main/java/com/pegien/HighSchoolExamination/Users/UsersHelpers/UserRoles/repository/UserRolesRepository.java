package com.pegien.HighSchoolExamination.Users.UsersHelpers.UserRoles.repository;

import com.pegien.HighSchoolExamination.Users.UsersHelpers.UserRoles.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRolesRepository extends JpaRepository<UserRole,Long> {
    List<UserRole> findByUserId(Long num);

    Optional<UserRole> findByUserIdAndRoleName(Long num, String role);
}
