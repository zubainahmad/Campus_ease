package com.example.campus_ease.controller;

import com.example.campus_ease.application.JobPostedApplication;
import com.example.campus_ease.management.JobFetchManagement;
import com.example.campus_ease.management.JobPostedManagement;
import com.example.campus_ease.mapper.JobPostedMapper;
import com.example.campus_ease.request.JobFillReq;
import com.example.campus_ease.request.JobPostedReq;
import com.example.campus_ease.response.JobRes;
import com.example.campus_ease.response.JobResponse;
import com.example.campus_ease.shared.dto.JobPostedDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController

public class JobPostedController {
    private JobPostedMapper jobPostedMapper;

    private JobPostedApplication jobPostedApplication;

    private JobFetchManagement jobFetchManagement;

    public JobPostedController(JobPostedMapper jobPostedMapper, JobPostedApplication jobPostedApplication, JobFetchManagement jobFetchManagement) {
        this.jobPostedMapper = jobPostedMapper;
        this.jobPostedApplication = jobPostedApplication;
        this.jobFetchManagement = jobFetchManagement;
    }

    @PostMapping("/jobs")
    public ResponseEntity<String> addJob(@RequestBody JobPostedReq jobPostedReq){
        JobPostedDto jobPostedDto = jobPostedMapper.jobPostedRequestToJobPostedDto(jobPostedReq);
        JobPostedDto addedJob = jobPostedApplication.addJob(jobPostedDto);
        return ResponseEntity.ok().body("Job added successfully");
    }

    @GetMapping("/jobs/{user_id}")
    public ResponseEntity<JobRes> getJobs(@PathVariable String user_id){
        JobRes jobRes   = jobFetchManagement.getJobs(user_id);
        return ResponseEntity.ok().body(jobRes);
    }

    @PostMapping("/jobs/submit")
    public ResponseEntity<String> submitJob(@RequestBody JobFillReq jobFillReq){
        String userId = jobFillReq.getUserId();
        Long jobId = jobFillReq.getJobId();
        jobPostedApplication.jobFill(userId, jobId);
        return ResponseEntity.ok().body("Job submitted successfully");
    }


}
