package com.example.finalproj.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "RAW_MATERIALS_WAREHOUSE_RAW_MATERIALS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RawMaterialWarehouseRawMaterial {

    @EmbeddedId
    private RawMaterialWarehouseRawMaterialID RawMaterialWarehouseRawMaterialID;

    @ManyToOne
    @MapsId("warehouseID")
    @JoinColumn(name = "warehouseID", nullable = false)
    private WarehousesOfRawMaterials warehousesOfRawMaterials;

    @ManyToOne
    @MapsId("rawMatID")
    @JoinColumn(name = "raw_matid", nullable = false)
    private RawMaterials rawMaterials;

    @Column(name = "stockedQuantity", nullable = false)
    private int stockedQuantity;


}
