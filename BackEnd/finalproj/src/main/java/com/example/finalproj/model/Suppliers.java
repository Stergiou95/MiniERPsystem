package com.example.finalproj.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "SUPPLIERS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Suppliers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_ID")
    private Long supplierID;

    @Column(name = "company_name", length = 200, nullable = false)
    private String companyName;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "locationID", nullable = false)
    @JsonBackReference
    private Locations location;

    //reverse
    @OneToMany(mappedBy = "suppliers", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<RawMaterialsSuppliers> rawMaterialsSuppliers;

    //reverse
    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<OrdersForRawMaterials> orders;


    public Suppliers(Long supplierID) {
    }
}
