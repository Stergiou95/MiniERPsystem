package com.example.finalproj.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "MEMBERS_SHIFT")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MembersShift {

    @EmbeddedId
    private MembersShiftId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("shiftID")
    @JoinColumn(name = "shiftID", nullable = false)
    @JsonBackReference
    private Shifts shift;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("memberID")
    @JoinColumn(name = "memberID", nullable = false)
    @JsonBackReference
    private Members member;
}
