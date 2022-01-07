package com.nsbm.xyzhotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyzhotel.model.RoomCapacity;

public interface RoomCapacityRepository extends JpaRepository<RoomCapacity,Integer> {
}
