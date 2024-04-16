package com.example.campus_ease.request;

import com.example.campus_ease.entity.JobManagementEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JobPostedReq {

    private String userId;

    private String companyName;

    private String jobDescription;

    private String jobProfile;

    private String expCTC;

    private String regLink;

    private String file;

    private String startDate;

    private String endDate;

    private ArrayList<String> branch;

    private JobManagementEntity management;

    private String minimumPercentage;

    private String websiteUrl;

    private String jobLocation;

}
