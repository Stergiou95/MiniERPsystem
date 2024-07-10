package com.example.finalproj.service.impl;

import com.example.finalproj.dto.RawMaterialsWarehouseRawMaterialsDTO;
import com.example.finalproj.mapper.RawMaterialsWarehouseRawMaterialsMapper;
import com.example.finalproj.model.RawMaterialWarehouseRawMaterial;
import com.example.finalproj.model.RawMaterialWarehouseRawMaterialID;
import com.example.finalproj.repository.RawMaterialsWarehousesRawMaterialsRepository;
import com.example.finalproj.service.RawMaterialsWarehousesRawMaterialsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class RawMaterialsWarehousesRawMaterialsServiceImpl implements RawMaterialsWarehousesRawMaterialsService {

    private final RawMaterialsWarehousesRawMaterialsRepository repository;
    private final RawMaterialsWarehouseRawMaterialsMapper mapper;

    @Override
    public RawMaterialWarehouseRawMaterial addRawMaterialToWarehouse(RawMaterialsWarehouseRawMaterialsDTO dto) throws Exception {
        RawMaterialWarehouseRawMaterial entity = mapper.toEntity(dto);
        return repository.save(entity);
    }

    @Override
    public RawMaterialWarehouseRawMaterial updateRawMaterialInWarehouse(Long rawMatID, Long warehouseID, RawMaterialsWarehouseRawMaterialsDTO dto) throws Exception {
        RawMaterialWarehouseRawMaterialID id = new RawMaterialWarehouseRawMaterialID(rawMatID, warehouseID);
        RawMaterialWarehouseRawMaterial entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("RawMaterialsWarehousesRawMaterials not found with id: " + id));

        entity.setStockedQuantity(dto.getStockedQuantity());
        return repository.save(entity);
    }

    @Override
    public void removeRawMaterialFromWarehouse(Long rawMatID, Long warehouseID) throws Exception {
        RawMaterialWarehouseRawMaterialID id = new RawMaterialWarehouseRawMaterialID(rawMatID, warehouseID);
        if (!repository.existsById(id)) {
            throw new RuntimeException("RawMaterialsWarehousesRawMaterials not found with id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public RawMaterialWarehouseRawMaterial getRawMaterialsWarehousesRawMaterialsById(Long rawMatID, Long warehouseID) throws Exception {
        RawMaterialWarehouseRawMaterialID id = new RawMaterialWarehouseRawMaterialID(rawMatID, warehouseID);
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("RawMaterialsWarehousesRawMaterials not found with id: " + id));
    }

    @Override
    public List<RawMaterialWarehouseRawMaterial> getAllRawMaterialsWarehousesRawMaterials() throws Exception {
        return repository.findAll();
    }
}
