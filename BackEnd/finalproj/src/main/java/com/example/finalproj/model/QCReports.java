package com.example.finalproj.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "QC_REPORTS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class QCReports {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resultID")
    private Long resultID;

    @Column(name = "result", length = 100, nullable = false)
    private String result;

    // Αντίστροφη σχέση με QualityControl
    @OneToMany(mappedBy = "result", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<QualityControl> qualityControls; // Χρήση Set για αποφυγή διπλότυπων

    public QCReports orElse(Object o) {
        return this;
    }
}
