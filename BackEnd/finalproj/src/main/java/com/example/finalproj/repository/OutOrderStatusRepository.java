package com.example.finalproj.repository;

import com.example.finalproj.model.OutOrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutOrderStatusRepository extends JpaRepository<OutOrderStatus, Long> {
}