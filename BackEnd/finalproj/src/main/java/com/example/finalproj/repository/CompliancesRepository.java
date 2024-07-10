package com.example.finalproj.repository;

import com.example.finalproj.model.Compliances;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompliancesRepository extends JpaRepository<Compliances, Long> {
}
