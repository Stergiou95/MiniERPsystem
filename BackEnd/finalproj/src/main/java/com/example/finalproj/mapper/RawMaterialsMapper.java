package com.example.finalproj.mapper;

import com.example.finalproj.dto.RawMaterialsDTO;
import com.example.finalproj.model.RawMaterials;
import com.example.finalproj.model.RawMaterialWarehouseRawMaterial;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class RawMaterialsMapper {

    public RawMaterialsDTO toDTO(RawMaterials rawMaterials) {
        int totalStockedQuantity = calculateTotalStockedQuantity(rawMaterials.getRawMaterialWarehouseRawMaterials());

        return new RawMaterialsDTO(
                rawMaterials.getRawMatID(),
                rawMaterials.getRawMaterialName(),
                rawMaterials.getRawMaterialDescription(),
                totalStockedQuantity
        );
    }

    public RawMaterials toEntity(RawMaterialsDTO rawMaterialsDTO) {
        RawMaterials rawMaterials = new RawMaterials();
        rawMaterials.setRawMatID(rawMaterialsDTO.getRawMatID());
        rawMaterials.setRawMaterialName(rawMaterialsDTO.getRawMaterialName());
        rawMaterials.setRawMaterialDescription(rawMaterialsDTO.getRawMaterialDescription());
        // The totalStockedQuantity field does not need to be set in the entity as it is a calculated field.
        return rawMaterials;
    }

    private int calculateTotalStockedQuantity(Set<RawMaterialWarehouseRawMaterial> rawMaterialsWarehouseRawMaterials) {
        if (rawMaterialsWarehouseRawMaterials == null) {
            return 0;
        }
        return rawMaterialsWarehouseRawMaterials.stream()
                .mapToInt(RawMaterialWarehouseRawMaterial::getStockedQuantity)
                .sum();
    }
}
