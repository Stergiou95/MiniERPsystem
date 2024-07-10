package com.example.finalproj.service.impl;

import com.example.finalproj.dto.RawMaterialsOrderStatusDTO;
import com.example.finalproj.mapper.RawMaterialsOrderStatusMapper;
import com.example.finalproj.model.RawMaterialsOrderStatus;
import com.example.finalproj.model.RawMaterialsOrderStatusId;
import com.example.finalproj.repository.OrdersForRawMaterialsStatusRepository;
import com.example.finalproj.service.OrdersForRawMaterialsStatusService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class OrdersForRawMaterialsStatusServiceImpl implements OrdersForRawMaterialsStatusService {

    private final OrdersForRawMaterialsStatusRepository ordersForRawMaterialsStatusRepository;
    private final RawMaterialsOrderStatusMapper ordersForRawMaterialsStatusMapper;

    @Override
    public RawMaterialsOrderStatus createStatus(RawMaterialsOrderStatusDTO statusDTO) throws Exception {
        try {
            RawMaterialsOrderStatus status = ordersForRawMaterialsStatusMapper.toEntity(statusDTO);
            return ordersForRawMaterialsStatusRepository.save(status);
        } catch (Exception e) {
            log.error("Error creating status: {}", statusDTO, e);
            throw e;
        }
    }

    @Override
    public RawMaterialsOrderStatus updateStatus(Long statusID, Long rmorderID, RawMaterialsOrderStatusDTO statusDTO) throws Exception {
        try {
            RawMaterialsOrderStatusId id = new RawMaterialsOrderStatusId(statusID, rmorderID);
            RawMaterialsOrderStatus status = ordersForRawMaterialsStatusRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Status not found with id: " + id));

            status.setDateOfStatusChange(statusDTO.getDateOfStatusChange());
            return ordersForRawMaterialsStatusRepository.save(status);
        } catch (Exception e) {
            log.error("Error updating status with id: ({}, {})", statusID, rmorderID, e);
            throw e;
        }
    }

    @Override
    public void deleteStatus(Long statusID, Long rmorderID) throws Exception {
        try {
            RawMaterialsOrderStatusId id = new RawMaterialsOrderStatusId(statusID, rmorderID);
            if (!ordersForRawMaterialsStatusRepository.existsById(id)) {
                throw new RuntimeException("Status not found with id: " + id);
            }
            ordersForRawMaterialsStatusRepository.deleteById(id);
        } catch (Exception e) {
            log.error("Error deleting status with id: ({}, {})", statusID, rmorderID, e);
            throw e;
        }
    }

    @Override
    public RawMaterialsOrderStatus getStatusById(Long statusID, Long rmorderID) throws Exception {
        try {
            RawMaterialsOrderStatusId id = new RawMaterialsOrderStatusId(statusID, rmorderID);
            return ordersForRawMaterialsStatusRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Status not found with id: " + id));
        } catch (Exception e) {
            log.error("Error fetching status with id: ({}, {})", statusID, rmorderID, e);
            throw e;
        }
    }

    @Override
    public List<RawMaterialsOrderStatus> getAllStatuses() throws Exception {
        try {
            return ordersForRawMaterialsStatusRepository.findAll();
        } catch (Exception e) {
            log.error("Error fetching all statuses", e);
            throw e;
        }
    }
}
