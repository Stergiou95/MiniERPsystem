package com.example.finalproj.repository;

import com.example.finalproj.model.Partners;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnersRepository extends JpaRepository<Partners, Long> {
}
