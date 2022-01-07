package com.nsbm.xyzhotel.service.impl;

import com.nsbm.xyzhotel.repository.RoomRepository;
import com.nsbm.xyzhotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyzhotel.model.Room;
import xyzhotel.model.exception.InvalidRoomException;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Room Save(Room room) throws InvalidRoomException{

        if(room.getRoomTypeId() == 0){
            throw new InvalidRoomException("Invalid room exception");
        }
        room = roomRepository.save(room);
        return null;
    }

    @Override
    public Room update(Room room) {

        if(room.getRoomNo() == 0){
            throw new InvalidRoomException("Invalid room No");
        }

        return null;
    }

    @Override
    public Room FindById(int id) {
        Optional<Room> optionalRoom=roomRepository.findById(id);
        if(optionalRoom.isPresent()){
            return optionalRoom.get();
        }
        return null;
    }

    @Override
    public List<Room> FindAll() {
        return roomRepository.findAll();
    }

    @Override
    public List<Room> findByRoomTypeAndCapacity(int typeId, int capacityId) {
        return roomRepository.findByRoomTypeIdAndCapacityID(typeId,capacityId);
    }
}
