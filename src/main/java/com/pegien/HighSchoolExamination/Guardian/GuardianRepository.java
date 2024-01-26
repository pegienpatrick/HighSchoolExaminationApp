package com.pegien.HighSchoolExamination.Guardian;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuardianRepository extends JpaRepository<Guardian,Long> {

    List<Guardian> findByStudent(Long num);
}
