package com.Doctors.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "clinic")
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clinicId", nullable = false)
    private Long clinicId;

    @Column(name = "clinicName", nullable = false, length = 50)
    private String clinicName;

    @Column(name = "adress", nullable = false, length = 250)
    private String address;

    @Column(name = "mobile", nullable = false, length = 10)
    private String mobile;

    @Column(name = "pincode", nullable = false, length = 6)
    private int pincode;

    @Column(name = "email", nullable = false, length = 128)
    private String email;

}