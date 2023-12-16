package com.example.campus_ease.management;

import com.example.campus_ease.request.JobFillReq;
import com.example.campus_ease.shared.dto.JobPostedDto;

public interface JobPostedManagement {
    JobPostedDto addJob(JobPostedDto jobPostedDto);

    void jobFill(Long userId, Long jobId);
}
