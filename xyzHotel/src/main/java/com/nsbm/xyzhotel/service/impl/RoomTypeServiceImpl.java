package com.nsbm.xyzhotel.service.impl;

import com.nsbm.xyzhotel.repository.RoomTypeRepository;
import com.nsbm.xyzhotel.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyzhotel.model.RoomType;

import java.util.List;
import java.util.Optional;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {
    @Autowired
    RoomTypeRepository roomTypeRepository;

    @Override
    public String Save(RoomType roomType) {
        return null;
    }

    @Override
    public String Update(RoomType roomType) {
        return null;
    }

    @Override
    public RoomType findById(int id) {
        Optional<RoomType> optionalRoomType= roomTypeRepository.findById(id);
         if(optionalRoomType.isPresent()){
             return optionalRoomType.get();
         }
        return null;
    }

    @Override
    public List<RoomType> findAll() {
        return roomTypeRepository.findAll();
    }
}
