package com.Doctors.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctorId", nullable = false)
    private Long doctorId;

    @Column(name = "Dr.name", nullable = false, length = 50)
    private String name;

    @Column(name = "mobile", nullable = false, length = 10)
    private String mobile;

    @Column(name = "qualification", nullable = false, length = 100)
    private String qualification;

    @Column(name = "specialist", nullable = false, length = 250)
    private String specialist;

    @Column(name = "experience", nullable = false, length = 20)
    private String experience;

    @Column(name = "email", nullable = false, length = 128)
    private String email;

}