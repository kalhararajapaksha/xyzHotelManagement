package com.nsbm.xyzhotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyzhotel.model.PaymentMethod;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod,Integer>{
}
