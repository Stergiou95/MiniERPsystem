package com.example.finalproj.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "STATUSES")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Statuses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private Long statusId;


    @Column(name = "status_name", nullable = false, unique = true, length = 255)
    private String statusName;

    //reverse with rawmaterialsorderestatus
    @OneToMany(mappedBy = "statuses", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<RawMaterialsOrderStatus> rawMaterialsOrderStatuses;
}
