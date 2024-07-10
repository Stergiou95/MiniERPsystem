package com.example.finalproj.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "RAW_MATERIALS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RawMaterials {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "raw_matid")
    private Long rawMatID;

    @Column(name = "raw_material_name", length = 255, nullable = false)
    private String rawMaterialName;

    @Column(name = "raw_material_description", length = 255, nullable = false)
    private String rawMaterialDescription;

    //reverse
    @OneToMany(mappedBy = "rawMaterials", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<RawMaterialWarehouseRawMaterial> rawMaterialWarehouseRawMaterials;

    //reverse
    @OneToMany(mappedBy = "rawMaterials", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<RawMaterialsSuppliers> rawMaterialsSuppliers;

    //reverse
    @OneToMany(mappedBy = "rawMaterial", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<RawMaterialsOrdersRawMaterials> rawMaterialsOrders;

    @OneToMany(mappedBy = "rawMaterial", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<RawMaterialsOrdersRawMaterials> rawMaterialsOrdersRawMaterials;

    @Transient
    private int totalStockedQuantity;

    // Προσθήκη μεθόδου για υπολογισμό του totalStockedQuantity
    public int calculateTotalStockedQuantity() {
        return rawMaterialWarehouseRawMaterials.stream()
                .mapToInt(RawMaterialWarehouseRawMaterial::getStockedQuantity)
                .sum();
    }
}
