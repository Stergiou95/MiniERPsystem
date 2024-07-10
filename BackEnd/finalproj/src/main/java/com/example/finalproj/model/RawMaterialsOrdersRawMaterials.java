package com.example.finalproj.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "RAW_MATERIALS_ORDERS_RAW_MATERIALS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RawMaterialsOrdersRawMaterials {

    @EmbeddedId
    private RawMaterialsOrdersRawMaterialsId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("rmorderID")
    @JoinColumn(name = "rmorderID", nullable = false)
    @JsonBackReference
    private OrdersForRawMaterials order;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("rawMatID")
    @JoinColumn(name = "raw_matid", nullable = false)
    @JsonBackReference
    private RawMaterials rawMaterial;

    @Column(name = "units", nullable = false)
    private int units;

    public RawMaterialsOrdersRawMaterials(RawMaterialsOrdersRawMaterialsId rawMaterialsOrdersRawMaterialsId, int units){
        this.id = rawMaterialsOrdersRawMaterialsId;
        this.units = units;
    }
}
