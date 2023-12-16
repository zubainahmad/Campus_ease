package com.example.campus_ease.management;

import com.example.campus_ease.shared.dto.JobPostedDto;

import java.util.ArrayList;


public interface JobFetchManagement {
    public ArrayList<JobPostedDto> getJobs(Long user_id);
}
