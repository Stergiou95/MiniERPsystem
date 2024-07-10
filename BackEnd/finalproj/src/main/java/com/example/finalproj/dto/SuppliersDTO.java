package com.example.finalproj.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuppliersDTO {
    private Long supplierID;
    private String companyName;
    private String email;
    private Long locationID;
    private String locationName;

}
