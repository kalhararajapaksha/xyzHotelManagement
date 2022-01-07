package com.nsbm.xyzhotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyzhotel.model.ReservationType;

public interface ReservationTypeRepository extends JpaRepository<ReservationType,Integer>{
}
