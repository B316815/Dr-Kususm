package com.Doctors.Payload;

import com.Doctors.Entity.Doctor;
import com.Doctors.Entity.Patient;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PrescriptionDto {
    private Long id;
    private LocalDate date= LocalDate.now();
    private String description;
    private Patient patient;
    private Doctor doctor;

}
