package com.example.finalproj.repository;

import com.example.finalproj.model.WarehousesOfRawMaterials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehousesOfRawMaterialsRepository extends JpaRepository<WarehousesOfRawMaterials, Long> {
}
