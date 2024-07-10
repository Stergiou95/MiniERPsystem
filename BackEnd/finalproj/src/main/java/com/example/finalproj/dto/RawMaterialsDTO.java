package com.example.finalproj.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RawMaterialsDTO {
    private Long rawMatID;
    private String rawMaterialName;
    private String rawMaterialDescription;
    private int totalStockedQuantity;

    public RawMaterialsDTO(Long rawMatID, String rawMaterialName, String rawMaterialDescription) {
        this.rawMatID = rawMatID;
        this.rawMaterialName = rawMaterialName;
        this.rawMaterialDescription = rawMaterialDescription;
    }
}
