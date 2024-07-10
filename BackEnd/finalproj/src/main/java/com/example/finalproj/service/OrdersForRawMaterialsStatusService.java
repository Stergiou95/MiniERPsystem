package com.example.finalproj.service;

import com.example.finalproj.dto.RawMaterialsOrderStatusDTO;
import com.example.finalproj.model.RawMaterialsOrderStatus;

import java.util.List;

public interface OrdersForRawMaterialsStatusService {

    RawMaterialsOrderStatus createStatus(RawMaterialsOrderStatusDTO statusDTO) throws Exception;
    RawMaterialsOrderStatus updateStatus(Long statusID, Long rmorderID, RawMaterialsOrderStatusDTO statusDTO) throws Exception;
    void deleteStatus(Long statusID, Long rmorderID) throws Exception;
    RawMaterialsOrderStatus getStatusById(Long statusID, Long rmorderID) throws Exception;
    List<RawMaterialsOrderStatus> getAllStatuses() throws Exception;
}
