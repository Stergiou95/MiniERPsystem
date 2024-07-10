package com.example.finalproj.model;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "CUSTOMERS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "custID")
    private Long custID;

    @Column(name = "company_name", nullable = false, length = 255)
    private String companyName;

    @Column(name = "email", nullable = false, length = 255)
    private String email;

    // Σχέση με τον πίνακα LOCATIONS
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "locationID", nullable = false)
    @JsonBackReference
    private Locations location;

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private List<Orders> orders;
}