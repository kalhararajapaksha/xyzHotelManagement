package com.nsbm.xyzhotel.service;

import xyzhotel.model.RoomCapacity;

import java.util.List;

public interface RoomCapacityService {

    public RoomCapacity findById(int id);

    public List<RoomCapacity> findAll();
}
