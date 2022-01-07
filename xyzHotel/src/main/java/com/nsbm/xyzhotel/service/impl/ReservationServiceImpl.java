package com.nsbm.xyzhotel.service.impl;

import com.nsbm.xyzhotel.repository.ReservationRepository;
import com.nsbm.xyzhotel.service.ReservationHallService;
import com.nsbm.xyzhotel.service.ReservationRoomService;
import com.nsbm.xyzhotel.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyzhotel.model.Reservation;
import xyzhotel.model.ReservationHall;
import xyzhotel.model.ReservationRoom;
import xyzhotel.model.exception.InvalidCustomerException;
import xyzhotel.model.exception.InvalidReservationException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private ReservationRoomService reservationRoomService;

    private ReservationHallService reservationHallService;

    @Override
    public Reservation Save(Reservation reservation) throws InvalidCustomerException, InvalidReservationException {

        if (reservation.getReservationId() != 0) {
            throw new InvalidCustomerException("customer not found");
        }
        if (reservation.getCheckingDate() == null) {
            throw new InvalidReservationException("Checking date can't be null");
        }
        if (reservation.getCheckoutDate() == null) {
            throw new InvalidReservationException("CheckOut date can't be null");
        }
        if (reservation.getNoOfGuest() <= 0) {
            throw new InvalidReservationException("Can't be empty number of guest");
        }

        List<ReservationRoom> reservationRooms = reservation.getReservationRoom();

        Reservation reservation1 = new Reservation();
        reservation1.setCheckingDate(reservation.getCheckingDate());
        reservation1.setCheckoutDate(reservation.getCheckoutDate());
        reservation1.setNoOfGuest(reservation.getNoOfGuest());
        reservation1.setActive(true);
        reservation1.setCustomerID(reservation.getCustomerID());
        reservation1.setReservationType(reservation.getReservationType());
        reservation1 = reservationRepository.save(reservation1);

        List<ReservationRoom> reservationRoomList = new ArrayList<>();

        if(reservation1.getReservationType() == "1"){
            for (ReservationRoom reservationRoom : reservationRooms) {
                reservationRoom.setReservation(reservation1);
                reservationRoom = reservationRoomService.Save(reservationRoom);
                reservationRoomList.add(reservationRoom);
            }
        }




        reservation1.setReservationRoom(reservationRoomList);

        return reservation1;
    }

    @Override
    public Reservation Update(Reservation reservation) {
        return null;
    }

    @Override
    public Reservation FindById(int id) {
        return null;
    }

    @Override
    public List<Reservation> FindAll() {
        return reservationRepository.findAll();
    }


    @Override
    public List<Reservation> getReservations(LocalDate checkOutDate, LocalDate checkingDate) {

        return reservationRepository.findByCheckingDateLessThanEqualAndCheckoutDateGreaterThanEqual(checkOutDate, checkingDate);
    }

    @Override
    public List<Reservation> getReservationsByType(LocalDate checkOutDate, LocalDate checkingDate,String reservationTypeID) {

         return reservationRepository.findByCheckingDateLessThanEqualAndCheckoutDateGreaterThanEqualAndReservationType(checkOutDate, checkingDate,reservationTypeID);

    }
}
