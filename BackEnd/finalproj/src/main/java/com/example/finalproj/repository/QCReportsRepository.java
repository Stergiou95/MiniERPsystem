package com.example.finalproj.repository;

import com.example.finalproj.model.QCReports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QCReportsRepository extends JpaRepository<QCReports, Long> {
    static QCReports findByID(Long resultID) {
        return new QCReports();
    }

}
