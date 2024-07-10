package com.example.finalproj.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RawMaterialsOrdersRawMaterialsDTO {

    private Long rmorderID;
    private Long rawMatID;
    private Integer units;
}
