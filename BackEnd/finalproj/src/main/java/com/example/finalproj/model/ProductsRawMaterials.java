package com.example.finalproj.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PRODUCTS_RAW_MATERIALS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductsRawMaterials {

    @EmbeddedId
    private ProductsRawMaterialsID productsRawMaterialsID;

    @ManyToOne
    @MapsId("productID")
    @JoinColumn(name = "productID", nullable = false)
    private Products products;

    @ManyToOne
    @MapsId("rawMatID")
    @JoinColumn(name = "rawMatID", nullable = false)
    private RawMaterials rawMaterials;

    @Column(name = "quantity_per_product")
    private double quantityPerBatch;
}
