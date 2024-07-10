package com.example.finalproj.model;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class ProductsRawMaterialsID implements Serializable {

    private Integer productID;
    private Integer rawMatID;
}
