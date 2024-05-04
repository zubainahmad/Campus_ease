package com.example.campus_ease.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentsRes {

    private String userId;

    private String firstName;

    private String lastName;

    private String rollNumber;

    private String collegeAdmissionNumber;

    private String email;

    private String branch;

    private String sgpa;

    private String percentage;

    private String imageUrl;

}
