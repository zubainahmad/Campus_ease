package com.example.campus_ease.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JobPostedEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String companyName;

    private String jobDescription;

    private String jobProfile;

    private String expCTC;

    private String regLink;

    String startDate;

    String endDate;
}
