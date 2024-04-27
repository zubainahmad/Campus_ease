package com.example.campus_ease.dao;

import com.example.campus_ease.entity.JobPostedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface JobPostedRepo extends JpaRepository<JobPostedEntity,Long> {
       ArrayList<JobPostedEntity> findByBranchId(Long branchId);

       @Query(value="SELECT COUNT(DISTINCT(unnested_placed)) AS placed FROM \"public\".job_management_entity,unnest(placed_students) AS unnested_placed",nativeQuery = true)
       Long findPlaced();

       @Query(value = "SELECT COUNT(user_id) FROM \"public\".student_info_entity WHERE user_id NOT IN (SELECT (unnested_placed) AS placed FROM \"public\".job_management_entity,unnest(placed_students) AS unnested_placed)\n",nativeQuery = true)
       Long findUnplaced();

       @Query(value="WITH pika AS(\n" +
               "SELECT company_name, end_date, TO_DATE(end_date,'DD/MM/YYYY') AS date FROM \"public\".job_posted_entity\n" +
               "GROUP BY (company_name,end_date)\n" +
               ")\n" +
               "SELECT COUNT(pika.date) FROM pika WHERE pika.date > current_date\n",nativeQuery = true)
       Long findUpcomingDrives();
}
