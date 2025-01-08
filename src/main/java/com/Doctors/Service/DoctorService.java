package com.Doctors.Service;

import com.Doctors.Payload.DoctorDto;

import java.util.List;

public interface DoctorService {
    public DoctorDto addDoctor(DoctorDto doctorDto);
    public DoctorDto updateDoctor(Long doctorId,DoctorDto doctorDto);
    List<DoctorDto>getAllDoctor();

    public void deleteDoctor(Long doctorId);
}
