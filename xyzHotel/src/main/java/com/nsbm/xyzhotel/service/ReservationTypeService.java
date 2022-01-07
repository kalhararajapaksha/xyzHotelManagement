package com.nsbm.xyzhotel.service;

import xyzhotel.model.ReservationType;

import java.util.List;

public interface ReservationTypeService {

    public String Save(ReservationType reservationType);

    public String Update(ReservationType reservationType);

    public  ReservationType FindById(int id);

    public List<ReservationType> FindAll();
}
