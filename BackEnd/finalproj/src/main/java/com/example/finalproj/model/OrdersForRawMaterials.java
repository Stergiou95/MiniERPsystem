package com.example.finalproj.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ORDERS_FOR_RAW_MATERIALS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrdersForRawMaterials {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rmorderID")
    private Long rmorderID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_ID", nullable = false)
    @JsonBackReference
    private Suppliers supplier;

    //reverse with rawmaterialsorderestatus
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<RawMaterialsOrderStatus> rawMaterialsOrderStatuses = new HashSet<>();

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<RawMaterialsOrdersRawMaterials> rawMaterialsOrdersRawMaterials = new HashSet<>();

    @Transient
    private double totalCost;

    @Transient
    private LocalDateTime dateOfStatusChange;

    // Προσθήκη μεθόδου για υπολογισμό του totalCost
    public double calculateTotalCost() {
        return rawMaterialsOrdersRawMaterials.stream()
                .mapToDouble(orderRawMaterial -> {
                    double costPerUnit = orderRawMaterial.getRawMaterial().getRawMaterialsSuppliers().stream()
                            .filter(supplier -> supplier.getSuppliers().getSupplierID().equals(this.supplier.getSupplierID()))
                            .findFirst()
                            .map(RawMaterialsSuppliers::getCostPerUnit)
                            .orElse(0.0);
                    return costPerUnit * orderRawMaterial.getUnits();
                })
                .sum();
    }

    @PostLoad
    @PostPersist
    @PostUpdate
    public void updateTotalCost() {
        this.totalCost = calculateTotalCost();
    }
}
