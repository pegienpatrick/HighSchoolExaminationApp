package com.pegien.HighSchoolExamination.Settings;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SettingRepository extends JpaRepository<Setting,Long> {

    Optional<Setting> findBySettingNameIgnoreCase(String setting);


}
