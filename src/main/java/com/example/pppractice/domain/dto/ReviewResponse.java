package com.example.pppractice.domain.dto;

import lombok.*;

import javax.persistence.Access;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ReviewResponse {
    private Integer id;
    private String hospitalName;
    private String userName;
    private String title;
    private String content;
    private String message;
}
