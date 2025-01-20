package com.pegien.HighSchoolExamination.BusinessLogic.Reports.ReportCards.controller;


import com.pegien.HighSchoolExamination.BusinessLogic.Reports.ReportCards.service.ReportCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/bulkReportCards/{examination}/{grade}")
    public ResponseEntity<byte[]> viewReportCard(@PathVariable("examination") Long examination,@PathVariable("grade") Double grade, @RequestParam(name = "stream",required = false) String stream)
    {
        return reportCardService.viewBulkReport(examination,grade,stream);
    }

    @GetMapping("/smsReportCard/{examination}/{student}")
    public ResponseEntity<String> smsReportCard(@PathVariable("examination") Long examination,@PathVariable("student") int admNo)
    {
        return reportCardService.smsReportCard(examination,admNo);
    }

    @GetMapping("/smsReportCards/{examination}/{grade}")
    public ResponseEntity<String> smsReportCards(@PathVariable("examination") Long examination,@PathVariable("grade") Double grade, @RequestParam(name = "stream",required = false) String stream)
    {
        return reportCardService.smsReportCards(examination,grade,stream);
    }


}
