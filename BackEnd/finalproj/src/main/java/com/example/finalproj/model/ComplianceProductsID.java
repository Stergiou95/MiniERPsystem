package com.example.finalproj.model;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class ComplianceProductsID implements Serializable {

    private Long complianceID;
    private Long productID;
}
