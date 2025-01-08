package com.Doctors.Repository;

import com.Doctors.Entity.Appointment;
import com.Doctors.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

//    List<Appointment> findByDoctor(Doctor doctor);
    List<Appointment>findAll();
    Optional<Appointment> findByAppId(Long appId);
    public void deleteByAppId(Long appId);

}