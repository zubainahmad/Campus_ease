package com.example.campus_ease.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class JobsCcpdRes {

    private ArrayList<Long> id;

    private String companyName;

    private Integer registered;

    private Integer pending;

    private String driveDate;

    private String postedBy;
}
