package com.example.finalproj.service;

import com.example.finalproj.dto.RawMaterialsWarehouseRawMaterialsDTO;
import com.example.finalproj.model.RawMaterialWarehouseRawMaterial;

import java.util.List;

public interface RawMaterialsWarehousesRawMaterialsService {
    RawMaterialWarehouseRawMaterial addRawMaterialToWarehouse(RawMaterialsWarehouseRawMaterialsDTO dto) throws Exception;

    RawMaterialWarehouseRawMaterial updateRawMaterialInWarehouse(Long rawMatID, Long warehouseID, RawMaterialsWarehouseRawMaterialsDTO dto) throws Exception;

    void removeRawMaterialFromWarehouse(Long rawMatID, Long warehouseID) throws Exception;
    RawMaterialWarehouseRawMaterial getRawMaterialsWarehousesRawMaterialsById(Long rawMatID, Long warehouseID) throws Exception;


    List<RawMaterialWarehouseRawMaterial> getAllRawMaterialsWarehousesRawMaterials() throws Exception;
}
