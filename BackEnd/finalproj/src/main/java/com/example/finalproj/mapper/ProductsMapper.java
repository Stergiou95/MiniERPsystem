package com.example.finalproj.mapper;

import com.example.finalproj.dto.ProductsDTO;
import com.example.finalproj.model.Products;
import com.example.finalproj.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductsMapper {

    @Autowired
    private CategoriesRepository categoriesRepository;

    public ProductsDTO toDTO(Products product) {
        return new ProductsDTO(
                product.getProductID(),
                product.getName(),
                product.getPrice(),
                product.getConstructionTime(),
                product.getLength(),
                product.getWeight(),
                product.getThickness(),
                product.getCategory().getCategoryID(),
                product.getCategory().getCategoryName() // Ανακτούμε την πληροφορία της κατηγορίας

        );
    }

    public Products toEntity(ProductsDTO dto) {
        Products product = new Products();
        if (dto.getProductID() != null) {
            product.setProductID(dto.getProductID());
        }
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setConstructionTime(dto.getConstructionTime());
        product.setLength(dto.getLength());
        product.setWeight(dto.getWeight());
        product.setThickness(dto.getThickness());
        product.setCategory(categoriesRepository.findById(dto.getCategoryID()).orElse(null));
        return product;
    }
}
