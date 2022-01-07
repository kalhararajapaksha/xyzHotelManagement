package com.nsbm.xyzhotel.service.impl;

import com.nsbm.xyzhotel.repository.ReservationHallRepository;
import com.nsbm.xyzhotel.service.ReservationHallService;
import com.nsbm.xyzhotel.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyzhotel.model.ReservationHall;
import xyzhotel.model.exception.InvalidReservationException;

import java.util.List;

@Service
public class ReservationHallServiceImpl implements ReservationHallService {
    @Autowired
    private ReservationHallRepository reservationHallRepository;

    @Override
    public ReservationHall Save(ReservationHall reservationHall) throws InvalidReservationException {
         if(reservationHall.getHallId() == 0){
            throw new InvalidReservationException("Hall No can't be null");
         }
         if(reservationHall.getReservationId() == 0){
             throw new InvalidReservationException("hall type cant'be null");
         }
        reservationHall = reservationHallRepository.save(reservationHall);

        return reservationHall;
    }

    @Override
    public String Update(ReservationHall reservationHall) {
        return null;
    }

    @Override
    public ReservationHall FindById(int id) {
        return null;
    }

    @Override
    public List<ReservationHall> findAll() {
        List<ReservationHall> reservationHallList = reservationHallRepository.findAll();
        return reservationHallList;
    }
}
