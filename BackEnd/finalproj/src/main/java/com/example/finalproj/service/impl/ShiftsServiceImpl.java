package com.example.finalproj.service.impl;

import com.example.finalproj.dto.ShiftsDTO;
import com.example.finalproj.mapper.ShiftsMapper;
import com.example.finalproj.model.Shifts;
import com.example.finalproj.repository.ShiftsRepository;
import com.example.finalproj.service.ShiftsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class ShiftsServiceImpl implements ShiftsService {

    private final ShiftsRepository shiftsRepository;
    private final ShiftsMapper shiftsMapper;

    @Override
    public Shifts createShift(ShiftsDTO shiftDTO) throws Exception {
        Shifts shift = shiftsMapper.toEntity(shiftDTO);
        return shiftsRepository.save(shift);
    }

    @Override
    public Shifts updateShift(Long shiftID, ShiftsDTO shiftDTO) throws Exception {
        Shifts shift = shiftsRepository.findById(shiftID)
                .orElseThrow(() -> new RuntimeException("Shift not found with id: " + shiftID));

        shift.setStartTime(shiftsMapper.toEntity(shiftDTO).getStartTime());
        shift.setEndTime(shiftsMapper.toEntity(shiftDTO).getEndTime());
        return shiftsRepository.save(shift);
    }

    @Override
    public void deleteShift(Long shiftID) throws Exception {
        if (!shiftsRepository.existsById(shiftID)) {
            throw new RuntimeException("Shift not found with id: " + shiftID);
        }
        shiftsRepository.deleteById(shiftID);
    }

    @Override
    public Shifts getShiftById(Long shiftID) throws Exception {
        return shiftsRepository.findById(shiftID)
                .orElseThrow(() -> new RuntimeException("Shift not found with id: " + shiftID));
    }

    @Override
    public List<Shifts> getAllShifts() throws Exception {
        return shiftsRepository.findAll();
    }
}
