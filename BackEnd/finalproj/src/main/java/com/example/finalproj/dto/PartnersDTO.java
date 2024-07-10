package com.example.finalproj.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartnersDTO {
    private Long partnerID;
    private String companyName;
    private String email;
    private Long locationID; // ID της τοποθεσίας
    public String locationName;
}
