package com.Doctors.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "username", nullable = false, length = 15)
    private String username;

    @Column(name = "email", nullable = false, length = 128)
    private String email;

    @Column(name = "mobile", nullable = false, length = 10)
    private String mobile;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

}