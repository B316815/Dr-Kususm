package com.Doctors.Repository;

import com.Doctors.Entity.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClinicRepository extends JpaRepository<Clinic, Long> {
    Clinic findByClinicId(Long clinicId);
    List<Clinic>findAll();
    public void deleteById(Long clinicId);
}