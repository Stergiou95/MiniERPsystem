package com.example.finalproj.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "WAREHOUSES_OF_RAW_MATERIALS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WarehousesOfRawMaterials {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warehouseID")
    private Long warehouseID;

    @Column(name = "capacity")
    private double capacity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "locationID", nullable = false)
    private Locations location;

    @OneToMany(mappedBy = "warehousesOfRawMaterials", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<RawMaterialWarehouseRawMaterial> rawMaterialWarehouseRawMaterials;


}
