package com.example.finalproj.repository;

import com.example.finalproj.model.ProductsOrders;
import com.example.finalproj.model.ProductsOrdersID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsOrdersRepository extends JpaRepository<ProductsOrders, ProductsOrdersID> {
}
