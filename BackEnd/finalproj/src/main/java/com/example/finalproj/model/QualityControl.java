package com.example.finalproj.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "QUALITY_CONTROL")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class QualityControl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "repID")
    private Long repID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resultID", nullable = false)
    private QCReports result; // Σχέση με τον πίνακα QC_REPORTS

    @Column(name = "report_date", nullable = false)
    private LocalDateTime reportDate;


    //reverse with productions
    @OneToMany(mappedBy = "qualityControl", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Productions> productions;
}
