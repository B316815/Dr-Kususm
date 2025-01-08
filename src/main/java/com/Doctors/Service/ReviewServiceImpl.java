package com.Doctors.Service;

import com.Doctors.Entity.Review;
import com.Doctors.Payload.ReviewDto;
import com.Doctors.Repository.DoctorRepository;
import com.Doctors.Repository.ReviewRepository;
import com.Doctors.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class ReviewServiceImpl implements ReviewService{
        private ReviewRepository reviewRepository;
        private UserRepository userRepository;
        private DoctorRepository doctorRepository;
        private ModelMapper modelMapper;

    public ReviewServiceImpl(ReviewRepository ratingRepository, UserRepository userRepository, DoctorRepository doctorRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.doctorRepository = doctorRepository;
    }

    @Override
    public ReviewDto createReview(ReviewDto reviewDto) {
        Review review = modelMapper.map(reviewDto,Review.class);
        review.setUser(userRepository.findById(reviewDto.getUser().getId()).orElseThrow());
        review.setDoctor((doctorRepository.findByDoctorId(reviewDto.getDoctor().getDoctorId())));
        Review save = reviewRepository.save(review);
        return modelMapper.map(save, ReviewDto.class);
    }

//        public RatingDto createRating(RatingDto ratingDto) {
//            Rating rating = new Rating();
//            rating.setUser(userRepository.findById(ratingDto.getUserId()).orElseThrow());
//            rating.setDoctor(doctorRepository.findById(ratingDto.getDoctorId()).orElseThrow());
//            rating.setRatingValue(ratingDto.getRatingValue());
//            rating.setComment(ratingDto.getComment());
//
//            Rating savedRating = ratingRepository.save(rating);
//
//            ratingDto.setRatingId(savedRating.getRatingId());
//            return ratingDto;
//        }

//        public List<ReviewDto> getRatingsForDoctor(Long doctorId) {
//            List<Review> reviews = reviewRepository.findByDoctorId(doctorId);
//          return reviews.stream().map(review ->modelMapper.map(review, ReviewDto.class)).mapToInt(Review::getRating).collect(Collectors.toList());
//
//        }

//        private RatingDto mapToDto(Rating rating) {
//            RatingDto ratingDto = new RatingDto();
//            ratingDto.setRatingId(rating.getRatingId());
//            ratingDto.setUserId(rating.getUser().getId());
//            ratingDto.setDoctorId(rating.getDoctor().getDoctorId());
//            ratingDto.setRatingValue(rating.getRatingValue());
//            ratingDto.setComment(rating.getComment());
//            return ratingDto;
//        }

}

