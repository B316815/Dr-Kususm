package com.Doctors.Controller;

import com.Doctors.Payload.PrescriptionDto;
import com.Doctors.Service.PrescriptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/d1/prescription")
public class PrescriptionController {
    private PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }
    @PostMapping("/addPres/{doctorId}")
    public ResponseEntity<?>addPrescription(@PathVariable Long doctorId, @RequestBody PrescriptionDto prescriptionDto){
        PrescriptionDto prescriptionDto1 = prescriptionService.addPrescription(doctorId ,prescriptionDto);
        return new ResponseEntity<>(prescriptionDto1, HttpStatus.CREATED);
    }

//    @PutMapping("/updatePres/{doctorId)")
}
