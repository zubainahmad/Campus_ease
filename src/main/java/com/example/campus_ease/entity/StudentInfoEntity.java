package com.example.campus_ease.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentInfoEntity {
    @Id
    private String userId;

    private String firstName;

    private String lastName;

    private String rollNumber;

    private String collegeAdmissionNumber;

    private String email;

    private Long tokenId;

    private Long branchId;

    private String SGPA;

    private String percentage;

    private String unknown1;

    private String unknown2;

}
