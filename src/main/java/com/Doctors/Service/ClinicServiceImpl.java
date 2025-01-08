package com.Doctors.Service;

import com.Doctors.Entity.Clinic;
import com.Doctors.Payload.ClinicDto;
import com.Doctors.Repository.ClinicRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ClinicServiceImpl implements ClinicService{
    private ModelMapper modelMapper;
    private ClinicRepository clinicRepository;

    public ClinicServiceImpl(ModelMapper modelMapper, ClinicRepository clinicRepository) {
        this.modelMapper = modelMapper;
        this.clinicRepository = clinicRepository;
    }

    @Override
    public ClinicDto addClinic(ClinicDto clinicDto) {
        Clinic clinic = modelMapper.map(clinicDto, Clinic.class);
        Clinic save = clinicRepository.save(clinic);
        return modelMapper.map(save, ClinicDto.class);
    }

    @Override
    public ClinicDto updateClinic(Long clinicId, ClinicDto clinicDto) {
        Clinic clinic;
        clinic = clinicRepository.findByClinicId(clinicId);
        if(clinic == null){
            System.out.println("Clinic Not Found");
        }
        clinic = modelMapper.map(clinicDto, Clinic.class);
        Clinic saved = clinicRepository.save(clinic);
        return modelMapper.map(saved, ClinicDto.class);
    }

    @Override
    public List<ClinicDto> getAllClinic() {
        List<Clinic> all = clinicRepository.findAll();
        return all.stream().map(clinic -> modelMapper.map(clinic, ClinicDto.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteClinic(Long clinicId) {
        clinicRepository.deleteById(clinicId);
    }

}
