package com.example.campus_ease.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class JobsCcpdRes {

    private String companyName;

    private String registered;

    private String pending;

    private String driveDate;
}
