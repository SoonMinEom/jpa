package com.example.pppractice.service;

import com.example.pppractice.domain.dto.HospitalResponse;
import com.example.pppractice.domain.dto.ReviewResponse;
import com.example.pppractice.domain.entity.Hospital;
import com.example.pppractice.domain.entity.Review;
import com.example.pppractice.repository.HospitalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HospitalService {
    private final HospitalRepository hospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public HospitalResponse getHospital(Integer id) {
        Optional<Hospital> optionalHospital = hospitalRepository.findById(id);

        Hospital hospital = optionalHospital.get();

        List<ReviewResponse> reviewResponseList
                = hospital.getReviewList().stream()
                .map(review -> review.toResponse()).collect(Collectors.toList());

        HospitalResponse hospitalResponse = HospitalResponse.builder()
                .id(hospital.getId())
                .hospitalName(hospital.getHospitalName())
                .hospitalAddress(hospital.getHospitalAddress())
                .reviewResponseList(reviewResponseList)
                .build();

        return hospitalResponse;
    }
}
