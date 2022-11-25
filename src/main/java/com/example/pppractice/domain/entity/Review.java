package com.example.pppractice.domain.entity;

import com.example.pppractice.domain.dto.ReviewResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userName;
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    public ReviewResponse toResponse() {
        return ReviewResponse.builder()
                .id(this.id)
                .hospitalName(this.hospital.getHospitalName())
                .userName(this.userName)
                .title(this.title)
                .content(this.content)
                .build();
    }
}
