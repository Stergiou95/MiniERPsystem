package com.example.finalproj.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "MEMBERS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Members {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memberID")
    private Long memberID;

    @Column(name = "firstname", length = 255, nullable = false)
    private String firstname;

    @Column(name = "lastname", length = 255, nullable = false)
    private String lastname;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roleID", nullable = false)
    @JsonBackReference
    private Roles role;

    // Αντίστροφη σχέση με MembersShift
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<MembersShift> membersShifts;
}
