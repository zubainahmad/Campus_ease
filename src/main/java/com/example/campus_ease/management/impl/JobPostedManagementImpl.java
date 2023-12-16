package com.example.campus_ease.management.impl;

import com.example.campus_ease.management.JobPostedManagement;
import com.example.campus_ease.request.JobFillReq;
import com.example.campus_ease.shared.dto.JobPostedDto;

import com.example.campus_ease.service.JobPostedService;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Transactional
@Component
public class JobPostedManagementImpl implements JobPostedManagement {
    private JobPostedService jobPostedService;

    public JobPostedManagementImpl(JobPostedService jobPostedService) {
        this.jobPostedService = jobPostedService;
    }

    @Override
    public JobPostedDto addJob(JobPostedDto jobPostedDto) {
        return jobPostedService.addJob(jobPostedDto);
    }

    @Override
    public void jobFill(Long userId, Long jobId) {
        jobPostedService.jobFill(userId, jobId);
    }
}
