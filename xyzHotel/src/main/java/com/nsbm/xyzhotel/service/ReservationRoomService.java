package com.nsbm.xyzhotel.service;

import xyzhotel.model.Reservation;
import xyzhotel.model.ReservationHall;
import xyzhotel.model.ReservationRoom;
import xyzhotel.model.Usertype;

import java.util.List;

public interface ReservationRoomService {

    public ReservationRoom Save(ReservationRoom reservationRoom);

    public ReservationRoom Update(ReservationRoom reservationRoom);

    public ReservationRoom findByID(int id);

    public List<ReservationRoom> findAll();

    public List<ReservationRoom> notReservationRooms(List<ReservationRoom> reservationRooms);



}
