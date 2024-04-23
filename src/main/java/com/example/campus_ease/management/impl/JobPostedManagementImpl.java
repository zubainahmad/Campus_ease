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

import java.util.ArrayList;

@Transactional
@Component
public class JobPostedManagementImpl implements JobPostedManagement {
    private JobPostedService jobPostedService;

    public JobPostedManagementImpl(JobPostedService jobPostedService) {
        this.jobPostedService = jobPostedService;
    }

    @Override
    public ArrayList<JobPostedDto> addJob(JobPostedDto jobPostedDto) {
        ArrayList<JobPostedDto> standardJobPostedDto = new ArrayList<>();
        ArrayList<String> branches = jobPostedDto.getBranch();
        for (String branch:branches) {
            Long branchId = getBranchId(branch);
            jobPostedDto.setBranchId(branchId);
            JobPostedDto standardDto = jobPostedService.addJob(jobPostedDto);
            standardJobPostedDto.add(standardDto);
        }
        return standardJobPostedDto;
    }

    @Override
    public void jobFill(String userId, Long jobId) {
        jobPostedService.jobFill(userId, jobId);
    }

    Long getBranchId(String branch)
    {
        Long branchId;
        if(branch.equals("CS"))
            branchId = Branch.CS.getBranchId();
        else if(branch.equals("IT"))
            branchId = Branch.IT.getBranchId();
        else if(branch.equals("EN"))
            branchId = Branch.EN.getBranchId();
        else if(branch.equals("ECE"))
            branchId = Branch.ECE.getBranchId();
        else if(branch.equals("ME"))
            branchId = Branch.ME.getBranchId();
        else if(branch.equals("CE"))
            branchId = Branch.CE.getBranchId();
        else if (branch.equals("CSE"))
            branchId = Branch.CSE.getBranchId();
        else if(branch.equals("CSE-AIML"))
            branchId = Branch.CSE_AIML.getBranchId();
        else if(branch.equals("CSE-DS"))
            branchId = Branch.CSE_DS.getBranchId();
        else
            branchId = null;

        return branchId;
    }
}
