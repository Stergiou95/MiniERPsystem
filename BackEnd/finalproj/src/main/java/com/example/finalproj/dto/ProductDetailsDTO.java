package com.example.finalproj.dto;

//this dto is used for the cart implementation
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailsDTO {
    private Long productID;
    private String productName;
    private int units;
    private double pricePerUnit;
    private double totalCost;
}
