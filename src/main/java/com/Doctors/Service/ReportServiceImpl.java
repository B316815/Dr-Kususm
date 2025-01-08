package com.Doctors.Service;

import com.Doctors.Entity.Report;
import com.Doctors.Payload.ReportDto;
import com.Doctors.Repository.ReportRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class ReportServiceImpl implements ReportService{
    private ModelMapper modelMapper;
    private ReportRepository reportRepository;

    public ReportServiceImpl(ModelMapper modelMapper, ReportRepository reportRepository) {
        this.modelMapper = modelMapper;
        this.reportRepository = reportRepository;
    }

    @Override
    public ReportDto addReport(ReportDto reportDto) {
        Report report = modelMapper.map(reportDto, Report.class);
        Report saveReport = reportRepository.save(report);
        return modelMapper.map(saveReport,ReportDto.class);
    }

    @Override
    public ReportDto updateReport(Long reportId, ReportDto reportDto) {
        Report byReportId ;
        byReportId = reportRepository.findByReportId(reportId);
        if(byReportId == null){
            System.out.println("Report Not Present");
        }
        byReportId = modelMapper.map(reportDto,Report.class);
        Report saveReprt = reportRepository.save(byReportId);
        return modelMapper.map(saveReprt,ReportDto.class);
    }

    @Override
    public List<ReportDto> GetAllReport() {
        List<Report> all = reportRepository.findAll();
        return all.stream().map(report -> modelMapper.map(report,ReportDto.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteReport(Long reportId) {
        if(reportRepository.existsById(reportId)) {
            reportRepository.deleteById(reportId);
        } else{
            System.out.println("Report Not Present");
        }
    }

}
