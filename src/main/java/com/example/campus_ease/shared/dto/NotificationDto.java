package com.example.campus_ease.shared.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NotificationDto {

    private Long id;

    private String receiverId;

    private String content;

    private String status;
}
