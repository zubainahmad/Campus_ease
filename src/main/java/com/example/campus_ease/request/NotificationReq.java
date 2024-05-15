package com.example.campus_ease.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NotificationReq {

    private ArrayList<String> receiverId;

    private String content;

    private String status;
}
