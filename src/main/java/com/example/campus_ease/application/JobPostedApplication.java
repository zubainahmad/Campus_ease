package com.example.campus_ease.application;

import com.example.campus_ease.request.StudentArrayIds;
import com.example.campus_ease.shared.dto.JobPostedDto;
import jakarta.transaction.Transactional;

import java.util.ArrayList;


public interface JobPostedApplication {

    ArrayList<Long> addJob(JobPostedDto jobPostedDto);

    void jobFill(String userId, Long jobId);

    void addPlaced(StudentArrayIds studentArrayIds);
}
