package com.pegien.HighSchoolExamination.Settings.service;


import com.pegien.HighSchoolExamination.Settings.Setting;
import com.pegien.HighSchoolExamination.Settings.SettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SettingsService {

    @Autowired
    private SettingRepository settingRepository;


    public Setting getSetting(String setting,Setting defaultValue)
    {
        Optional<Setting> optionalSetting=settingRepository.findBySettingNameIgnoreCase(setting.trim());
        if(optionalSetting.isPresent())
            return optionalSetting.get();

        defaultValue.setSettingName(setting.trim());
        settingRepository.saveAndFlush(defaultValue);
        return defaultValue;
    }

    public void set(Setting setting){
        Optional<Setting> optionalSetting=settingRepository.findBySettingNameIgnoreCase(setting.getSettingName().trim());
        if(optionalSetting.isPresent())
            setting.setNum(optionalSetting.get().getNum());

        settingRepository.saveAndFlush(setting);
    }

}
