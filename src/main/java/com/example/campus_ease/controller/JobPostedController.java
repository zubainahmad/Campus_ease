package com.example.campus_ease.controller;

import com.example.campus_ease.application.JobPostedApplication;
import com.example.campus_ease.management.JobFetchManagement;
import com.example.campus_ease.mapper.JobPostedMapper;
import com.example.campus_ease.request.JobFillReq;
import com.example.campus_ease.request.JobPostedReq;
import com.example.campus_ease.request.StudentArrayIds;
import com.example.campus_ease.response.*;
import com.example.campus_ease.shared.dto.JobPostedDto;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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


    @GetMapping("/ping")
    public ResponseEntity<String> ping(){
        return ResponseEntity.ok().body("pong");
    }

    @PostMapping("/jobs")
    public ResponseEntity<ArrayList<Long>> addJob(@RequestBody JobPostedReq jobPostedReq){
        JobPostedDto jobPostedDto = jobPostedMapper.jobPostedRequestToJobPostedDto(jobPostedReq);
        ArrayList<Long> jobs = jobPostedApplication.addJob(jobPostedDto);
        return ResponseEntity.ok().body(jobs);
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


    @GetMapping("/jobs")
    public ResponseEntity<List<JobsCcpdRes>> getJobs(){
        return ResponseEntity.ok().body(jobFetchManagement.getCcpdJobs());
    }


    @GetMapping("/jobs/data")
    public ResponseEntity<JobsDataRes> getJobsData(){
        return ResponseEntity.ok().body(jobFetchManagement.getJobsData());
    }

    @GetMapping("/jobs/info")
    public ResponseEntity<JobsInfoRes> getJobsInfo(@RequestParam ArrayList<Long> id){
        return ResponseEntity.ok().body(jobFetchManagement.getJobsInfo(id));

    }

    @GetMapping("/students/jobs/info")
    public ResponseEntity<StudentsJobsInfoRes> getStudentsJobsInfo(@RequestParam Long id){
        return ResponseEntity.ok().body(jobFetchManagement.getStudentsJobsInfo(id));

    }


    @GetMapping("/students/jobs/data")
    public ResponseEntity<StudentsJobsDataRes> getStudentsJobsData(@RequestParam String userId){
        return ResponseEntity.ok().body(jobFetchManagement.getStudentsJobsData(userId));
    }

    @GetMapping("jobs/placement/data")
    public ResponseEntity<List<PlacementDataRes>> getPlacementData(@RequestParam ArrayList<Long> id){
        return ResponseEntity.ok().body(jobFetchManagement.getPlacementData(id));
    }

    @PostMapping("/jobs/students/placed")
    public ResponseEntity<String> addPlaced(@RequestBody StudentArrayIds studentArrayIds){
        jobPostedApplication.addPlaced(studentArrayIds);
        return ResponseEntity.ok().body("Added records successfully");
    }



}
