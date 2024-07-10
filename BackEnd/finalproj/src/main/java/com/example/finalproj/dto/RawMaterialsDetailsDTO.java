package com.example.finalproj.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RawMaterialsDetailsDTO {
    private Long rawMaterialID;
    private String rawMatName;
    private int units;
    private double pricePerUnit;
    private double totalCost;
}
