package com.example.finalproj.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "COMPLIANCE_PRODUCTS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ComplianceProducts {

    @EmbeddedId
    private ComplianceProductsID complianceProductsID;

    @ManyToOne
    @MapsId("complianceID")
    @JoinColumn(name = "compliance_id", nullable = false)
    private Compliances compliance;

    @ManyToOne
    @MapsId("productID")
    @JoinColumn(name = "productID", nullable = false)
    private Products products;

    @Column(name = "expire_date", nullable = false)
    private LocalDateTime expireDate;
}
