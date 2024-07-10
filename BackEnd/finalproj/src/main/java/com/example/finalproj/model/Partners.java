package com.example.finalproj.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "PARTNERS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Partners {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "partnerID")
    private Long partnerID;

    @Column(name = "Company_Name", length = 255, nullable = false)
    private String CompanyName;

    @Column(name = "email", length = 255, nullable = false)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "locationID", nullable = false)
    @JsonBackReference
    private Locations location;

    //reverse
    @OneToMany(mappedBy = "partner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Orders> orders;
}
