package com.example.finalproj.repository;

import com.example.finalproj.model.RawMaterialsOrdersRawMaterials;
import com.example.finalproj.model.RawMaterialsOrdersRawMaterialsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RawMaterialsOrdersRawMaterialsRepository extends JpaRepository<RawMaterialsOrdersRawMaterials, RawMaterialsOrdersRawMaterialsId> {
}
