package com.example.finalproj.mapper;

import com.example.finalproj.dto.RawMaterialsWarehouseRawMaterialsDTO;
import com.example.finalproj.model.RawMaterialWarehouseRawMaterial;
import com.example.finalproj.repository.RawMaterialsRepository;
import com.example.finalproj.repository.WarehousesOfRawMaterialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RawMaterialsWarehouseRawMaterialsMapper {

    @Autowired
    private RawMaterialsRepository rawMaterialsRepository;

    @Autowired
    private WarehousesOfRawMaterialsRepository warehousesRepository;

    public RawMaterialsWarehouseRawMaterialsDTO toDTO(RawMaterialWarehouseRawMaterial rawMaterialsWarehouseRawMaterials) {
        return new RawMaterialsWarehouseRawMaterialsDTO(
                rawMaterialsWarehouseRawMaterials.getRawMaterials().getRawMatID(),
                rawMaterialsWarehouseRawMaterials.getWarehousesOfRawMaterials().getWarehouseID(),
                rawMaterialsWarehouseRawMaterials.getStockedQuantity()
        );
    }

    public RawMaterialWarehouseRawMaterial toEntity(RawMaterialsWarehouseRawMaterialsDTO dto) {
        RawMaterialWarehouseRawMaterial rawMaterialsWarehouseRawMaterials = new RawMaterialWarehouseRawMaterial();
        rawMaterialsWarehouseRawMaterials.setStockedQuantity(dto.getStockedQuantity());
        rawMaterialsWarehouseRawMaterials.setRawMaterials(
                rawMaterialsRepository.findById(dto.getRawMatID()).orElse(null)
        );
        rawMaterialsWarehouseRawMaterials.setWarehousesOfRawMaterials(
                warehousesRepository.findById(dto.getWarehouseID()).orElse(null)
        );
        return rawMaterialsWarehouseRawMaterials;
    }
}
