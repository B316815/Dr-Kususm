package com.Doctors.Repository;

import com.Doctors.Entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {

    Report findByReportId(Long reportId);
    List<Report>findAll();
}