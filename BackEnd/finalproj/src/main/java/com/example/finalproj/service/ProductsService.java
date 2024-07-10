package com.example.finalproj.service;

import com.example.finalproj.dto.ProductsDTO;
import com.example.finalproj.model.Products;

import java.util.List;

public interface ProductsService {

    Products createProduct(ProductsDTO productsDTO) throws Exception;
    ProductsDTO updateProduct(Long productId, ProductsDTO productsDTO) throws Exception;
    void deleteProduct(Long productId) throws Exception;
    Products getProductByName(String productName) throws Exception;
    Products getProductById(Long productId) throws Exception;
    List<ProductsDTO> getProducts() throws Exception;
    List<ProductsDTO> getProductsByCategoryName(String categoryName) throws Exception;


}
