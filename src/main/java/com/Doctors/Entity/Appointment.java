package com.Doctors.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "appontment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appId", nullable = false)
    private Long appId;

    @Temporal(TemporalType.DATE)
    @Column(name = "date", nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "doctor_doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_patient_id")
    private Patient patient;


}