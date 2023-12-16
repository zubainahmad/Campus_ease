package com.example.campus_ease.shared.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentAdditionDto {
    private Long userId;

    private String firstName;

    private String lastName;

    private String rollNumber;

    private String collegeAdmissionNumber;

    private String email;

    private Long tokenId;

    private String branch;

    private Long branchId;

    private String SGPA;

    private String percentage;

    private String unknown1;

    private String unknown2;
}
