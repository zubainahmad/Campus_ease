package com.example.campus_ease.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PlacementDataRes {

    private Long job_id;

    private Long branch_id;

    private String company_name;

    private String college_admission_number;

    private String name;

    private String roll_number;

    private String user_id;

    private String status;

}
