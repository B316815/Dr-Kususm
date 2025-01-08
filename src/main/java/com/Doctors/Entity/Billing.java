package com.Doctors.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "billing")
public class Billing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BillingId", nullable = false)
    private Long billingId;

    @Column(name = "date")
    private LocalDate date = LocalDate.now();

    @Column(name = "amount", nullable = false)
    private Long amount;

    @ManyToOne
    @JoinColumn(name = "patient_patient_id")
    private Patient patient;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "appointment_app_id")
    private Appointment appointment;

}