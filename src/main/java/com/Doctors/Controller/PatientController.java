package com.Doctors.Controller;

import com.Doctors.Payload.PatientDto;
import com.Doctors.Service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/d1/Doctor")

public class PatientController {
    private PatientService patientService;
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/addPatient")
    public ResponseEntity<?> addPatient(@RequestBody PatientDto patientDto){
        System.out.println(patientDto.getName());
        PatientDto patientDto1 = patientService.addPatient(patientDto);
        return new ResponseEntity<>(patientDto1, HttpStatus.CREATED);
    }
    @PutMapping("/updatePatient/{patientId}")
    public ResponseEntity updatePatient(@PathVariable Long patientId, @RequestBody PatientDto patientDto){
        System.out.println(patientDto.getName());
        PatientDto updatedPatient = patientService.updatePatient(patientId, patientDto);
        return new ResponseEntity<>(updatedPatient,HttpStatus.OK);
    }
    @PutMapping("/patientUpdate/{mobile}")
    public ResponseEntity updatePatient(@PathVariable String mobile, @RequestBody PatientDto patientDto){
        System.out.println(patientDto.getName());
        PatientDto updated = patientService.patientUpdate(mobile, patientDto);
        return new ResponseEntity<>(updated,HttpStatus.OK);
    }

    @DeleteMapping("/deletePatient/{patientId}")
        public ResponseEntity deletePatient(@PathVariable Long patientId){
        patientService.deletePatient(patientId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/AllPatient")
    public ResponseEntity <List<PatientDto>>getAllPatient(){
        List<PatientDto> patientDtos = patientService.AllPatients();
        return ResponseEntity.ok(patientDtos);
    }
    @GetMapping("/patient/{mobile}")
    public ResponseEntity GetPatientDetails(@PathVariable String mobile){
        PatientDto details = patientService.GetPatientDetails(mobile);
        return ResponseEntity.ok(details);
    }
}
