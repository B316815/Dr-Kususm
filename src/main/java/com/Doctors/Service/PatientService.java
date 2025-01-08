package com.Doctors.Service;

import com.Doctors.Entity.Patient;
import com.Doctors.Payload.PatientDto;

import java.util.List;

public interface PatientService {
    public PatientDto addPatient(PatientDto patientDto);

    public PatientDto updatePatient(Long id, PatientDto patientDto);
    public void deletePatient(Long id);
    List<PatientDto>AllPatients();

    public PatientDto patientUpdate(String mobile,PatientDto patientDto);
    public PatientDto GetPatientDetails(String mobile);

}
