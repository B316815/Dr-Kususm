package com.Doctors.Service;

import com.Doctors.Payload.AppointmentDto;

import java.util.List;

public interface AppointmentService {
    List<AppointmentDto> getAllAppointments();

    AppointmentDto getAppointmentByAppId(Long appId);

    AppointmentDto createAppointment(AppointmentDto appointmentDto);

    AppointmentDto updateAppointment(Long appId, AppointmentDto appointmentDto);

    void deleteAppointment(Long id);
}
