package com.example.campus_ease.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentsInfoRes {
    private String student_id;

    private String college_admission_number;

    private String email;

    private String first_name;

    private String last_name;

    private String percentage;

    private String roll_number;

    private String sgpa;

    private String branch_id;
}
