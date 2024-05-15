package com.example.campus_ease.application.impl;

import com.example.campus_ease.application.JobPostedApplication;
import com.example.campus_ease.dao.JobPostedRepo;
import com.example.campus_ease.management.JobPostedManagement;
import com.example.campus_ease.request.StudentArrayIds;
import com.example.campus_ease.shared.dto.JobPostedDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class JobPostedApplicationImpl implements JobPostedApplication {

    JobPostedManagement jobPostedManagement;

    JobPostedRepo jobPostedRepo;


    public JobPostedApplicationImpl(JobPostedManagement jobPostedManagement, JobPostedRepo jobPostedRepo) {
        this.jobPostedManagement = jobPostedManagement;
        this.jobPostedRepo = jobPostedRepo;
    }

    @Override
    public ArrayList<Long> addJob(JobPostedDto jobPostedDto) {
        ArrayList<JobPostedDto> standardJobPostedDto = jobPostedManagement.addJob(jobPostedDto);
        ArrayList<Long> jobIds = new ArrayList<>();
        for (JobPostedDto standardDto : standardJobPostedDto) {
            jobIds.add(standardDto.getId());
        }
        return jobIds;
    }


    @Override
    public void jobFill(String userId, Long jobId) {
        jobPostedManagement.jobFill(userId, jobId);
    }

    @Override
    public void addPlaced(StudentArrayIds studentArrayIds) {
        jobPostedManagement.addPlaced(studentArrayIds);
    }


}
