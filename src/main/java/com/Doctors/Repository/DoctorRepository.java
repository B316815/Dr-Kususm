package com.Doctors.Repository;

import com.Doctors.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Doctor findByDoctorId(Long doctorId);

    List<Doctor> findAll();
}