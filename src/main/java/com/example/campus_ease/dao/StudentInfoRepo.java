package com.example.campus_ease.dao;

import com.example.campus_ease.entity.StudentInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentInfoRepo extends JpaRepository<StudentInfoEntity,Long> {
}
