package com.Doctors.Controller;
import com.Doctors.Payload.BillingDto;
import com.Doctors.Service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/api/d1/billing")
    public class BillingController {

        @Autowired
        private BillingService billingService;

        @PostMapping("/addBill")
        public ResponseEntity<BillingDto> createBilling(@RequestBody BillingDto billingDto) {
            BillingDto createdBilling = billingService.createBilling(billingDto);
            return new ResponseEntity<>(createdBilling, HttpStatus.CREATED);
        }

//        @GetMapping("/billing/{id}")
//        public ResponseEntity<BillingDto> getBillingById(@PathVariable Long billingId) {
//            BillingDto billingDto = billingService.getBillingById(billingId);
//            if (billingDto != null) {
//                return new ResponseEntity<>(billingDto, HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            }
//        }

//        @PutMapping("/updateBilling/{id}")
//        public ResponseEntity<BillingDto> updateBilling(@PathVariable Long billingId, @RequestBody BillingDto billingDto) {
//            BillingDto updatedBilling = billingService.updateBilling(billingId, billingDto);
//            if (updatedBilling != null) {
//                return new ResponseEntity<>(updatedBilling, HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            }
//        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<Void> deleteBilling(@PathVariable Long billingId) {
            billingService.deleteBilling(billingId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

