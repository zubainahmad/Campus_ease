package com.example.campus_ease.shared.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JobPostedDto {

    private Long id;

    private String userId;

    private String companyName;

    private String jobDescription;

    private String jobProfile;

    private String expCTC;

    private String regLink;

    private String file;

    private String startDate;

    private String endDate;

    private Long branchId;

    private ArrayList<String> branch;

    private JobManagementDto management;

    private String minimumPercentage;

    private String websiteUrl;

    private String jobLocation;


}
