package com.example.finalproj.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "OUTORDERSTATUS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OutOrderStatus {

    @EmbeddedId
    private OutOrderStatusId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("orderID")
    @JoinColumn(name = "orderID", nullable = false)
    @JsonBackReference
    private Orders order;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("statusID")
    @JoinColumn(name = "status_id", nullable = false)
    @JsonBackReference
    private Statuses status;

    @Column(name = "date_ordersales_status_changed", nullable = false)
    private LocalDateTime dateOrdersalesStatusChanged;


    public void setOutOrderStatusId(OutOrderStatusId outOrderStatusId) {
        this.id = outOrderStatusId;
    }
}
