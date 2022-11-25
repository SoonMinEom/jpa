package com.example.pppractice.controller;

import com.example.pppractice.domain.dto.HospitalResponse;
import com.example.pppractice.domain.dto.ReviewRequest;
import com.example.pppractice.domain.dto.ReviewResponse;
import com.example.pppractice.service.HospitalService;
import com.example.pppractice.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospitals")
@Slf4j
@RequiredArgsConstructor
public class HospitalController {

    private final ReviewService reviewService;
    private final HospitalService hospitalService;


    @PostMapping("/reviews")
    public ResponseEntity<ReviewResponse> createReview(@RequestBody ReviewRequest reviewRequest) {
        ReviewResponse reviewResponse = reviewService.createReview(reviewRequest);
        return ResponseEntity.ok().body(reviewResponse);
    }

    @GetMapping("/reviews/{id}")
    public ResponseEntity<ReviewResponse> getReview(@PathVariable Integer id) {
        ReviewResponse reviewResponse = reviewService.getReview(id);
        return ResponseEntity.ok().body(reviewResponse);
    }

    @GetMapping("/{id}/reviews")
    public ResponseEntity<List<ReviewResponse>> getReviews(@PathVariable Integer id){
        List<ReviewResponse> reviewResponseList = reviewService.getReviews(id);
        return ResponseEntity.ok().body(reviewResponseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HospitalResponse> getHospital(@PathVariable Integer id) {
        HospitalResponse hospitalResponse = hospitalService.getHospital(id);
        return ResponseEntity.ok().body(hospitalResponse);
    }
}
