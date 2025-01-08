package com.Doctors.Payload;

import com.Doctors.Entity.Doctor;
import com.Doctors.Entity.Patient;
import lombok.Data;

import java.util.Date;

@Data
public class AppointmentDto {
    private Long appId;
    private Date date;
    private Doctor doctor;
    private Patient patient;


}
