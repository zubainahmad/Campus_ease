package com.example.campus_ease.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentsJobsInfoRes {
    private ArrayList<Long> id;

    private String company_name;

    private String end_date;

    private String expctc;

    private String file;

    private String job_description;

    private String job_profile;

    private String reg_link;

    private String start_date;

    private String minimum_percentage;

    private String job_location;

    private String website_url;

    private ArrayList<Long> branch_id;

    private ArrayList<String> branches = new ArrayList<>();
}
