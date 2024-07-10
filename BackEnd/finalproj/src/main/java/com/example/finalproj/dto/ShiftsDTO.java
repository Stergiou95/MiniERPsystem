package com.example.finalproj.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShiftsDTO {
    private Long shiftID;
    private String startTime;
    private String endTime;
}
