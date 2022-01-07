package com.nsbm.xyzhotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyzhotel.model.PaymentLine;

public interface PaymentLineRepository extends JpaRepository<PaymentLine,Integer>{
}
