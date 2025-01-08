package com.Doctors.Payload;

import lombok.Data;

@Data
public class PatientDto {
    private long patientId;
    private String name;
    private String address;
    private int age;
    private String mobile;
    private String gender;
    private String medicalHistory;
}
