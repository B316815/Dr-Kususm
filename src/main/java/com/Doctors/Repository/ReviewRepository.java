package com.Doctors.Repository;

import com.Doctors.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

//    List<Review> findByDoctorId(Long doctorId);
//    List<Review> findByUserId(Long userId);

//    @Query("select r from Review r where r.doctor.doctorId = ?1")
//    List<Review> findByDoctor_DoctorId(Long doctorId);
//
//    @Query("select r from Review r where r.doctor.doctorId = ?1 and r.user.id = ?2")
//    List<Review> findByDoctor_DoctorIdAndUser_Id(Long doctorId, Long id);
}