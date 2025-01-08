package com.Doctors.Payload;

import com.Doctors.Entity.Appointment;
import com.Doctors.Entity.Patient;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BillingDto {
    private Long billingId;
    private LocalDate date = LocalDate.now();
    private Long amount;
    private Patient patient;
    private Appointment appointment;
}
