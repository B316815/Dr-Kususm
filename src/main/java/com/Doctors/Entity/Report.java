package com.Doctors.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "Report")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reportId", nullable = false)
    private Long reportId;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "report", nullable = false, length = 250)
    private String report;

    @Column(name = "date", nullable = false)
    private LocalDateTime date = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "patient_patient_id")
    private Patient patient;

}