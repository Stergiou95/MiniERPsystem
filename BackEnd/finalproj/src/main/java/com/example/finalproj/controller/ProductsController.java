package com.example.finalproj.controller;

import com.example.finalproj.dto.ProductsDTO;
import com.example.finalproj.model.Products;
import com.example.finalproj.service.ProductsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ProductsController {

    private final ProductsService productsService;



    @GetMapping
    public List<ProductsDTO> getAllProducts() throws Exception {
        return productsService.getProducts();
    }

    @GetMapping("/{id}")
    public Products getProductById(@PathVariable Long id) throws Exception {
        return productsService.getProductById(id);
    }

    @GetMapping("/name")
    public Products getProductByName(@RequestParam String name) throws Exception {
        return productsService.getProductByName(name);
    }

    @GetMapping("/categoryName")
    public List<ProductsDTO> getProductsByCategoryName(@RequestParam String categoryName) throws Exception {
        return productsService.getProductsByCategoryName(categoryName);
    }

    @PostMapping
    public Products createProduct(@RequestBody ProductsDTO productsDTO) throws Exception {
        return productsService.createProduct(productsDTO);
    }

    @PutMapping("/{id}")
    public ProductsDTO updateProduct(@PathVariable Long id, @RequestBody ProductsDTO productsDTO) throws Exception {
        return productsService.updateProduct(id, productsDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) throws Exception {
        productsService.deleteProduct(id);
    }

}
