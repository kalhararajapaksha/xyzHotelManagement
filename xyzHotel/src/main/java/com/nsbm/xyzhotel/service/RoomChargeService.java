package com.nsbm.xyzhotel.service;

import xyzhotel.model.RoomCharge;

import java.util.List;

public interface RoomChargeService {

    public RoomCharge findByRoomTypeAndRoomCapacity(int roomTypeId,int roomCapacityId);

    public List<RoomCharge> findAll();
}
