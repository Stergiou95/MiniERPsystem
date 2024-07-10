package com.example.finalproj.repository;

import com.example.finalproj.model.RawMaterialsSuppliers;
import com.example.finalproj.model.RawMaterialsSuppliersID;
import io.micrometer.common.KeyValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RawMaterialsSuppliersRepository extends JpaRepository<RawMaterialsSuppliers, RawMaterialsSuppliersID> {
    Optional<RawMaterialsSuppliers> findByRawMaterialsSuppliersID_RawMatIDAndRawMaterialsSuppliersID_SupplierID(Long rawMatID, Long supplierID);

    List<RawMaterialsSuppliers> findBySuppliersSupplierID(Long supplierId);
}
