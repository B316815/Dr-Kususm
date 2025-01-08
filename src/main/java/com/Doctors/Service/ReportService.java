package com.Doctors.Service;

import com.Doctors.Payload.ReportDto;

import java.util.List;

public interface ReportService {
    public ReportDto addReport(ReportDto reportDto);

    public ReportDto updateReport(Long reportId,ReportDto reportDto);

    List<ReportDto>GetAllReport();
    public void deleteReport(Long reportId);
}
