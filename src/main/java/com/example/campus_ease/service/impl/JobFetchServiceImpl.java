package com.example.campus_ease.service.impl;

import com.example.campus_ease.dao.JobPostedRepo;
import com.example.campus_ease.entity.JobPostedEntity;
import com.example.campus_ease.mapper.JobPostedMapper;
import com.example.campus_ease.request.JobFetchReq;
import com.example.campus_ease.service.JobFetchService;
import com.example.campus_ease.shared.dto.JobPostedDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class JobFetchServiceImpl implements JobFetchService {
    private JobPostedRepo jobPostedRepo;

    private JobPostedMapper jobPostedMapper;

    public JobFetchServiceImpl(JobPostedRepo jobPostedRepo, JobPostedMapper jobPostedMapper) {
        this.jobPostedRepo = jobPostedRepo;
        this.jobPostedMapper = jobPostedMapper;
    }

    @Override
    public ArrayList<JobPostedDto> getJobs(JobFetchReq jobFetchReq) {
        ArrayList<JobPostedEntity> jobPostedEntities = jobPostedRepo.findByDepartmentId(jobFetchReq.getDepartmentId());
        ArrayList<Long> job_ids = new ArrayList<>();
        for (JobPostedEntity jobPostedEntity : jobPostedEntities) {
            ArrayList<Long> appliedStudents = jobPostedEntity.getManagement().getAppliedStudents();
            if(!appliedStudents.contains(jobFetchReq.getStudentId())){
                job_ids.add(jobPostedEntity.getId());
            }
        }
        ArrayList<JobPostedDto> jobPostedDtos = new ArrayList<>();
        for (Long job_id:job_ids) {
            JobPostedEntity jobPostedEntity = jobPostedRepo.findById(job_id).get();
            jobPostedDtos.add(jobPostedMapper.jobPostedEntityToJobPostedDto(jobPostedEntity));
        }

        return jobPostedDtos;
    }


}
