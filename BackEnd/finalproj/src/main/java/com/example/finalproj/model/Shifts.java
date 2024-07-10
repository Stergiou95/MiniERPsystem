package com.example.finalproj.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "SHIFTS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Shifts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shiftid")
    private Long shiftID;

    @Column(name = "start_time", nullable = false)
    private String startTime;

    @Column(name = "end_time", nullable = false)
    private String endTime;

    // Αντίστροφη σχέση με MembersShift
    @OneToMany(mappedBy = "shift", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<MembersShift> membersShifts;

    //reverse with productions
    @OneToMany(mappedBy = "shifts", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Productions> productions;
}
