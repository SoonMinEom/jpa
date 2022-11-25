package com.example.pppractice.domain.dto;

import com.example.pppractice.domain.entity.Review;
import com.example.pppractice.repository.HospitalRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewRequest {

    private Integer hospital_id;
    private String userName;
    private String title;
    private String content;

}
