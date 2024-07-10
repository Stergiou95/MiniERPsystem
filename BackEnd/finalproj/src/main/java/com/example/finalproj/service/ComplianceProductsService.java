package com.example.finalproj.service;

import com.example.finalproj.dto.ComplianceProductsDTO;
import com.example.finalproj.model.ComplianceProducts;

import java.util.List;

public interface ComplianceProductsService {
    ComplianceProducts addComplianceToProduct(ComplianceProductsDTO dto) throws Exception;
    ComplianceProducts updateComplianceInProduct(Long complianceID, Long productID, ComplianceProductsDTO dto) throws Exception;
    void removeComplianceFromProduct(Long complianceID, Long productID) throws Exception;
    ComplianceProducts getComplianceProductsById(Long complianceID, Long productID) throws Exception;
    List<ComplianceProducts> getAllComplianceProducts() throws Exception;
}
