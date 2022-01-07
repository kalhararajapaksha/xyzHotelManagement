package com.nsbm.xyzhotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyzhotel.model.RoomCharge;

public interface RoomChargeRepository extends JpaRepository<RoomCharge,Integer> {

    public RoomCharge findByRoomTypeIDAndRoomCapacityID(int roomTypeId, int roomCapacityId);
}
