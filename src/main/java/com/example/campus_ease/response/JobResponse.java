package com.example.campus_ease.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JobResponse {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("company_name")
    private String companyName;
    @JsonProperty("job_description")
    private String jobDescription;
    @JsonProperty("job_profile")
    private String jobProfile;
    @JsonProperty("exp_ctc")
    private String expCTC;
    @JsonProperty("reg_link")
    private String regLink;
    @JsonProperty("file")
    private String file;
    @JsonProperty("start_date")
    private String startDate;
    @JsonProperty("end_date")
    private String endDate;
    @JsonProperty("branches")
    private String branches;
    @JsonProperty("job_location")
    private String jobLocation;
    @JsonProperty("website_url")
    private String websiteUrl;
}
