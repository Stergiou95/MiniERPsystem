package com.example.finalproj.service.impl;

import com.example.finalproj.dto.ProductsDTO;
import com.example.finalproj.mapper.ProductsMapper;
import com.example.finalproj.model.Products;
import com.example.finalproj.repository.ProductsRepository;
import com.example.finalproj.service.ProductsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class ProductsServiceImpl implements ProductsService {

    private final ProductsRepository productsRepository;
    private final ProductsMapper productsMapper;

    @Override
    public Products createProduct(ProductsDTO productsDTO) throws Exception {
        try {
            Products products = productsMapper.toEntity(productsDTO);
            productsRepository.save(products);
            log.info("Product created successfully: {}", productsDTO);
            return products;
        } catch (Exception e) {
            log.error("Error while creating product {}", productsDTO, e);
            throw e;
        }
    }


    @Override
    public ProductsDTO updateProduct(Long productId, ProductsDTO productsDTO) throws Exception {
        try {
            Products existingProduct = productsRepository.findById(productId)
                    .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));

            existingProduct.setName(productsDTO.getName());
            existingProduct.setPrice(productsDTO.getPrice());
            existingProduct.setConstructionTime(productsDTO.getConstructionTime());
            existingProduct.setLength(productsDTO.getLength());
            existingProduct.setWeight(productsDTO.getWeight());
            existingProduct.setThickness(productsDTO.getThickness());
            existingProduct.setCategory(productsMapper.toEntity(productsDTO).getCategory());

            productsRepository.save(existingProduct);

            log.info("Product updated successfully: {}", productsDTO);
            return productsMapper.toDTO(existingProduct);
        } catch (RuntimeException e) {
            log.error("Error while updating product with id {}", productId, e);
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while updating product with id {}", productId, e);
            throw new RuntimeException("An unexpected error occurred while updating the product", e);
        }
    }

    @Override
    public void deleteProduct(Long productId) throws Exception {
        try {
            if (!productsRepository.existsById(productId)) {
                throw new RuntimeException("Product not found with id: " + productId);
            }
            productsRepository.deleteById(productId);
            log.info("Product deleted successfully with id: {}", productId);
        } catch (Exception e) {
            log.error("Error while deleting product with id {}", productId, e);
            throw e;
        }
    }

    @Override
    public Products getProductByName(String productName) throws Exception {
        try {
            Optional<Products> product = productsRepository.findByName(productName);
            if (product.isPresent()) {
                log.info("Product found with name: {}", productName);
                return product.get();
            } else {
                log.warn("Product not found with name: {}", productName);
                throw new RuntimeException("Product not found with name: " + productName);
            }
        } catch (Exception e) {
            log.error("Error while retrieving product with name {}", productName, e);
            throw e;
        }
    }

    @Override
    public Products getProductById(Long productId) throws Exception {
        try {
            return productsRepository.findById(productId)
                    .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));
        } catch (Exception e) {
            log.error("Error while retrieving product with id {}", productId, e);
            throw e;
        }
    }

    @Override
    public List<ProductsDTO> getProducts() throws Exception {
        List<Products> productsList = productsRepository.findAll();
        return productsList.stream()
                .map(productsMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductsDTO> getProductsByCategoryName(String categoryName) throws Exception {
        try {
            List<Products> productsList = productsRepository.findByCategoryCategoryName(categoryName);
            log.info("Retrieved products for category with name: {}", categoryName);
            return productsList.stream()
                    .map(productsMapper::toDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Error retrieving products for category with name: {}", categoryName, e);
            throw e;
        }    }
}
