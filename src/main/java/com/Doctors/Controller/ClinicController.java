package com.Doctors.Controller;

import com.Doctors.Payload.ClinicDto;
import com.Doctors.Service.ClinicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/d1/clinic")
public class ClinicController {
    private ClinicService clinicService;

    public ClinicController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @PostMapping("/addClinic")
    public ResponseEntity<?>addClinic(@RequestBody ClinicDto clinicDto){
        ClinicDto addClinic = clinicService.addClinic(clinicDto);
        return new ResponseEntity<>(addClinic, HttpStatus.CREATED);
    }

    @PutMapping("/updateClinic/{clinicId}")
    public ResponseEntity updateClinic(@PathVariable Long clinicId ,@RequestBody ClinicDto clinicDto){
        ClinicDto updated = clinicService.updateClinic(clinicId, clinicDto);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @GetMapping("/allClinic")
    public ResponseEntity <List<ClinicDto>> getAllClinic(){
        List<ClinicDto> allClinic = clinicService.getAllClinic();
        return ResponseEntity.ok(allClinic);
    }

    @DeleteMapping("/deleteClinic/{clinicId}")
    public ResponseEntity deleteClinic(@PathVariable Long clinicId){
        clinicService.deleteClinic(clinicId);
        return ResponseEntity.noContent().build();
    }
}
