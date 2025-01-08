package com.Doctors.Controller;

import com.Doctors.Payload.AppointmentDto;
import com.Doctors.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/api/d1/appointments")
    public class AppointmentController {
       
        private AppointmentService appointmentService;

        public AppointmentController(AppointmentService appointmentService) {
            this.appointmentService = appointmentService;
        }

        @GetMapping("/getAllapp")
        public List<AppointmentDto> getAllAppointments() {
            return appointmentService.getAllAppointments();
        }

        @GetMapping("/app/{appId}")
        public ResponseEntity<AppointmentDto> getAppointmentById(@PathVariable Long appId) {
            AppointmentDto appointment = appointmentService.getAppointmentByAppId(appId);
            return appointment != null ? ResponseEntity.ok(appointment) : ResponseEntity.notFound().build();
        }

        @PostMapping("/createApp")
        public ResponseEntity<AppointmentDto> createAppointment(@RequestBody AppointmentDto appointmentDto) {
            AppointmentDto createdAppointment = appointmentService.createAppointment(appointmentDto);
            return ResponseEntity.ok(createdAppointment);
        }

        @PutMapping("/updateApp/{id}")
        public ResponseEntity<AppointmentDto> updateAppointment(@PathVariable Long appId, @RequestBody AppointmentDto appointmentDto) {
            AppointmentDto updatedAppointment = appointmentService.updateAppointment(appId, appointmentDto);
            return updatedAppointment != null ? ResponseEntity.ok(updatedAppointment) : ResponseEntity.notFound().build();
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<Void> deleteAppointment(@PathVariable Long appId) {
            appointmentService.deleteAppointment(appId);
            return ResponseEntity.noContent().build();
        }
    }


