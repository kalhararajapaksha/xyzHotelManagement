package com.nsbm.xyzhotel.service.impl;

import com.nsbm.xyzhotel.repository.RoomChargeRepository;
import com.nsbm.xyzhotel.service.RoomChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyzhotel.model.RoomCharge;
import xyzhotel.model.Usertype;

import java.util.List;
import java.util.Optional;

@Service
public class RoomChargeServiceImpl implements RoomChargeService {

    @Autowired
    private RoomChargeRepository roomChargeRepository;

    @Override
    public RoomCharge findByRoomTypeAndRoomCapacity(int roomTypeId, int roomCapacityId) {

        RoomCharge roomCharge = roomChargeRepository.findByRoomTypeIDAndRoomCapacityID(roomTypeId,roomCapacityId);
   return  roomCharge;

    }

    @Override
    public List<RoomCharge> findAll() {
        return roomChargeRepository.findAll();
    }
}
