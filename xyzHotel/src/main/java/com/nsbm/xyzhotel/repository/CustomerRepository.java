package com.nsbm.xyzhotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyzhotel.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{
}
