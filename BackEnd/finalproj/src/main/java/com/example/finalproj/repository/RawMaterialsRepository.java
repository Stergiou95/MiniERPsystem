package com.example.finalproj.repository;

import com.example.finalproj.model.RawMaterials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RawMaterialsRepository extends JpaRepository<RawMaterials, Long> {
}
