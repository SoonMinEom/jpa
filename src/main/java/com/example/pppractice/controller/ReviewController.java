package com.example.pppractice.controller;

import com.example.pppractice.domain.dto.HospitalResponse;
import com.example.pppractice.domain.dto.ReviewRequest;
import com.example.pppractice.domain.dto.ReviewResponse;
import com.example.pppractice.service.HospitalService;
import com.example.pppractice.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@Slf4j
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewResponse> getReview(@PathVariable Integer id) {
        ReviewResponse reviewResponse = reviewService.getReview(id);
        return ResponseEntity.ok().body(reviewResponse);
    }

    @GetMapping("/{id}/reviews")
    public ResponseEntity<List<ReviewResponse>> getReviews(@PathVariable Integer id){
        List<ReviewResponse> reviewResponseList = reviewService.getReviews(id);
        return ResponseEntity.ok().body(reviewResponseList);
    }
}
