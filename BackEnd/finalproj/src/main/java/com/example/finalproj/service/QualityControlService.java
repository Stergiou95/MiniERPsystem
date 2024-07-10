package com.example.finalproj.service;

import com.example.finalproj.dto.QualityControlDTO;
import com.example.finalproj.model.QualityControl;

import java.util.List;

public interface QualityControlService {
    QualityControl createQualityControl(QualityControlDTO qualityControlDTO) throws Exception;
    QualityControl updateQualityControl(Long repID, QualityControlDTO qualityControlDTO) throws Exception;
    void deleteQualityControl(Long repID) throws Exception;
    QualityControl getQualityControlById(Long repID) throws Exception;
    List<QualityControl> getAllQualityControls() throws Exception;
}
