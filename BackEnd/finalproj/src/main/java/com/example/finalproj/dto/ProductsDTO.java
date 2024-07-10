package com.example.finalproj.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductsDTO {
    private Long productID;
    private String name;
    private double price;
    private int constructionTime;
    private double length;
    private double weight;
    private double thickness;
    private Long categoryID; // Αν η κατηγορία είναι απαραίτητη
    private String categoryName; // Νέο πεδίο για την κατηγορία

}
