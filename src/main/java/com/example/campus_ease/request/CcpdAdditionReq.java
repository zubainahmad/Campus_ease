package com.example.campus_ease.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CcpdAdditionReq {

    private String ccpdId;

    private String firstName;

    private String lastName;

    private String email;

}
