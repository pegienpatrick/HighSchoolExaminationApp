package com.pegien.HighSchoolExamination.BusinessLogic.Students.Studenthelpers.Migrator;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentsMigrationRepository extends JpaRepository<StudentMigration, UUID> {
    List<StudentMigration> findByMigrationDetail(UUID migrationId);
}
