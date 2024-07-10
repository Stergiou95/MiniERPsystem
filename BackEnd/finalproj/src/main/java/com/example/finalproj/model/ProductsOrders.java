package com.example.finalproj.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products_orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductsOrders {

    @EmbeddedId
    private ProductsOrdersID productsOrdersID;

    @Column(name = "units")
    private int units;

    @ManyToOne
    @MapsId("productID")
    @JoinColumn(name = "productID", nullable = false)
    @JsonBackReference
    private Products products;

    @ManyToOne
    @MapsId("orderID")
    @JoinColumn(name = "orderID", nullable = false)
    @JsonBackReference
    private Orders orders;

    public ProductsOrders(ProductsOrdersID productsOrdersID, int units) {
        this.productsOrdersID = productsOrdersID;
        this.units = units;
    }

}
