package com.example.campus_ease.application;

import com.example.campus_ease.shared.dto.JobPostedDto;
import jakarta.transaction.Transactional;


public interface JobPostedApplication {

    JobPostedDto addJob(JobPostedDto jobPostedDto);

    void jobFill(String userId, Long jobId);
}
