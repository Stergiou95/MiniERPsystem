package com.example.finalproj.service;

import com.example.finalproj.dto.WarehouseDTO;
import com.example.finalproj.model.WarehousesOfRawMaterials;

import java.util.List;

public interface WarehousesService {

    WarehousesOfRawMaterials createWarehouse(WarehouseDTO warehouseDTO) throws Exception;
    WarehousesOfRawMaterials updateWarehouse(Long warehouseId, WarehouseDTO warehouseDTO) throws Exception;
    void deleteWarehouse(Long warehouseId) throws Exception;
    WarehousesOfRawMaterials getWarehouseById(Long warehouseId) throws Exception;
    List<WarehousesOfRawMaterials> getAllWarehouses() throws Exception;
}
