package com.example.finalproj.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "LOCATIONS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Locations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "locationID")
    private Long locationID;

    @Column(name = "location_name", length = 100, nullable = false)
    private String location_name;



    //reverse relationship with the customers
    @OneToMany(mappedBy = "location")
    @JsonIgnore
    private Set<Customers> customers;

    //reverse relationship with the suppliers
    @OneToMany(mappedBy = "location")
    @JsonIgnore
    private Set<Suppliers> suppliers;

    //reverse relationship with the suppliers
    @OneToMany(mappedBy = "location")
    @JsonIgnore
    private Set<Partners> partners;

    //reverse relationship with the warehouses of raw materials
    @OneToMany(mappedBy = "location")
    @JsonIgnore
    private Set<WarehousesOfRawMaterials> warehousesOfRawMaterials;
}
