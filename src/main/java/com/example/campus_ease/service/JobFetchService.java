package com.example.campus_ease.service;

import com.example.campus_ease.shared.dto.JobPostedDto;

import java.util.ArrayList;

public interface JobFetchService {
    public ArrayList<JobPostedDto> getJobs( Long user_id);
}
