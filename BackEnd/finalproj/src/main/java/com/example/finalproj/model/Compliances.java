package com.example.finalproj.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "COMPLIANCES")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Compliances {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "compliance_id")
    private Long complianceID;


    @Column(name = "compliance_name", nullable = false, length = 255)
    private String compliance_name;

    @OneToMany(mappedBy = "compliance", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ComplianceProducts> complianceProducts;

}
