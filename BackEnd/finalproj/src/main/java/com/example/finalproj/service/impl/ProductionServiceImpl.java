package com.example.finalproj.service.impl;

import com.example.finalproj.dto.ProductionDTO;
import com.example.finalproj.mapper.ProductionMapper;
import com.example.finalproj.model.Productions;
import com.example.finalproj.repository.ProductionRepository;
import com.example.finalproj.service.ProductionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class ProductionServiceImpl implements ProductionService {

    private final ProductionRepository productionRepository;
    private final ProductionMapper productionMapper;

    @Override
    public Productions createProduction(ProductionDTO productionDTO) throws Exception {
        Productions production = productionMapper.toEntity(productionDTO);
        return productionRepository.save(production);
    }

    @Override
    public Productions updateProduction(Long productionID, ProductionDTO productionDTO) throws Exception {
        Productions production = productionRepository.findById(productionID)
                .orElseThrow(() -> new RuntimeException("Production not found with id: " + productionID));

        // Αντικαταστήστε τα παρακάτω με τα κατάλληλα πεδία προς ενημέρωση
        production.setOrders(productionMapper.toEntity(productionDTO).getOrders());
        production.setShifts(productionMapper.toEntity(productionDTO).getShifts());
        production.setQualityControl(productionMapper.toEntity(productionDTO).getQualityControl());
        return productionRepository.save(production);
    }

    @Override
    public void deleteProduction(Long productionID) throws Exception {
        if (!productionRepository.existsById(productionID)) {
            throw new RuntimeException("Production not found with id: " + productionID);
        }
        productionRepository.deleteById(productionID);
    }

    @Override
    public Productions getProductionById(Long productionID) throws Exception {
        return productionRepository.findById(productionID)
                .orElseThrow(() -> new RuntimeException("Production not found with id: " + productionID));
    }

    @Override
    public List<Productions> getAllProductions() throws Exception {
        return productionRepository.findAll();
    }
}
