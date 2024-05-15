package com.example.campus_ease.dao;

import com.example.campus_ease.entity.JobPostedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

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

       @Query(value = "SELECT COUNT(first_name) FROM \"public\".job_posted_entity AS jp JOIN \"public\".student_info_entity AS se\n" +
               "ON jp.branch_id = se.branch_id ",nativeQuery = true)
       Long findtotalOffers();

       @Query(value = "WITH pika AS \n" +
               "(\n" +
               "\tSELECT * FROM student_info_entity WHERE user_id = :userId\n" +
               ")\n" +
               "SELECT COUNT(applied_students) FROM pika JOIN \"public\".job_posted_entity AS je ON je.branch_id \n" +
               "= pika.branch_id JOIN \"public\".job_management_entity AS jme ON jme.id \n" +
               "= je.management_id WHERE :userId = ANY(applied_students)",nativeQuery = true)
       Long findAppliedJobs(@Param("userId") String userId);

       @Query(value = "WITH pika AS \n" +
               "(\n" +
               "\tSELECT * FROM student_info_entity WHERE user_id = :userId\n" +
               ")\n" +
               "SELECT COUNT(applied_students) FROM pika JOIN \"public\".job_posted_entity AS je ON je.branch_id \n" +
               "= pika.branch_id JOIN \"public\".job_management_entity AS jme ON jme.id \n" +
               "= je.management_id WHERE NOT :userId = ANY(applied_students)",nativeQuery = true)
       Long findPendingJobs(@Param("userId") String userId);

       @Query(value = "WITH pika AS \n" +
               "(\n" +
               "\tSELECT * FROM student_info_entity WHERE user_id = :userId\n" +
               "),\n" +
               "pika2 AS(\n" +
               "SELECT end_date, TO_DATE(end_date,'DD/MM/YYYY') AS date FROM pika JOIN \"public\".job_posted_entity AS je ON je.branch_id\n" +
               "= pika.branch_id\n" +
               ")\n" +
               "SELECT COUNT(date) FROM pika2 WHERE date > current_date\n",nativeQuery = true)
       Long findUpcomingJobs(@Param("userId") String userId);


       @Query(value = "WITH pika AS(\n" +
               "SELECT company_name, se.user_id AS user_id, jme.applied_students AS applied_students FROM \"public\".job_posted_entity AS je JOIN  \"public\".job_management_entity\n" +
               "AS jme ON je.management_id = jme.id LEFT JOIN \"public\".student_info_entity AS se\n" +
               "ON se.branch_id = je.branch_id WHERE je.id IN :id\n" +
               ")\n" +
               "SELECT COUNT(user_id) FROM pika WHERE user_id = ANY(applied_students)",nativeQuery = true)
       Long findInJobRegistered(@Param("id") ArrayList<Long> id);


       @Query(value = "WITH pika AS(\n" +
               "SELECT company_name, se.user_id AS user_id, jme.applied_students AS applied_students FROM \"public\".job_posted_entity AS je JOIN  \"public\".job_management_entity\n" +
               "AS jme ON je.management_id = jme.id LEFT JOIN \"public\".student_info_entity AS se\n" +
               "ON se.branch_id = je.branch_id WHERE je.id IN :id\n" +
               ")\n" +
               "SELECT COUNT(user_id) FROM pika WHERE NOT user_id = ANY(applied_students)",nativeQuery = true)
       Long findInJobPending(@Param("id") ArrayList<Long> id);

       @Query(value = "WITH pika AS(\n" +
               "SELECT company_name, se.user_id AS user_id, jme.applied_students AS applied_students FROM \"public\".job_posted_entity AS je JOIN  \"public\".job_management_entity\n" +
               "AS jme ON je.management_id = jme.id LEFT JOIN \"public\".student_info_entity AS se\n" +
               "ON se.branch_id = je.branch_id WHERE je.id IN :id\n" +
               ")\n" +
               "SELECT COUNT(user_id) FROM pika",nativeQuery = true)
       Long findInJobTotal(@Param("id") ArrayList<Long> id);


       @Query(value = "SELECT company_name FROM \"public\".job_posted_entity WHERE id IN :id GROUP BY company_name\n",nativeQuery = true)
         String findCompanyNameByIds(@Param("id") ArrayList<Long> id);

       @Query(value = "SELECT company_name FROM \"public\".job_posted_entity LIMIT 1",nativeQuery = true)
       String dbCheck();

       @Query(value = "SELECT ARRAY_AGG(se.user_id) FROM \"public\".job_posted_entity AS je JOIN \"public\".student_info_entity AS\n" +
               "se ON je.branch_id = se.branch_id WHERE company_name = :name",nativeQuery = true)
       ArrayList<String> findIdsAll(@Param("name") String name);

       @Query(value = "SELECT ARRAY_AGG(se.user_id) FROM \"public\".job_posted_entity AS je JOIN \"public\".student_info_entity AS\n" +
               "se ON je.branch_id = se.branch_id JOIN \"public\".job_management_entity AS jme ON jme.id = je.id WHERE company_name = :name\n" +
               "AND se.user_id = ANY(applied_students)\n",nativeQuery = true)
       ArrayList<String>  findIdsRegistered(@Param("name") String name);

       @Query(value = "SELECT ARRAY_AGG(se.user_id) FROM \"public\".job_posted_entity AS je JOIN \"public\".student_info_entity AS\n" +
               "se ON je.branch_id = se.branch_id JOIN \"public\".job_management_entity AS jme ON jme.id = je.id WHERE company_name = :name\n" +
               "AND NOT se.user_id = ANY(applied_students)\n",nativeQuery = true)
       ArrayList<String> findIdsUnregistered(@Param("name") String name);


       @Query(value = "SELECT branch_id FROM \"public\".student_info_entity WHERE user_id = :studentId",nativeQuery = true)
       Long findBranchId(@Param("studentId") String studentId);

}
