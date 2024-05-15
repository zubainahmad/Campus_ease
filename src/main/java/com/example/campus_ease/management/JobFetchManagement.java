package com.example.campus_ease.management;

import com.example.campus_ease.response.*;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;


public interface JobFetchManagement {
    public JobRes getJobs(String user_id);


    public List<JobsCcpdRes> getCcpdJobs();

    JobsDataRes getJobsData();

    JobsInfoRes getJobsInfo(ArrayList<Long> id);

    StudentsJobsInfoRes getStudentsJobsInfo(Long id);

    StudentsJobsDataRes getStudentsJobsData(String userId);

    List<PlacementDataRes> getPlacementData(ArrayList<Long> id);
}
