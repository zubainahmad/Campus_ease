package com.example.campus_ease.application.impl;

import com.example.campus_ease.application.JobPostedApplication;
import com.example.campus_ease.dao.JobPostedRepo;
import com.example.campus_ease.management.JobPostedManagement;
import com.example.campus_ease.service.NotififcationService;
import com.example.campus_ease.shared.dto.JobPostedDto;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class JobPostedApplicationImpl implements JobPostedApplication {

    JobPostedManagement jobPostedManagement;

    JobPostedRepo jobPostedRepo;


    NotififcationService notififcationService;

    public JobPostedApplicationImpl(JobPostedManagement jobPostedManagement, JobPostedRepo jobPostedRepo, NotififcationService notififcationService) {
        this.jobPostedManagement = jobPostedManagement;
        this.jobPostedRepo = jobPostedRepo;
        this.notififcationService = notififcationService;
    }

    @Override
    public JobPostedDto addJob(JobPostedDto jobPostedDto) {
        JobPostedDto standardJobPostedDto = jobPostedManagement.addJob(jobPostedDto);
        if(Objects.nonNull(jobPostedRepo.getById(standardJobPostedDto.getId())))
            notififcationService.sendNotification(standardJobPostedDto);
        return standardJobPostedDto;

    }


    @Override
    public void jobFill(String userId, Long jobId) {
        jobPostedManagement.jobFill(userId, jobId);
    }


}
