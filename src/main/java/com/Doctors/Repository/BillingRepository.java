package com.Doctors.Repository;

import com.Doctors.Entity.Billing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BillingRepository extends JpaRepository<Billing, Long> {


//    Optional<Billing> findByBillingId(Long billingId);
Billing findByBillingId(Long billingId);

  public void deleteById (Long billingId);
}