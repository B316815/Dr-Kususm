package com.Doctors.Service;

import com.Doctors.Payload.BillingDto;

public interface BillingService {

    BillingDto createBilling(BillingDto billingDto);
    BillingDto getBillingById(Long billingId);

    BillingDto updateBilling(Long billingId, BillingDto billingDto);

   public void deleteBilling(Long billingId);


}
