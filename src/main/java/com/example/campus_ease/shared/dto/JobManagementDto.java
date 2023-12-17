package com.example.campus_ease.shared.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JobManagementDto {
    private Long id;


    private ArrayList<String> appliedStudents;

}
