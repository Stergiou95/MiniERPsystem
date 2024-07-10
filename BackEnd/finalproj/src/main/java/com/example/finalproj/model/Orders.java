package com.example.finalproj.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ORDERS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ordersid")
    private Long orderID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "custID")
    @JsonBackReference
    private Customers customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "partnerID")
    @JsonBackReference
    private Partners partner;

    // Αντίστροφη σχέση με ComplianceProducts
    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<ProductsOrders> productsOrders = new HashSet<>(); // Αρχικοποίηση με κενό HashSet

    //reverse
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<OutOrderStatus> orderStatuses = new HashSet<>(); // Αρχικοποίηση με κενό HashSet


    @Transient // Δεν αποθηκεύεται στη βάση δεδομένων
    private double totalCost;


    @Transient
    private String status;

    @Transient
    private LocalDateTime dateOrderSalesStatusChanged; // Ημερομηνία αλλαγής status




}
