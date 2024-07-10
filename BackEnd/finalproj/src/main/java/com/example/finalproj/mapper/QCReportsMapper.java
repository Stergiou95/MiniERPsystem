package com.example.finalproj.mapper;

import com.example.finalproj.dto.QCReportsDTO;
import com.example.finalproj.model.QCReports;

public class QCReportsMapper {

    public static QCReportsDTO toDTO(QCReports qcReports) {
        return new QCReportsDTO(
                qcReports.getResultID(),
                qcReports.getResult()
        );
    }

    public static QCReports toEntity(QCReportsDTO dto) {
        QCReports qcReports = new QCReports();
        qcReports.setResultID(dto.getResultID());
        qcReports.setResult(dto.getResult());
        return qcReports;
    }
}
