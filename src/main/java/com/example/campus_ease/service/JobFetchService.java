package com.example.campus_ease.service;

import com.example.campus_ease.response.JobRes;
import com.example.campus_ease.shared.dto.JobPostedDto;

import java.util.ArrayList;

public interface JobFetchService {
     JobRes getJobs(String user_id);
}
