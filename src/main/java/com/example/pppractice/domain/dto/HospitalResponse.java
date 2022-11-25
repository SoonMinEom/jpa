package com.example.pppractice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class HospitalResponse {
    private Integer id;
    private String hospitalName;
    private String hospitalAddress;
    private List<ReviewResponse> reviewResponseList;
}
