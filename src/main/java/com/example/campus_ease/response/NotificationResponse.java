package com.example.campus_ease.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NotificationResponse {
    private Long id;

    private String receiverId;

    private String content;

    private String status;

}
