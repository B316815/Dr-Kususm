package com.Doctors.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patientId", nullable = false)
    private Long patientId;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "address", nullable = false, length = 250)
    private String address;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "mobile", nullable = false, length = 10)
    private String mobile;

    @Column(name = "gender", nullable = false, length = 10)
    private String gender;

    @Column(name = "medical_history", nullable = false, length = 250)
    private String medicalHistory;

}