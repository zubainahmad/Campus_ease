package com.example.campus_ease.service.impl;

import com.example.campus_ease.controller.JobPostedController;
import com.example.campus_ease.dao.JobPostedRepo;
import com.example.campus_ease.entity.JobPostedEntity;
import com.example.campus_ease.mapper.JobPostedMapper;
import com.example.campus_ease.service.JobPostedService;
import com.example.campus_ease.shared.dto.JobPostedDto;
import org.springframework.stereotype.Service;

@Service
public class JobPostedServiceImpl implements JobPostedService {

    private JobPostedRepo jobPostedRepo;

   private JobPostedMapper jobPostedMapper;

    public JobPostedServiceImpl(JobPostedRepo jobPostedRepo, JobPostedMapper jobPostedMapper) {
        this.jobPostedRepo = jobPostedRepo;
        this.jobPostedMapper = jobPostedMapper;
    }

    @Override
    public JobPostedDto addJob(JobPostedDto jobPostedDto) {
        JobPostedEntity jobPostedEntity = jobPostedMapper.jobPostedDtoToJobPostedEntity(jobPostedDto);
        JobPostedEntity standardEntity = jobPostedRepo.save(jobPostedEntity);
        JobPostedDto addedJob = jobPostedMapper.jobPostedEntityToJobPostedDto(standardEntity);
        return addedJob;
    }
}
