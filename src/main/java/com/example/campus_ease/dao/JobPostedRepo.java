package com.example.campus_ease.dao;

import com.example.campus_ease.entity.JobPostedEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface JobPostedRepo extends JpaRepository<JobPostedEntity,Long> {
       ArrayList<JobPostedEntity> findByDepartmentId(Long departmentId);
}
