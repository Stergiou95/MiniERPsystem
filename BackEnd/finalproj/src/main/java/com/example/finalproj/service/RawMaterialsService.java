package com.example.finalproj.service;

import com.example.finalproj.dto.RawMaterialsDTO;
import com.example.finalproj.model.RawMaterials;

import java.util.List;

public interface RawMaterialsService {
    RawMaterials createRawMaterials(RawMaterialsDTO rawMaterialsDTO) throws Exception;
    List<RawMaterialsDTO> getAllRawMaterials() throws Exception;
    RawMaterialsDTO getRawMaterialsById(Long id) throws Exception;
    RawMaterialsDTO updateRawMaterials(RawMaterialsDTO rawMaterialsDTO) throws Exception;
    void deleteRawMaterialsById(Long id) throws Exception;
}
