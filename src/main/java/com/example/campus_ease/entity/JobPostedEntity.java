package com.example.campus_ease.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    private String startDate;

    private String endDate;

    private String file;

    private Long departmentId;

    @OneToOne(targetEntity = JobManagementEntity.class, cascade = CascadeType.ALL)
    private JobManagementEntity management;

}
