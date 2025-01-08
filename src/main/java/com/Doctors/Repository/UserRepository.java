package com.Doctors.Repository;

import com.Doctors.Entity.Review;
import com.Doctors.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);
    User getById(Long id);
    User findByUsername(String usename);
    List<User>findAll();
    void deleteById(Long id);


}