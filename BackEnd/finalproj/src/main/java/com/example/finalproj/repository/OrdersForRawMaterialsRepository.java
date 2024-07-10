package com.example.finalproj.repository;

import com.example.finalproj.model.OrdersForRawMaterials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersForRawMaterialsRepository extends JpaRepository<OrdersForRawMaterials, Long> {
}
