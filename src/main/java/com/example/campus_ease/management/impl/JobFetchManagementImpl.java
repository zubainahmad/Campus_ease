package com.example.campus_ease.management.impl;

import com.example.campus_ease.management.JobFetchManagement;
import com.example.campus_ease.response.JobRes;
import com.example.campus_ease.service.JobFetchService;
import com.example.campus_ease.shared.dto.JobPostedDto;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Transactional
@Component
public class JobFetchManagementImpl implements JobFetchManagement {
    private JobFetchService jobFetchService;

    public JobFetchManagementImpl(JobFetchService jobFetchService) {
        this.jobFetchService = jobFetchService;
    }

    @Override
    public JobRes getJobs(String user_id) {
        return jobFetchService.getJobs(user_id);
    }
}
