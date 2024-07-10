package com.example.finalproj.mapper;

import com.example.finalproj.dto.RawMaterialsSuppliersDTO;
import com.example.finalproj.model.RawMaterialsSuppliers;
import com.example.finalproj.repository.RawMaterialsRepository;
import com.example.finalproj.repository.SuppliersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RawMaterialsSuppliersMapper {

    @Autowired
    private RawMaterialsRepository rawMaterialsRepository;

    @Autowired
    private SuppliersRepository suppliersRepository;

    public RawMaterialsSuppliersDTO toDTO(RawMaterialsSuppliers rawMaterialsSuppliers) {
        return new RawMaterialsSuppliersDTO(
                rawMaterialsSuppliers.getRawMaterials().getRawMatID(),
                rawMaterialsSuppliers.getSuppliers().getSupplierID(),
                rawMaterialsSuppliers.getCostPerUnit()
        );
    }

    public RawMaterialsSuppliers toEntity(RawMaterialsSuppliersDTO dto) {
        RawMaterialsSuppliers rawMaterialsSuppliers = new RawMaterialsSuppliers();
        rawMaterialsSuppliers.setCostPerUnit(dto.getCostPerUnit());
        rawMaterialsSuppliers.setRawMaterials(
                rawMaterialsRepository.findById(dto.getRawMatID()).orElse(null)
        );
        rawMaterialsSuppliers.setSuppliers(
                suppliersRepository.findById(dto.getSupplierID()).orElse(null)
        );
        return rawMaterialsSuppliers;
    }
}
