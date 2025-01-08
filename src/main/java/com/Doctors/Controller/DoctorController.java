package com.Doctors.Controller;

import com.Doctors.Payload.DoctorDto;
import com.Doctors.Service.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/d1/doctor")

public class DoctorController {
    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping("/addDoctor")
    public ResponseEntity<?>addDoctor(@RequestBody DoctorDto doctorDto){
        DoctorDto doctorDto1 = doctorService.addDoctor(doctorDto);
        return new ResponseEntity<>(doctorDto1, HttpStatus.CREATED);
    }
    @PutMapping("/updateDoctor/{doctorId}")
    public ResponseEntity updateDoctor(@PathVariable Long doctorId,@RequestBody DoctorDto doctorDto){
        DoctorDto doctorDto1 = doctorService.updateDoctor(doctorId, doctorDto);
        return new ResponseEntity<>(doctorDto1,HttpStatus.OK);
    }
    @GetMapping("/allDoctor")
    public ResponseEntity <List<DoctorDto>>getAllDoctor(){
        List<DoctorDto> allDoctor = doctorService.getAllDoctor();
        return ResponseEntity.ok(allDoctor);
    }

    @DeleteMapping("/deleteDoctor/{doctorId}")
    public ResponseEntity deleteDoctor(@PathVariable Long doctorId){
        doctorService.deleteDoctor(doctorId);
        return ResponseEntity.noContent().build();
    }
}
