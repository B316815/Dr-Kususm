package com.Doctors.Repository;

import com.Doctors.Entity.Patient;
import com.Doctors.Payload.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

//    Patient findByName(String name);

    Patient findByPatientId(Long patientId);

//    void deleteByPatientId(Long patientId);

    Patient findByMobile(String mobile);
    List<Patient>findAll();


}