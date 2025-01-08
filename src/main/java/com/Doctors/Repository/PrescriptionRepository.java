package com.Doctors.Repository;

import com.Doctors.Entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    Prescription findByPatient_PatientId(Long patientId);

    Prescription findByDoctor_DoctorId(Long doctorId);
}
