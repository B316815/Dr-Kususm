package com.Doctors.Service;
import com.Doctors.Entity.Appointment;
import com.Doctors.Payload.AppointmentDto;
import com.Doctors.Repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentRepository appointmentRepository;
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<AppointmentDto> getAllAppointments() {
            return appointmentRepository.findAll().stream()
                    .map(this::mapToDto)
                    .collect(Collectors.toList());
        }

    @Override
    public AppointmentDto getAppointmentByAppId(Long appId) {
            Optional<Appointment> appointment = appointmentRepository.findByAppId(appId);
            return appointment.map(this::mapToDto).orElse(null);
        }

    @Override
    public AppointmentDto createAppointment(AppointmentDto appointmentDto) {
            Appointment appointment = mapToEntity(appointmentDto);
            appointment = appointmentRepository.save(appointment);
            return mapToDto(appointment);
        }
    @Override
    public AppointmentDto updateAppointment(Long appId, AppointmentDto appointmentDto) {
            Optional<Appointment> existingAppointment = appointmentRepository.findById(appId);

            if (existingAppointment.isPresent()) {
                Appointment appointment = existingAppointment.get();
                appointment.setDate(appointmentDto.getDate());
                appointment.setDoctor(appointmentDto.getDoctor());
                appointment.setPatient(appointmentDto.getPatient());
                appointment = appointmentRepository.save(appointment);
                return mapToDto(appointment);
            }
            return null;
        }
    @Override
    public void deleteAppointment(Long appId) {
        appointmentRepository.deleteByAppId(appId);
        }

        private AppointmentDto mapToDto(Appointment appointment) {
            AppointmentDto dto = new AppointmentDto();
            dto.setAppId(appointment.getAppId());
            dto.setDate(appointment.getDate());
            dto.setDoctor(appointment.getDoctor());
            dto.setPatient(appointment.getPatient());
            return dto;
        }

        private Appointment mapToEntity(AppointmentDto appointmentDto) {
            Appointment appointment = new Appointment();
            appointment.setAppId(appointmentDto.getAppId());
            appointment.setDate(appointmentDto.getDate());
            appointment.setDoctor(appointmentDto.getDoctor());
            appointment.setPatient(appointmentDto.getPatient());
            return appointment;
        }
}

