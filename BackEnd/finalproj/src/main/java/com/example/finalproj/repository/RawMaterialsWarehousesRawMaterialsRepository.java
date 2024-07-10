package com.example.finalproj.repository;

import com.example.finalproj.model.RawMaterialWarehouseRawMaterial;
import com.example.finalproj.model.RawMaterialWarehouseRawMaterialID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RawMaterialsWarehousesRawMaterialsRepository extends JpaRepository<RawMaterialWarehouseRawMaterial, RawMaterialWarehouseRawMaterialID> {
    // Εδώ μπορείτε να προσθέσετε προσαρμοσμένες μεθόδους εάν χρειαστεί
}
