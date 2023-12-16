package com.example.campus_ease.service.impl;

import com.example.campus_ease.dao.JobPostedRepo;
import com.example.campus_ease.dao.StudentInfoRepo;
import com.example.campus_ease.entity.JobPostedEntity;
import com.example.campus_ease.mapper.JobPostedMapper;
import com.example.campus_ease.service.JobFetchService;
import com.example.campus_ease.shared.dto.JobPostedDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class JobFetchServiceImpl implements JobFetchService {
    private JobPostedRepo jobPostedRepo;

    private JobPostedMapper jobPostedMapper;

   private StudentInfoRepo studentInfoRepo;

    public JobFetchServiceImpl(JobPostedRepo jobPostedRepo, JobPostedMapper jobPostedMapper, StudentInfoRepo studentInfoRepo) {
        this.jobPostedRepo = jobPostedRepo;
        this.jobPostedMapper = jobPostedMapper;
        this.studentInfoRepo = studentInfoRepo;
    }

    @Override
    public ArrayList<JobPostedDto> getJobs (Long user_id) {
        Long departmentId = studentInfoRepo.findById(user_id).get().getBranchId();
        ArrayList<JobPostedEntity> jobPostedEntities = jobPostedRepo.findByDepartmentId(departmentId);
        ArrayList<Long> job_ids = new ArrayList<>();
        for (JobPostedEntity jobPostedEntity : jobPostedEntities) {
            ArrayList<Long> appliedStudents = jobPostedEntity.getManagement().getAppliedStudents();
            if(!appliedStudents.contains(user_id)){
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
