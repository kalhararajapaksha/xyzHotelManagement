package com.nsbm.xyzhotel.service.impl;

import com.nsbm.xyzhotel.repository.ReservationRoomRepository;
import com.nsbm.xyzhotel.service.ReservationHallService;
import com.nsbm.xyzhotel.service.ReservationRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyzhotel.model.Reservation;
import xyzhotel.model.ReservationHall;
import xyzhotel.model.ReservationRoom;
import xyzhotel.model.Usertype;
import xyzhotel.model.exception.InvalidReservationException;
import xyzhotel.model.exception.InvalidRoomException;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationRoomServiceImpl implements ReservationRoomService {

    @Autowired
    private ReservationRoomRepository reservationRoomRepository;

    @Override
    public ReservationRoom Save(ReservationRoom reservationRoom) throws InvalidReservationException, InvalidRoomException {

        if (reservationRoom.getReservation().getReservationId() < 0) {
            throw new InvalidReservationException("Invalid Reservation");
        }

        if (reservationRoom.getRoomId() < 0) {
            throw new InvalidRoomException("Invalid Room No");
        }

        reservationRoom = reservationRoomRepository.save(reservationRoom);
        return reservationRoom;
    }

    @Override
    public ReservationRoom Update(ReservationRoom reservationRoom) {

        if (reservationRoom.getRoomId() == 0 && reservationRoom.getReservation() == null) {
            throw new InvalidRoomException("room type or resrvation id is empty");
        }

        reservationRoom = reservationRoomRepository.save(reservationRoom);

        return null;
    }

    @Override
    public ReservationRoom findByID(int id) {
        Optional<ReservationRoom> optionalReservationRoom = reservationRoomRepository.findById(id);
        if (optionalReservationRoom.isPresent()) {
            return optionalReservationRoom.get();
        } else {

        }
        return null;
    }

    @Override
    public List<ReservationRoom> findAll() {
        return reservationRoomRepository.findAll();
    }

    @Override
    public List<ReservationRoom> notReservationRooms(List<ReservationRoom> reservationRooms) {

        return null;
    }
}
