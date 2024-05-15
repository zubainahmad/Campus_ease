package com.example.campus_ease.dao;

import com.example.campus_ease.entity.NotificationInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepo extends JpaRepository<NotificationInfoEntity, Long> {
    List<NotificationInfoEntity> findByReceiverId(String receiverId);
}
