package com.example.campus_ease.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class JobsDataRes {

    private Long placed;

    private Long unplaced;

    private Long upcomingDrives;

    private Long totalOffers;
}
