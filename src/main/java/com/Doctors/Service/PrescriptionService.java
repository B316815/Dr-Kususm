package com.Doctors.Service;

import com.Doctors.Payload.PrescriptionDto;

import java.util.List;

public interface PrescriptionService {

    public PrescriptionDto addPrescription(Long doctorId,PrescriptionDto prescriptionDto);
    public PrescriptionDto updatePrescription(Long doctorId,PrescriptionDto prescriptionDto);
    public PrescriptionDto getPrescription (Long patientId);
}
