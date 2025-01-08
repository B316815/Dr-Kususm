package com.Doctors.Payload;

import lombok.Data;

@Data
public class DoctorDto {
    private Long doctorId;
    private String name;
    private String mobile;
    private String qualification;
    private String specialist;
    private String experience;
    private String email;
}
