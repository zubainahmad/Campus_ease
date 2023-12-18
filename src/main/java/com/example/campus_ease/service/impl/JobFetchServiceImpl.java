package com.example.campus_ease.service.impl;

import com.example.campus_ease.dao.JobPostedRepo;
import com.example.campus_ease.dao.StudentInfoRepo;
import com.example.campus_ease.entity.JobPostedEntity;
import com.example.campus_ease.mapper.JobPostedMapper;
import com.example.campus_ease.response.JobRes;
import com.example.campus_ease.response.JobResponse;
import com.example.campus_ease.service.JobFetchService;
import com.example.campus_ease.shared.dto.JobPostedDto;
import com.example.campus_ease.shared.utils.enums.Branch;
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
    public JobRes getJobs (String user_id) {
        Long departmentId = studentInfoRepo.findById(user_id).get().getBranchId();
        ArrayList<JobPostedEntity> jobPostedEntities = jobPostedRepo.findByBranchId(departmentId);
        ArrayList<Long> unfilledID = new ArrayList<>();
        ArrayList<Long> filledID = new ArrayList<>();
        for (JobPostedEntity jobPostedEntity : jobPostedEntities) {
            ArrayList<String> appliedStudents = jobPostedEntity.getManagement().getAppliedStudents();
            if(!appliedStudents.contains(user_id)){
                unfilledID.add(jobPostedEntity.getId());
            }
            else
            {
                filledID.add(jobPostedEntity.getId());
            }
        }
        ArrayList<JobPostedDto> standardUnfilled = new ArrayList<>();
        for (Long job_id: unfilledID) {
            JobPostedEntity jobPostedEntity = jobPostedRepo.findById(job_id).get();
            standardUnfilled.add(jobPostedMapper.jobPostedEntityToJobPostedDto(jobPostedEntity));
        }

        ArrayList<JobPostedDto> standardFilled = new ArrayList<>();
        for (Long job_id: filledID) {
            JobPostedEntity jobPostedEntity = jobPostedRepo.findById(job_id).get();
            standardFilled.add(jobPostedMapper.jobPostedEntityToJobPostedDto(jobPostedEntity));
        }

        ArrayList<JobResponse> unfilled = new ArrayList<>();
        for (JobPostedDto jobPostedDto:standardUnfilled) {
            JobResponse jobResponse = jobPostedMapper.jobPostedDtoToJobResponse(jobPostedDto);
            jobPostedDto.setBranch(getBranchName(jobPostedDto));
            jobResponse.setBranch(jobPostedDto.getBranch());
            unfilled.add(jobResponse);
        }

        ArrayList<JobResponse> filled = new ArrayList<>();
        for (JobPostedDto jobPostedDto:standardFilled) {
            JobResponse jobResponse = jobPostedMapper.jobPostedDtoToJobResponse(jobPostedDto);
            jobPostedDto.setBranch(getBranchName(jobPostedDto));
            jobResponse.setBranch(jobPostedDto.getBranch());
            filled.add(jobResponse);
        }

        JobRes jobRes = new JobRes();
        jobRes.setFilled(filled);
        jobRes.setUnfilled(unfilled);

        return jobRes;
    }

    String  getBranchName(JobPostedDto jobPostedDto)
    {
        String name;
       if(jobPostedDto.getBranchId().equals(Branch.CS.getBranchId()))
           name = "CS";
         else if(jobPostedDto.getBranchId() .equals(Branch.IT.getBranchId()))
             name = "IT";
         else if(jobPostedDto.getBranchId().equals(Branch.EE.getBranchId()))
             name = "EE";
         else if (jobPostedDto.getBranchId().equals(Branch.EC.getBranchId()))
             name = "EC";
         else if(jobPostedDto.getBranchId().equals(Branch.ME.getBranchId()))
             name = "ME";
         else if(jobPostedDto.getBranchId().equals(Branch.CE.getBranchId()))
             name = "CE";
         else
             name = null;
         return name;
    }


}
