package com.example.finalproj.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductsRawMaterialsDTO {
    private Long productID;
    private Long rawMatID;
    private int quantityPerProduct;
}
