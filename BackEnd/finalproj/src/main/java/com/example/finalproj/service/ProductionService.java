package com.example.finalproj.service;

import com.example.finalproj.dto.ProductionDTO;
import com.example.finalproj.model.Productions;

import java.util.List;

public interface ProductionService {
    Productions createProduction(ProductionDTO productionDTO) throws Exception;
    Productions updateProduction(Long productionID, ProductionDTO productionDTO) throws Exception;
    void deleteProduction(Long productionID) throws Exception;
    Productions getProductionById(Long productionID) throws Exception;
    List<Productions> getAllProductions() throws Exception;
}
