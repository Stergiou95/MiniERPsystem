package com.example.finalproj.repository;

import com.example.finalproj.model.MembersShift;
import com.example.finalproj.model.MembersShiftId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembersShiftRepository extends JpaRepository<MembersShift, MembersShiftId> {
}
