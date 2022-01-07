package com.nsbm.xyzhotel.service.impl;

import com.nsbm.xyzhotel.repository.RoomCapacityRepository;
import com.nsbm.xyzhotel.service.RoomCapacityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyzhotel.model.RoomCapacity;
import xyzhotel.model.Usertype;

import java.util.List;
import java.util.Optional;

@Service
public class RoomCapacityServiceImpl implements RoomCapacityService {

    @Autowired
    private RoomCapacityRepository roomCapacityRepository;

    @Override
    public RoomCapacity findById(int id) {
        Optional<RoomCapacity> optionalRoomCapacity = roomCapacityRepository.findById(id);
        if(optionalRoomCapacity.isPresent()) {
            return optionalRoomCapacity.get();
        }else{

        }
        return null;


    }

    @Override
    public List<RoomCapacity> findAll() {
        return roomCapacityRepository.findAll();
    }
}
