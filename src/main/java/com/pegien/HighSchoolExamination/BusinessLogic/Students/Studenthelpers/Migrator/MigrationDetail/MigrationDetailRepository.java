package com.pegien.HighSchoolExamination.BusinessLogic.Students.Studenthelpers.Migrator.MigrationDetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MigrationDetailRepository extends JpaRepository<MigrationDetail, UUID> {
}
