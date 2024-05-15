package com.example.campus_ease.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NotificationStatusReq {
    ArrayList<Long> id;
    String status;
}
