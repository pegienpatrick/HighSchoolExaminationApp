package com.pegien.HighSchoolExamination.Reports.ReportCards.controller;


import com.pegien.HighSchoolExamination.Reports.ReportCards.service.ReportCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reportCard/")
public class ReportCardController {

    @Autowired
    private ReportCardService reportCardService;

    @GetMapping("/viewReportCard/{examination}/{student}")
    public ResponseEntity<byte[]> viewReportCard(@PathVariable("examination") Long examination,@PathVariable("student") int admNo)
    {
        return reportCardService.viewReport(examination,admNo);
    }

}
