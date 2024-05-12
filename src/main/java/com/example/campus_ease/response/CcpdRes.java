package com.example.campus_ease.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CcpdRes {

    private String ccpd_id;

    private String email;

    private String first_name;

    private String last_name;

    private ArrayList<String> company_name;

}
