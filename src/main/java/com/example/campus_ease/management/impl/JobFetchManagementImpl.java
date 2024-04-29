package com.example.campus_ease.management.impl;

import com.example.campus_ease.management.JobFetchManagement;
import com.example.campus_ease.response.JobRes;
import com.example.campus_ease.response.JobsCcpdRes;
import com.example.campus_ease.response.JobsDataRes;
import com.example.campus_ease.response.JobsInfoRes;
import com.example.campus_ease.service.JobFetchService;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<JobsCcpdRes> getCcpdJobs() {
        return jobFetchService.getCcpdJobs();
    }

    @Override
    public JobsDataRes getJobsData() {
        return jobFetchService.getJobsData();
    }

    @Override
    public JobsInfoRes getJobsInfo(ArrayList<Long> id) {
        return jobFetchService.getJobsInfo(id);
    }
}
