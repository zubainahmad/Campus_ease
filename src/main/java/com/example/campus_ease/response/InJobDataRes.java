package com.example.campus_ease.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class InJobDataRes {
    private Long total;

    private Long registered;

    private Long unregistered;
}
