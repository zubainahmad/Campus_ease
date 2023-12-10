package com.example.campus_ease.controller;

import com.example.campus_ease.management.JobPostedManagement;
import com.example.campus_ease.mapper.JobPostedMapper;
import com.example.campus_ease.request.JobPostedReq;
import com.example.campus_ease.shared.dto.JobPostedDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobs")
public class JobPostedController {
    private JobPostedMapper jobPostedMapper;

    private JobPostedManagement jobPostedManagement;

    public JobPostedController(JobPostedMapper jobPostedMapper, JobPostedManagement jobPostedManagement) {
        this.jobPostedMapper = jobPostedMapper;
        this.jobPostedManagement = jobPostedManagement;
    }

    @PostMapping
    public ResponseEntity<String> addJob(@RequestBody JobPostedReq jobPostedReq){
        JobPostedDto jobPostedDto = jobPostedMapper.jobPostedRequestToJobPostedDto(jobPostedReq);
        JobPostedDto addedJob = jobPostedManagement.addJob(jobPostedDto);
        return ResponseEntity.ok().body("Job added successfully");
    }


}
