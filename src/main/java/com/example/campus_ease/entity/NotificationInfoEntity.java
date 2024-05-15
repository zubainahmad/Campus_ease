package com.example.campus_ease.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotificationInfoEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String receiverId;

    private String content;

    private String status;
}
