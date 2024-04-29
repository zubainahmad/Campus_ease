package com.example.campus_ease.management;

import com.example.campus_ease.response.JobRes;
import com.example.campus_ease.response.JobsCcpdRes;
import com.example.campus_ease.response.JobsDataRes;
import com.example.campus_ease.response.JobsInfoRes;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;


public interface JobFetchManagement {
    public JobRes getJobs(String user_id);


    public List<JobsCcpdRes> getCcpdJobs();

    JobsDataRes getJobsData();

    JobsInfoRes getJobsInfo(ArrayList<Long> id);
}
