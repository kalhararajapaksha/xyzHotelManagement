package com.nsbm.xyzhotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyzhotel.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Integer>{
}
