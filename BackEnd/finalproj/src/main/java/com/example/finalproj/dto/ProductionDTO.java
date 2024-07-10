package com.example.finalproj.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductionDTO {
    private Long productionID;
    private Long orderID;
    private Long shiftID;
    private Long repID;
}
