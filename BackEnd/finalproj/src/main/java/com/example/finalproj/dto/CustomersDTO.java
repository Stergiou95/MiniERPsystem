package com.example.finalproj.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomersDTO {

    private Long custID;
    private String companyName;
    private String email;
    private Long locationID; // Χρήση ID αντί για οντότητα Locations
    private String locationName;
}
