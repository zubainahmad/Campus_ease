package com.example.campus_ease.dao;

import com.example.campus_ease.entity.CcpdInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CcpdInfoRepo extends JpaRepository<CcpdInfoEntity, Long> {
    @Query(value = "SELECT user_id FROM \"public\".job_posted_entity WHERE user_id = :userId GROUP BY (user_id)",nativeQuery = true)
    String userCheck(@Param("userId") String userId);
     @Query(value = "SELECT * FROM \"public\".ccpd_info_entity WHERE user_id = :userId",nativeQuery = true)
    CcpdInfoEntity findById(@Param("userId") String userId);
}
