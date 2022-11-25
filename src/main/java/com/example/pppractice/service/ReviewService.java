package com.example.pppractice.service;

import com.example.pppractice.domain.dto.ReviewRequest;
import com.example.pppractice.domain.dto.ReviewResponse;
import com.example.pppractice.domain.entity.Hospital;
import com.example.pppractice.domain.entity.Review;
import com.example.pppractice.repository.HospitalRepository;
import com.example.pppractice.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final HospitalRepository hospitalRepository;

    public ReviewService(ReviewRepository reviewRepository, HospitalRepository hospitalRepository) {
        this.reviewRepository = reviewRepository;
        this.hospitalRepository = hospitalRepository;
    }

    public ReviewResponse createReview(ReviewRequest reviewRequest) {
        Optional<Hospital> hospital = hospitalRepository.findById(reviewRequest.getHospital_id());
        Review review = Review.builder()
                .hospital(hospital.get())
                .userName(reviewRequest.getUserName())
                .title(reviewRequest.getTitle())
                .content(reviewRequest.getContent())
                .build();

        Review savedReview = reviewRepository.save(review);
        ReviewResponse reviewResponse = savedReview.toResponse();
        reviewResponse.setMessage("리뷰가 잘 등록 되었습니다.");

        return reviewResponse;
    }

    public ReviewResponse getReview(Integer id) {
        Optional<Review> optionalReview = reviewRepository.findById(id);
//        Review review = reviewRepository.findById(id).orElseThrow(()->new RuntimeException("해당 id가 없습니다"));
        ReviewResponse reviewResponse = optionalReview.get().toResponse();
        return reviewResponse;
    }

    public List<ReviewResponse> getReviews(Integer id) {
        Optional<Hospital> optionalHospital = hospitalRepository.findById(id);
        List<Review> reviewList = optionalHospital.get().getReviewList();
        List<ReviewResponse> reviewResponseList = reviewList.stream()
                .map(review -> review.toResponse()).collect(Collectors.toList());
        return reviewResponseList;
    }
}
