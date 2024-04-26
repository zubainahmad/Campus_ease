package com.example.campus_ease.service;

import com.example.campus_ease.response.JobRes;
import com.example.campus_ease.response.JobsCcpdRes;
import com.example.campus_ease.response.JobsDataRes;

import java.util.List;

public interface JobFetchService {
     JobRes getJobs(String user_id);

    List<JobsCcpdRes> getCcpdJobs() ;

    JobsDataRes getJobsData();
}
