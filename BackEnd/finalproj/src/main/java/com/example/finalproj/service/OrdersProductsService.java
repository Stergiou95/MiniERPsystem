package com.example.finalproj.service;

import com.example.finalproj.dto.ProductsOrdersDTO;
import com.example.finalproj.model.ProductsOrders;

import java.util.List;

public interface OrdersProductsService {
    ProductsOrders addProductToOrder(ProductsOrdersDTO ordersProductsDTO) throws Exception;
    ProductsOrders updateProductInOrder(Long orderID, Long productID, ProductsOrdersDTO ordersProductsDTO) throws Exception;
    void removeProductFromOrder(Long orderID, Long productID) throws Exception;
    ProductsOrders getOrdersProductsById(Long orderID, Long productID) throws Exception;
    List<ProductsOrders> getAllOrdersProducts() throws Exception;
}
