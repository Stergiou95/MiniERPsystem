package com.example.finalproj.mapper;

import com.example.finalproj.dto.QualityControlDTO;
import com.example.finalproj.model.QCReports;
import com.example.finalproj.model.QualityControl;
import com.example.finalproj.repository.QCReportsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QualityControlMapper {

    @Autowired
    private QCReportsRepository qcReportsRepository;

    public QualityControlDTO toDTO(QualityControl qualityControl) {
        return new QualityControlDTO(
                qualityControl.getRepID(),
                qualityControl.getResult().getResultID(),
                qualityControl.getReportDate()
        );
    }

    public QualityControl toEntity(QualityControlDTO dto) {
        QualityControl qualityControl = new QualityControl();
        qualityControl.setRepID(dto.getRepID());
        qualityControl.setReportDate(dto.getReportDate());
        qualityControl.setResult(
                QCReportsRepository.findByID(dto.getResultID()).orElse(null)
        );
        return qualityControl;
    }
}
