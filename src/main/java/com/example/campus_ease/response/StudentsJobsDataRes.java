package com.example.campus_ease.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentsJobsDataRes {

    private Long applied;

    private Long pending;

    private Long upcoming;
}
