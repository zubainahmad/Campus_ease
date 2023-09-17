package com.example.campus_ease.mapper;

import com.example.campus_ease.controller.JobPostedController;
import com.example.campus_ease.entity.JobPostedEntity;
import com.example.campus_ease.request.JobPostedReq;
import com.example.campus_ease.shared.dto.JobPostedDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JobPostedMapper {

    JobPostedDto jobPostedRequestToJobPostedDto(JobPostedReq jobPostedReq);

    JobPostedEntity jobPostedDtoToJobPostedEntity(JobPostedDto jobPostedDto);

    JobPostedDto jobPostedEntityToJobPostedDto(JobPostedEntity jobPostedEntity);

}
