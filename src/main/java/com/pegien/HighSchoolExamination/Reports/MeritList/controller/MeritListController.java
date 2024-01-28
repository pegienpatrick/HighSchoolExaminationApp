package com.pegien.HighSchoolExamination.Reports.MeritList.controller;


import com.pegien.HighSchoolExamination.Reports.MeritList.MeritListItem.MeritListLine;
import com.pegien.HighSchoolExamination.Reports.MeritList.service.MeritListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/meritList")
public class MeritListController {

    @Autowired
    private MeritListService meritListService;


    @GetMapping("/generate/{examination}/{stage}")
    public ResponseEntity<List<MeritListLine>> generateMerit(@PathVariable("examination") Long examination, @PathVariable("stage") Double stage)
    {
        return ResponseEntity.ok(meritListService.generateMeritList(examination,stage));
    }

    @GetMapping("/viewMerit/{examination}/{stage}")
    public ResponseEntity<List<MeritListLine>> viewMerit(@PathVariable("examination") Long examination, @PathVariable("stage") Double stage, @RequestParam(required = false,name = "stream")String stream)
    {
        if(stream==null)
            return ResponseEntity.ok(meritListService.viewMeritList(examination,stage));
        else
            return ResponseEntity.ok(meritListService.viewMeritList(examination,stage,stream));
    }




}
