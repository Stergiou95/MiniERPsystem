package com.example.finalproj.service.impl;

import com.example.finalproj.dto.WarehouseDTO;
import com.example.finalproj.mapper.WarehouseMapper;
import com.example.finalproj.model.WarehousesOfRawMaterials;
import com.example.finalproj.repository.LocationsRepository;
import com.example.finalproj.repository.WarehousesOfRawMaterialsRepository;
import com.example.finalproj.service.WarehousesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class WarehousesServiceImpl implements WarehousesService {

    private final WarehousesOfRawMaterialsRepository warehousesRepository;
    private final WarehouseMapper warehouseMapper;
    private final LocationsRepository locationsRepository;

    @Override
    public WarehousesOfRawMaterials createWarehouse(WarehouseDTO warehouseDTO) throws Exception {
        WarehousesOfRawMaterials warehouse = warehouseMapper.toEntity(warehouseDTO);
        warehouse.setLocation(locationsRepository.findById(warehouseDTO.getLocationID()).orElseThrow(() -> new RuntimeException("Location not found")));
        return warehousesRepository.save(warehouse);
    }

    @Override
    public WarehousesOfRawMaterials updateWarehouse(Long warehouseId, WarehouseDTO warehouseDTO) throws Exception {
        WarehousesOfRawMaterials warehouse = warehousesRepository.findById(warehouseId).orElseThrow(() -> new RuntimeException("Warehouse not found with id: " + warehouseId));
        warehouse.setCapacity(warehouseDTO.getCapacity());
        warehouse.setLocation(locationsRepository.findById(warehouseDTO.getLocationID()).orElseThrow(() -> new RuntimeException("Location not found")));
        return warehousesRepository.save(warehouse);
    }

    @Override
    public void deleteWarehouse(Long warehouseId) throws Exception {
        if (!warehousesRepository.existsById(warehouseId)) {
            throw new RuntimeException("Warehouse not found with id: " + warehouseId);
        }
        warehousesRepository.deleteById(warehouseId);
    }

    @Override
    public WarehousesOfRawMaterials getWarehouseById(Long warehouseId) throws Exception {
        return warehousesRepository.findById(warehouseId).orElseThrow(() -> new RuntimeException("Warehouse not found with id: " + warehouseId));
    }

    @Override
    public List<WarehousesOfRawMaterials> getAllWarehouses() throws Exception {
        return warehousesRepository.findAll();
    }
}
