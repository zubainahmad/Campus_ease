package com.example.campus_ease.management;

import com.example.campus_ease.response.JobRes;
import com.example.campus_ease.response.JobsCcpdRes;

import java.util.List;


public interface JobFetchManagement {
    public JobRes getJobs(String user_id);


    public List<JobsCcpdRes> getCcpdJobs();
}
