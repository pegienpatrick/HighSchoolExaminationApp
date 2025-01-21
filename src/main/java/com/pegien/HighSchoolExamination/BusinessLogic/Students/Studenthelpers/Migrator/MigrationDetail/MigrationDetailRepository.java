package com.pegien.HighSchoolExamination.BusinessLogic.Students.Studenthelpers.Migrator.MigrationDetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MigrationDetailRepository extends JpaRepository<MigrationDetail, UUID> {

    @Query("SELECT m FROM MigrationDetail m ORDER BY m.doneOn")
    List<MigrationDetail> findAllOrderByDoneOn();
}
