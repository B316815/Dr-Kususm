package com.Doctors.Service;

import com.Doctors.Payload.ClinicDto;

import java.util.List;

public interface ClinicService {

    public ClinicDto addClinic(ClinicDto clinicDto);
    public ClinicDto updateClinic(Long clinicId,ClinicDto clinicDto);
    List<ClinicDto>getAllClinic();
    public void deleteClinic(Long clinicId);
}
