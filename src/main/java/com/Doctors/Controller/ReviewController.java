package com.Doctors.Controller;

import com.Doctors.Payload.ReviewDto;
import com.Doctors.Service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/d1/review")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    @PostMapping("/addReview")
    public ResponseEntity<?>addReview(@RequestBody ReviewDto reviewDto){
        ReviewDto review = reviewService.createReview(reviewDto);
        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }
//    @PutMapping("/updateReview")
//    public ResponseEntity updateReview(@PathVariable )
}
