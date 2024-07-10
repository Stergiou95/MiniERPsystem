package com.example.finalproj.repository;

import com.example.finalproj.model.ComplianceProducts;
import com.example.finalproj.model.ComplianceProductsID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplianceProductsRepository extends JpaRepository<ComplianceProducts, ComplianceProductsID> {
}
