package com.example.finalproj.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RawMaterialsWarehouseRawMaterialsDTO {
    private Long rawMatID;
    private Long warehouseID;
    private int stockedQuantity;
}
