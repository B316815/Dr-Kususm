package com.Doctors.Payload;

import lombok.Data;

@Data
public class ClinicDto {
    private Long clinicId;
    private String clinicName;
    private String address;
    private int pincode;
    private String email;
    private String mobile;



}
