package com.Doctors.Service;

import com.Doctors.Entity.Doctor;
import com.Doctors.Payload.DoctorDto;
import com.Doctors.Repository.DoctorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService{
    private ModelMapper modelMapper;
    private DoctorRepository doctorRepository;

    public DoctorServiceImpl(ModelMapper modelMapper, DoctorRepository doctorRepository) {
        this.modelMapper = modelMapper;
        this.doctorRepository = doctorRepository;
    }

    @Override
    public DoctorDto addDoctor(DoctorDto doctorDto) {
        Doctor doctor = modelMapper.map(doctorDto, Doctor.class);
        Doctor saveDoctor = doctorRepository.save(doctor);
        return modelMapper.map(saveDoctor, DoctorDto.class);
    }

    @Override
    public DoctorDto updateDoctor(Long doctorId, DoctorDto doctorDto) {
        Doctor doctor;
        doctor= doctorRepository.findByDoctorId(doctorId);
        if(doctor == null) {
            System.out.println("No Doctor Found");
        }
            doctor = modelMapper.map(doctorDto, Doctor.class);
            Doctor save = doctorRepository.save(doctor);
        return modelMapper.map(save, DoctorDto.class);
    }

    @Override
    public List<DoctorDto> getAllDoctor() {
        List<Doctor> all = doctorRepository.findAll();
        return all.stream().map(doctor -> modelMapper.map(doctor, DoctorDto.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteDoctor(Long doctorId) {
        if(doctorRepository.existsById(doctorId)){
            doctorRepository.deleteById(doctorId);
        }else{
            System.out.println("Doctor Not Exists");
        }
    }


}
