package com.nsbm.xyzhotel.service;

import xyzhotel.model.Reservation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ReservationService {

    public Reservation Save(Reservation reservation);

    public Reservation Update(Reservation reservation);

    public Reservation FindById(int id);

    public List<Reservation> FindAll();

    public List<Reservation> getReservations(LocalDate checkOutDate, LocalDate checkingDate);

    public List<Reservation> getReservationsByType(LocalDate checkOutDate, LocalDate checkingDate,String reservationTypeID);
}
