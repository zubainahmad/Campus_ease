package com.example.campus_ease.request;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentAdditionReq {

    private String userId;

    private String firstName;

    private String lastName;

    private String rollNumber;

    private String collegeAdmissionNumber;

    private String email;

    private Long tokenId;

    private String branch;

    private String sgpa;

    private String percentage;

    private String unknown1;

    private String unknown2;
}
