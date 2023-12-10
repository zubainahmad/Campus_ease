package com.example.campus_ease.management;

import com.example.campus_ease.request.JobFetchReq;
import com.example.campus_ease.shared.dto.JobPostedDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


public interface JobFetchManagement {
    public ArrayList<JobPostedDto> getJobs(JobFetchReq jobFetchReq);
}
