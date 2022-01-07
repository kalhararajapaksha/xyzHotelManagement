package com.nsbm.xyzhotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyzhotel.model.Reservation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Integer> {


    public  List<Reservation> findByCheckingDateLessThanEqualAndCheckoutDateGreaterThanEqualAndReservationType(LocalDate checkOutDate,LocalDate checkingDate,String reservationType);

    public List<Reservation> findByCheckingDateLessThanEqualAndCheckoutDateGreaterThanEqual(LocalDate checkOutDate,LocalDate checkingDate);
}
