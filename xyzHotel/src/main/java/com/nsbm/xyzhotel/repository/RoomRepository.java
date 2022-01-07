package com.nsbm.xyzhotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyzhotel.model.Room;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Integer>{

    public List<Room> findByRoomTypeIdAndCapacityID(int roomTypeId,int roomCapacityID);
}
