package com.Doctors.Payload;

import com.Doctors.Entity.Patient;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ReportDto {
    private Long reportId;
    private String name;
    private String report;
    private LocalDateTime date = LocalDateTime.now();
    private Patient patient;

}
