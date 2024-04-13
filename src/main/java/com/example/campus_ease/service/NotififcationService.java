package com.example.campus_ease.service;

import com.example.campus_ease.shared.dto.JobPostedDto;

public interface NotififcationService {

    void sendNotification(JobPostedDto jobPostedDto);

}
