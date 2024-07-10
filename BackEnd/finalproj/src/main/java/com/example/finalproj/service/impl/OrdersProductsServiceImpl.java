package com.example.finalproj.service.impl;


import com.example.finalproj.dto.ProductsOrdersDTO;
import com.example.finalproj.mapper.ProductsOrdersMapper;
import com.example.finalproj.model.ProductsOrders;
import com.example.finalproj.model.ProductsOrdersID;
import com.example.finalproj.repository.ProductsOrdersRepository;
import com.example.finalproj.service.OrdersProductsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class OrdersProductsServiceImpl implements OrdersProductsService {

    private final ProductsOrdersRepository ordersProductsRepository;
    private final ProductsOrdersMapper ordersProductsMapper;

    @Override
    public ProductsOrders addProductToOrder(ProductsOrdersDTO ordersProductsDTO) throws Exception {
        ProductsOrders ordersProducts = ordersProductsMapper.toEntity(ordersProductsDTO);
        return ordersProductsRepository.save(ordersProducts);
    }

    @Override
    public ProductsOrders updateProductInOrder(Long orderID, Long productID, ProductsOrdersDTO ordersProductsDTO) throws Exception {
        ProductsOrdersID id = new ProductsOrdersID(orderID, productID);
        ProductsOrders ordersProducts = ordersProductsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrdersProducts not found with id: " + id));

        ordersProducts.setUnits(ordersProductsDTO.getUnits());
        return ordersProductsRepository.save(ordersProducts);
    }

    @Override
    public void removeProductFromOrder(Long orderID, Long productID) throws Exception {
        ProductsOrdersID id = new ProductsOrdersID(orderID, productID);
        if (!ordersProductsRepository.existsById(id)) {
            throw new RuntimeException("OrdersProducts not found with id: " + id);
        }
        ordersProductsRepository.deleteById(id);
    }

    @Override
    public ProductsOrders getOrdersProductsById(Long orderID, Long productID) throws Exception {
        ProductsOrdersID id = new ProductsOrdersID(orderID, productID);
        return ordersProductsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrdersProducts not found with id: " + id));
    }

    @Override
    public List<ProductsOrders> getAllOrdersProducts() throws Exception {
        return ordersProductsRepository.findAll();
    }
}
