package com.example.finalproj.mapper;

import com.example.finalproj.dto.RawMaterialsOrdersRawMaterialsDTO;
import com.example.finalproj.model.RawMaterialsOrdersRawMaterials;
import com.example.finalproj.model.RawMaterialsOrdersRawMaterialsId;
import com.example.finalproj.repository.OrdersForRawMaterialsRepository;
import com.example.finalproj.repository.RawMaterialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RawMaterialsOrdersRawMaterialsMapper {

    @Autowired
    private OrdersForRawMaterialsRepository ordersForRawMaterialsRepository;

    @Autowired
    private RawMaterialsRepository rawMaterialsRepository;

    public RawMaterialsOrdersRawMaterialsDTO toDTO(RawMaterialsOrdersRawMaterials rawMaterialsOrdersRawMaterials) {
        return new RawMaterialsOrdersRawMaterialsDTO(
                rawMaterialsOrdersRawMaterials.getId().getRmorderID(),
                rawMaterialsOrdersRawMaterials.getId().getRawMatID(),
                rawMaterialsOrdersRawMaterials.getUnits()
        );
    }

    public RawMaterialsOrdersRawMaterials toEntity(RawMaterialsOrdersRawMaterialsDTO dto) {
        RawMaterialsOrdersRawMaterials rawMaterialsOrdersRawMaterials = new RawMaterialsOrdersRawMaterials();
        rawMaterialsOrdersRawMaterials.setId(new RawMaterialsOrdersRawMaterialsId(dto.getRmorderID(), dto.getRawMatID()));
        rawMaterialsOrdersRawMaterials.setOrder(ordersForRawMaterialsRepository.findById(dto.getRmorderID()).orElse(null));
        rawMaterialsOrdersRawMaterials.setRawMaterial(rawMaterialsRepository.findById(dto.getRawMatID()).orElse(null));
        rawMaterialsOrdersRawMaterials.setUnits(dto.getUnits());
        return rawMaterialsOrdersRawMaterials;
    }
}
