package com.Doctors.Controller;

import com.Doctors.Payload.ReportDto;
import com.Doctors.Service.ReportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/d1/report")

public class ReportController {
    private ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }
    @PostMapping("/addReport")
    public ResponseEntity<?>addReport(@RequestBody ReportDto reportDto){
        ReportDto reportDto1 = reportService.addReport(reportDto);
        return new ResponseEntity<>(reportDto1, HttpStatus.CREATED);
    }
    @PutMapping("/updateReport/{reportId}")
    public ResponseEntity UpdateReport(@PathVariable Long reportId,@RequestBody ReportDto reportDto){
        ReportDto reportDto1 = reportService.updateReport(reportId, reportDto);
        return new ResponseEntity<>(reportDto1,HttpStatus.OK);
    }
    @GetMapping("/allReport")
    public ResponseEntity <List<ReportDto>>GetAllReport(){
        List<ReportDto> reportDtos = reportService.GetAllReport();
        return ResponseEntity.ok(reportDtos);
    }
    @DeleteMapping("/deleteReport/{reportId}")
    public ResponseEntity deleteReport(@PathVariable Long reportId){
        reportService.deleteReport(reportId);
        return ResponseEntity.noContent().build();
    }

}
