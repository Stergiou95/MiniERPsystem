package com.example.finalproj.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductsOrdersDTO {
    private Long productID;
    private Long orderID;
    private int units;

}
