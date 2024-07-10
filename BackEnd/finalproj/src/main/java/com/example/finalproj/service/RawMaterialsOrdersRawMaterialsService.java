package com.example.finalproj.service;

import com.example.finalproj.dto.RawMaterialsOrdersRawMaterialsDTO;
import com.example.finalproj.model.RawMaterialsOrdersRawMaterials;

import java.util.List;

public interface RawMaterialsOrdersRawMaterialsService {
    RawMaterialsOrdersRawMaterials addRawMaterialToOrder(RawMaterialsOrdersRawMaterialsDTO dto) throws Exception;
    RawMaterialsOrdersRawMaterials updateRawMaterialInOrder(Long rmorderID, Long rawMatID, RawMaterialsOrdersRawMaterialsDTO dto) throws Exception;
    void removeRawMaterialFromOrder(Long rmorderID, Long rawMatID) throws Exception;
    RawMaterialsOrdersRawMaterials getRawMaterialsOrdersRawMaterialsById(Long rmorderID, Long rawMatID) throws Exception;
    List<RawMaterialsOrdersRawMaterials> getAllRawMaterialsOrdersRawMaterials() throws Exception;
}
