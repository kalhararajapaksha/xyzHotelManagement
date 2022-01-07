package com.nsbm.xyzhotel.service;

import xyzhotel.model.ReservationHall;
import xyzhotel.model.User;

import java.util.List;

public interface ReservationHallService {

    public ReservationHall Save(ReservationHall reservationHall);

    public String Update(ReservationHall reservationHall);

    public ReservationHall FindById(int id);

    public List<ReservationHall> findAll();

}
