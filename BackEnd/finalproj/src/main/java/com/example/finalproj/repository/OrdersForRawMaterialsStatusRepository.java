package com.example.finalproj.repository;

import com.example.finalproj.model.RawMaterialsOrderStatus;
import com.example.finalproj.model.RawMaterialsOrderStatusId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersForRawMaterialsStatusRepository extends JpaRepository<RawMaterialsOrderStatus, RawMaterialsOrderStatusId> {
    // Εδώ μπορείτε να προσθέσετε προσαρμοσμένες μεθόδους εάν χρειαστεί
}
