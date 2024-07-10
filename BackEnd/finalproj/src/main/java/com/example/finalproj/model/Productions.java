package com.example.finalproj.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PRODUCTION")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Productions {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productionID")
    private Long productionID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderID", nullable = false)
    @JsonBackReference
    private Orders orders;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shiftID", nullable = false)
    @JsonBackReference
    private Shifts shifts;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "repID", nullable = false)
    @JsonBackReference
    private QualityControl qualityControl;
}
