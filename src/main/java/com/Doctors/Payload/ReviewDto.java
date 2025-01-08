package com.Doctors.Payload;

import com.Doctors.Entity.Doctor;
import com.Doctors.Entity.User;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;


@Data

public class ReviewDto {
    private Long ratingId;
    @Max(5)
    @Min(1)
    private int rating;
    private String comment;
    private Doctor doctor;
    private User user;

}
