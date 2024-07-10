package com.example.finalproj.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "RAW_MATERIALS_SUPPLIERS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RawMaterialsSuppliers {

    @EmbeddedId
    private RawMaterialsSuppliersID rawMaterialsSuppliersID;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("rawMatID")
    @JoinColumn(name = "raw_matid", nullable = false)
    @JsonBackReference
    private RawMaterials rawMaterials;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("supplierID")
    @JoinColumn(name = "supplier_ID", nullable = false)
    @JsonBackReference
    private Suppliers suppliers;

    @Column(name = "CostPerUnit")
    private double costPerUnit;
}
