package com.example.finalproj.repository;

import com.example.finalproj.model.Productions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionRepository extends JpaRepository<Productions, Long> {
}
