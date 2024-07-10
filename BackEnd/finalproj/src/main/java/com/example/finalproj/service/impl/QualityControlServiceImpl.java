package com.example.finalproj.service.impl;

import com.example.finalproj.dto.QualityControlDTO;
import com.example.finalproj.mapper.QualityControlMapper;
import com.example.finalproj.model.QualityControl;
import com.example.finalproj.repository.QualityControlRepository;
import com.example.finalproj.service.QualityControlService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class QualityControlServiceImpl implements QualityControlService {

    private final QualityControlRepository qualityControlRepository;
    private final QualityControlMapper qualityControlMapper;

    @Override
    public QualityControl createQualityControl(QualityControlDTO qualityControlDTO) throws Exception {
        QualityControl qualityControl = qualityControlMapper.toEntity(qualityControlDTO);
        return qualityControlRepository.save(qualityControl);
    }

    @Override
    public QualityControl updateQualityControl(Long repID, QualityControlDTO qualityControlDTO) throws Exception {
        QualityControl qualityControl = qualityControlRepository.findById(repID)
                .orElseThrow(() -> new RuntimeException("Quality control not found with id: " + repID));

        qualityControl.setReportDate(qualityControlDTO.getReportDate());
        // Υποθέτουμε ότι υπάρχουν περισσότερα πεδία για ενημέρωση, προσθέστε τα εδώ
        return qualityControlRepository.save(qualityControl);
    }

    @Override
    public void deleteQualityControl(Long repID) throws Exception {
        if (!qualityControlRepository.existsById(repID)) {
            throw new RuntimeException("Quality control not found with id: " + repID);
        }
        qualityControlRepository.deleteById(repID);
    }

    @Override
    public QualityControl getQualityControlById(Long repID) throws Exception {
        return qualityControlRepository.findById(repID)
                .orElseThrow(() -> new RuntimeException("Quality control not found with id: " + repID));
    }

    @Override
    public List<QualityControl> getAllQualityControls() throws Exception {
        return qualityControlRepository.findAll();
    }
}
