package com.example.finalproj.mapper;

import com.example.finalproj.dto.ProductsOrdersDTO;
import com.example.finalproj.model.ProductsOrders;
import com.example.finalproj.repository.ProductsRepository;
import com.example.finalproj.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductsOrdersMapper {

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    public ProductsOrdersDTO toDTO(ProductsOrders productsOrders) {
        return new ProductsOrdersDTO(
                productsOrders.getProducts().getProductID(),
                productsOrders.getOrders().getOrderID(),
                productsOrders.getUnits()
        );
    }

    public ProductsOrders toEntity(ProductsOrdersDTO dto) {
        ProductsOrders productsOrders = new ProductsOrders();
        productsOrders.setUnits(dto.getUnits());
        productsOrders.setProducts(
                productsRepository.findById(dto.getProductID()).orElse(null)
        );
        productsOrders.setOrders(
                ordersRepository.findById(dto.getOrderID()).orElse(null)
        );
        return productsOrders;
    }
}
