package com.nsbm.xyzhotel.service;

import xyzhotel.model.Room;

import java.util.List;

public interface RoomService {

    public Room Save(Room room);

    public Room update(Room room);

    public Room FindById(int id);

    public List<Room> FindAll();

    public List<Room> findByRoomTypeAndCapacity(int typeId, int capacityId);
}
