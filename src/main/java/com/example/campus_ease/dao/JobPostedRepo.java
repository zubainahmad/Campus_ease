package com.example.campus_ease.dao;

import com.example.campus_ease.entity.JobPostedEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostedRepo extends JpaRepository<JobPostedEntity,Long> {

}
