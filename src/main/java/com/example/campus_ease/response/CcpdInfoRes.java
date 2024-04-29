package com.example.campus_ease.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CcpdInfoRes {

    private String ccpd_id;

    private String email;

    private String first_name;

    private String last_name;
}
