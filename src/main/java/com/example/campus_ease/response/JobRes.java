package com.example.campus_ease.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JobRes {

    private ArrayList<JobResponse> filled;

    private ArrayList<JobResponse> unfilled;
}
