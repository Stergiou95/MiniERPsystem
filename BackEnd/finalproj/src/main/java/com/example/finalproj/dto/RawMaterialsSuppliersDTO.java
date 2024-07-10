package com.example.finalproj.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RawMaterialsSuppliersDTO {
    private Long rawMatID;
    private Long supplierID;
    private double costPerUnit;
}
