package com.Doctors.Service;

import com.Doctors.Entity.Appointment;
import com.Doctors.Repository.AppointmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.Doctors.Entity.Billing;
import com.Doctors.Repository.BillingRepository;
import com.Doctors.Payload.BillingDto;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Optional;

@Service

public class BillingServiceImpl implements BillingService {

    private BillingRepository billingRepository;
    private ModelMapper modelMapper;
    private AppointmentRepository appointmentRepository;

    public BillingServiceImpl(BillingRepository billingRepository, ModelMapper modelMapper, AppointmentRepository appointmentRepository) {
        this.billingRepository = billingRepository;
        this.modelMapper = modelMapper;
        this.appointmentRepository = appointmentRepository;
    }

    public BillingDto createBilling(BillingDto billingDto) {

        // Fetch or save the Appointment first before creating Billing
        Appointment appointment = billingDto.getAppointment();
        if (appointment != null && appointment.getAppId() != null) {
            appointment = appointmentRepository.findById(appointment.getAppId())
                    .orElseThrow(() -> new RuntimeException("Appointment not found"));
        } else {
            throw new RuntimeException("Invalid appointment reference");
        }

        // Map the DTO to Billing entity
        Billing billing = modelMapper.map(billingDto, Billing.class);
        billing.setAppointment(appointment);  // Ensure the saved or existing appointment is used
        // Save the Billing
        Billing savedBilling = billingRepository.save(billing);
        // Return the saved Billing mapped to DTO
        return modelMapper.map(savedBilling, BillingDto.class);
    }


    public BillingDto getBillingById(Long billingId) {
        Billing byBillingId = billingRepository.findByBillingId(billingId);
        return modelMapper.map(byBillingId, BillingDto.class);

    }

    public BillingDto updateBilling(Long billingId, BillingDto billingDto) {
        Billing billing;
        billing = billingRepository.findByBillingId(billingId);
        if (billing == null) {
            System.out.println("No Bill Found");
        }
            billing = modelMapper.map(billingDto, Billing.class);
//                billing.setAppointment(appointment);  // Ensure the saved or existing appointment is used

            // Save the Billing
            Billing savedBilling = billingRepository.save(billing);

            // Return the saved Billing mapped to DTO
            return modelMapper.map(savedBilling, BillingDto.class);
        }

    @Override
    public void deleteBilling(Long billingId) {
        billingRepository.deleteById(billingId);
    }
}


