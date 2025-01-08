package com.Doctors.Service;

import com.Doctors.Entity.Prescription;
import com.Doctors.Payload.PrescriptionDto;
import com.Doctors.Repository.PrescriptionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service

public class PrescriptionServiceImpl implements PrescriptionService{
    private ModelMapper modelMapper;
    private PrescriptionRepository prescriptionRepository;

    public PrescriptionServiceImpl(ModelMapper modelMapper, PrescriptionRepository prescriptionRepository) {
        this.modelMapper = modelMapper;
        this.prescriptionRepository = prescriptionRepository;
    }

    @Override
    public PrescriptionDto addPrescription(Long doctorId,PrescriptionDto prescriptionDto) {
        Prescription prescription = modelMapper.map(prescriptionDto, Prescription.class);
        Prescription save = prescriptionRepository.save(prescription);
        return modelMapper.map(save, PrescriptionDto.class);
    }

    @Override
    public PrescriptionDto updatePrescription(Long doctorId, PrescriptionDto prescriptionDto) {
        Prescription prescription;
        prescription = prescriptionRepository.findByDoctor_DoctorId(doctorId);
        if(prescription == null){
            System.out.println("wrong Input");
        }  prescription = modelMapper.map(prescriptionDto, Prescription.class);
        Prescription saved = prescriptionRepository.save(prescription);
        return modelMapper.map(saved, PrescriptionDto.class);
    }

    @Override
    public PrescriptionDto getPrescription(Long patientId) {
        Prescription byPatientPatientId = prescriptionRepository.findByPatient_PatientId(patientId);
        return modelMapper.map(byPatientPatientId, PrescriptionDto.class);
    }

}
