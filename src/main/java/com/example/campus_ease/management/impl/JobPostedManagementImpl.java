package com.example.campus_ease.management.impl;

import com.example.campus_ease.management.JobPostedManagement;
import com.example.campus_ease.request.JobFillReq;
import com.example.campus_ease.shared.dto.JobPostedDto;

import com.example.campus_ease.service.JobPostedService;
import com.example.campus_ease.shared.dto.StudentAdditionDto;
import com.example.campus_ease.shared.utils.enums.Branch;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Transactional
@Component
public class JobPostedManagementImpl implements JobPostedManagement {
    private JobPostedService jobPostedService;

    public JobPostedManagementImpl(JobPostedService jobPostedService) {
        this.jobPostedService = jobPostedService;
    }

    @Override
    public JobPostedDto addJob(JobPostedDto jobPostedDto) {
        JobPostedDto standardJobPostedDto = getBranchId(jobPostedDto);
        return jobPostedService.addJob(standardJobPostedDto);
    }

    @Override
    public void jobFill(String userId, Long jobId) {
        jobPostedService.jobFill(userId, jobId);
    }

    JobPostedDto getBranchId(JobPostedDto jobPostedDto)
    {
        Long branchId;
        if(jobPostedDto.getBranch().equals("CS"))
            branchId = Branch.CS.getBranchId();
        else if(jobPostedDto.getBranch().equals("IT"))
            branchId = Branch.IT.getBranchId();
        else if(jobPostedDto.getBranch().equals("EE"))
            branchId = Branch.EE.getBranchId();
        else if(jobPostedDto.getBranch().equals("EC"))
            branchId = Branch.EC.getBranchId();
        else if(jobPostedDto.getBranch().equals("ME"))
            branchId = Branch.ME.getBranchId();
        else if(jobPostedDto.getBranch().equals("CE"))
            branchId = Branch.CE.getBranchId();
        else
            branchId = null;
        jobPostedDto.setBranchId(branchId);
        return jobPostedDto;
    }
}
