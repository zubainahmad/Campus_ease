package com.example.campus_ease.service.impl;

import com.example.campus_ease.service.NotififcationService;
import com.example.campus_ease.shared.dto.JobPostedDto;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Async
public class NotificationServiceImpl implements NotififcationService {

    @Override
    public void sendNotification(JobPostedDto jobPostedDto) {
           
    }
}
