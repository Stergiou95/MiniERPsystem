package com.example.finalproj.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComplianceProductsDTO {

    private Long complianceID;
    private Long productID;
    private LocalDateTime expireDate;
}
