package com.example.finalproj.repository;

import com.example.finalproj.model.Statuses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusesRepository extends JpaRepository<Statuses, Long> {
    // Μπορείς να προσθέσεις προσαρμοσμένες μεθόδους αν χρειαστείς
}
