package com.example.campus_ease.management.impl;

import com.example.campus_ease.management.JobFetchManagement;
import com.example.campus_ease.response.*;
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

    @Override
    public StudentsJobsInfoRes getStudentsJobsInfo(Long id) {
        return jobFetchService.getStudentsJobsInfo(id);
    }

    @Override
    public StudentsJobsDataRes getStudentsJobsData(String userId) {
        return jobFetchService.getStudentsJobsData(userId);
    }

    @Override
    public List<PlacementDataRes> getPlacementData(ArrayList<Long> id) {
        return jobFetchService.getPlacementData(id);
    }
}
