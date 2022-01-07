package com.nsbm.xyzhotel.service;

import xyzhotel.model.RoomType;

import java.util.List;

public interface RoomTypeService {

    public String Save(RoomType roomType);

    public String Update(RoomType roomType);

    public RoomType findById(int id);

    public List<RoomType> findAll();
}
