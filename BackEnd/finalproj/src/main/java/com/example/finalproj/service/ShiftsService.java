package com.example.finalproj.service;

import com.example.finalproj.dto.ShiftsDTO;
import com.example.finalproj.model.Shifts;

import java.util.List;

public interface ShiftsService {
    Shifts createShift(ShiftsDTO shiftDTO) throws Exception;
    Shifts updateShift(Long shiftID, ShiftsDTO shiftDTO) throws Exception;
    void deleteShift(Long shiftID) throws Exception;
    Shifts getShiftById(Long shiftID) throws Exception;
    List<Shifts> getAllShifts() throws Exception;
}
