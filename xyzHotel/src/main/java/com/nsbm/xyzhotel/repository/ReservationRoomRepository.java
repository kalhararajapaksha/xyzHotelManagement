package com.nsbm.xyzhotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyzhotel.model.ReservationHall;
import xyzhotel.model.ReservationRoom;

import java.util.List;

public interface ReservationRoomRepository extends JpaRepository<ReservationRoom,Integer> {


}
