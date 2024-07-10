package com.example.finalproj.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Table(name = "RAW_MATERIALS_ORDER_STATUS")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RawMaterialsOrderStatus {

    @EmbeddedId
    private RawMaterialsOrderStatusId rawMaterialsOrderStatusId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("rmorderID")
    @JoinColumn(name = "rmorderID", nullable = false)
    @JsonBackReference
    private OrdersForRawMaterials order;


    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("statusID")
    @JoinColumn(name = "status_id", nullable = false)
    @JsonBackReference
    private Statuses statuses;


    @Column(name = "date_of_status_change", nullable = false)
    private LocalDateTime dateOfStatusChange;

    public void setRawMaterialsOrderStatusId(RawMaterialsOrderStatusId rawMaterialsOrderStatusId) {this.rawMaterialsOrderStatusId = rawMaterialsOrderStatusId;}

}
