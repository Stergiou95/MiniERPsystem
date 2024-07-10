package com.example.finalproj.service.impl;

import com.example.finalproj.dto.ComplianceProductsDTO;
import com.example.finalproj.mapper.ComplianceProductsMapper;
import com.example.finalproj.model.ComplianceProducts;
import com.example.finalproj.model.ComplianceProductsID;
import com.example.finalproj.repository.ComplianceProductsRepository;
import com.example.finalproj.service.ComplianceProductsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class ComplianceProductsServiceImpl implements ComplianceProductsService {

    private final ComplianceProductsRepository repository;
    private final ComplianceProductsMapper mapper;

    @Override
    public ComplianceProducts addComplianceToProduct(ComplianceProductsDTO dto) throws Exception {
        ComplianceProducts entity = mapper.toEntity(dto);
        return repository.save(entity);
    }

    @Override
    public ComplianceProducts updateComplianceInProduct(Long complianceID, Long productID, ComplianceProductsDTO dto) throws Exception {
        ComplianceProductsID id = new ComplianceProductsID(complianceID, productID);
        ComplianceProducts entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ComplianceProducts not found with id: " + id));

        entity.setExpireDate(dto.getExpireDate());
        return repository.save(entity);
    }

    @Override
    public void removeComplianceFromProduct(Long complianceID, Long productID) throws Exception {
        ComplianceProductsID id = new ComplianceProductsID(complianceID, productID);
        if (!repository.existsById(id)) {
            throw new RuntimeException("ComplianceProducts not found with id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public ComplianceProducts getComplianceProductsById(Long complianceID, Long productID) throws Exception {
        ComplianceProductsID id = new ComplianceProductsID(complianceID, productID);
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ComplianceProducts not found with id: " + id));
    }

    @Override
    public List<ComplianceProducts> getAllComplianceProducts() throws Exception {
        return repository.findAll();
    }
}
