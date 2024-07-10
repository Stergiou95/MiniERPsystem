package com.example.finalproj.mapper;

import com.example.finalproj.dto.ComplianceProductsDTO;
import com.example.finalproj.model.ComplianceProducts;
import com.example.finalproj.model.ComplianceProductsID;
import com.example.finalproj.repository.CompliancesRepository;
import com.example.finalproj.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComplianceProductsMapper {

    @Autowired
    private CompliancesRepository compliancesRepository;

    @Autowired
    private ProductsRepository productsRepository;

    public ComplianceProductsDTO toDTO(ComplianceProducts complianceProducts) {
        return new ComplianceProductsDTO(
                complianceProducts.getComplianceProductsID().getComplianceID(),
                complianceProducts.getComplianceProductsID().getProductID(),
                complianceProducts.getExpireDate()
        );
    }

    public ComplianceProducts toEntity(ComplianceProductsDTO dto) {
        ComplianceProducts complianceProducts = new ComplianceProducts();
        complianceProducts.setComplianceProductsID(new ComplianceProductsID(dto.getComplianceID(), dto.getProductID()));
        complianceProducts.setCompliance(compliancesRepository.findById(dto.getComplianceID()).orElse(null));
        complianceProducts.setProducts(productsRepository.findById(dto.getProductID()).orElse(null));
        complianceProducts.setExpireDate(dto.getExpireDate());
        return complianceProducts;
    }
}
