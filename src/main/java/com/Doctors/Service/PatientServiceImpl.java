package com.Doctors.Service;

import com.Doctors.Entity.Patient;
import com.Doctors.Payload.PatientDto;
import com.Doctors.Repository.PatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {
    private ModelMapper modelMapper;
    private PatientRepository patientRepository;

    public PatientServiceImpl(ModelMapper modelMapper, PatientRepository patientRepository) {
        this.modelMapper = modelMapper;
        this.patientRepository = patientRepository;
    }
    @Override
    public PatientDto addPatient(PatientDto patientDto) {
        Patient patient = modelMapper.map(patientDto, Patient.class);
        Patient save = patientRepository.save(patient);
        return modelMapper.map(save,PatientDto.class);
    }

    @Override
    public PatientDto updatePatient(Long patientId, PatientDto patientDto) {
        Patient patient ;
              patient =  patientRepository.findByPatientId(patientId);
//                      .orElseThrow(() -> new RuntimeException("Patient Id Not Found"));
              patient = modelMapper.map(patientDto,Patient.class);
        Patient updatePatient = patientRepository.save(patient);
        return modelMapper.map(updatePatient,PatientDto.class);
    }
    @Override
    public PatientDto patientUpdate(String mobile, PatientDto patientDto) {

        Patient ayn ;
        ayn =  patientRepository.findByMobile(mobile);
        if (ayn == null) {
            throw new RuntimeException("Patient with mobile number " + mobile + " not found");
        }
        ayn = modelMapper.map(patientDto,Patient.class);
        Patient update = patientRepository.save(ayn);
        return modelMapper.map(update,PatientDto.class);
    }

    @Override
    public PatientDto GetPatientDetails(String mobile) {
        Patient mobile1 = patientRepository.findByMobile(mobile);
        return modelMapper.map(mobile1,PatientDto.class);
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public List<PatientDto> AllPatients() {
        List<Patient> all = patientRepository.findAll();
       return all.stream().map(patient -> modelMapper.map(patient,PatientDto.class)).collect(Collectors.toList());

    }


}
