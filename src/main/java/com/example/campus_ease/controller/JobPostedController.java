package com.example.campus_ease.controller;

import com.example.campus_ease.mapper.JobPostedMapper;
import com.example.campus_ease.request.JobPostedReq;
import com.example.campus_ease.service.JobPostedService;
import com.example.campus_ease.shared.dto.JobPostedDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/jobs")
public class JobPostedController {
    private JobPostedMapper jobPostedMapper;

    private JobPostedService jobPostedService;

    public JobPostedController(JobPostedMapper jobPostedMapper, JobPostedService jobPostedService) {
        this.jobPostedMapper = jobPostedMapper;
        this.jobPostedService = jobPostedService;
    }

    @PostMapping
    public ResponseEntity<String> addJob(@RequestBody JobPostedReq jobPostedReq){
        JobPostedDto jobPostedDto = jobPostedMapper.jobPostedRequestToJobPostedDto(jobPostedReq);
        JobPostedDto addedJob = jobPostedService.addJob(jobPostedDto);
        return ResponseEntity.ok().body("Job added successfully");
    }

}
