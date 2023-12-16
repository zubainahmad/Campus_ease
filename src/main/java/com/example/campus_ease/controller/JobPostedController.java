package com.example.campus_ease.controller;

import com.example.campus_ease.management.JobFetchManagement;
import com.example.campus_ease.management.JobPostedManagement;
import com.example.campus_ease.mapper.JobPostedMapper;
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

    private JobPostedManagement jobPostedManagement;

    private JobFetchManagement jobFetchManagement;

    public JobPostedController(JobPostedMapper jobPostedMapper, JobPostedManagement jobPostedManagement, JobFetchManagement jobFetchManagement) {
        this.jobPostedMapper = jobPostedMapper;
        this.jobPostedManagement = jobPostedManagement;
        this.jobFetchManagement = jobFetchManagement;
    }

    @PostMapping("/jobs")
    public ResponseEntity<String> addJob(@RequestBody JobPostedReq jobPostedReq){
        JobPostedDto jobPostedDto = jobPostedMapper.jobPostedRequestToJobPostedDto(jobPostedReq);
        JobPostedDto addedJob = jobPostedManagement.addJob(jobPostedDto);
        return ResponseEntity.ok().body("Job added successfully");
    }

    @GetMapping("/jobs/{user_id}")
    public ResponseEntity<JobRes> getJobs(@PathVariable Long user_id){
        JobRes jobRes   = jobFetchManagement.getJobs(user_id);
        return ResponseEntity.ok().body(jobRes);
    }


}
