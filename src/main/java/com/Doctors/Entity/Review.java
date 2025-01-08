package com.Doctors.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ratingId", nullable = false)
    private Long ratingId;

    @Column(name = "rating")
    private int rating;

    @Column(name = "comment", length = 500)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "doctor_doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

}