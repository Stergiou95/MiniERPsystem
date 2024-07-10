package com.example.finalproj.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "PRODUCTS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productID")
    private Long productID;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "construction_time", nullable = false)
    private int constructionTime;

    @Column(name = "length", nullable = false)
    private double length;

    @Column(name = "weight", nullable = false)
    private double weight;

    @Column(name = "thickness", nullable = false)
    private double thickness;

    // Σχέση με τον πίνακα CATEGORIES
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryID", nullable = false)
    @JsonBackReference
    private Categories category;

    // Αντίστροφη σχέση με ComplianceProducts
    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<ComplianceProducts> complianceProducts; // Χρήση Set για αποφυγή διπλότυπων

    // Αντίστροφη σχέση με ComplianceProducts
    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<ProductsOrders> ProductsOrders; // Χρήση Set για αποφυγή διπλότυπων

    public Products(Long productID) {
        this.productID = productID;
    }
}
