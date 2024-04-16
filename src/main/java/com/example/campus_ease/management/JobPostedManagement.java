package com.example.campus_ease.management;

import com.example.campus_ease.request.JobFillReq;
import com.example.campus_ease.shared.dto.JobPostedDto;

import java.util.ArrayList;

public interface JobPostedManagement {
    ArrayList<JobPostedDto> addJob(JobPostedDto jobPostedDto);

    void jobFill(String userId, Long jobId);
}
