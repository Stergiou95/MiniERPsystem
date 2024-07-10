package com.example.finalproj.service;

import com.example.finalproj.dto.RawMaterialsSuppliersDTO;
import com.example.finalproj.model.RawMaterialsSuppliers;

import java.util.List;

public interface RawMaterialsSuppliersService {

    RawMaterialsSuppliers createRawMaterialsSupplier(RawMaterialsSuppliersDTO rawMaterialsSuppliersDTO) throws Exception;
    RawMaterialsSuppliers updateRawMaterialsSupplier(Long rawMatID, Long supplierID, RawMaterialsSuppliersDTO rawMaterialsSuppliersDTO) throws Exception;
    void deleteRawMaterialsSupplier(Long rawMatID, Long supplierID) throws Exception;
    RawMaterialsSuppliers getRawMaterialsSupplierById(Long rawMatID, Long supplierID) throws Exception;
    List<RawMaterialsSuppliers> getAllRawMaterialsSuppliers() throws Exception;
}
