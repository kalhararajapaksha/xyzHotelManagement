package com.nsbm.xyzhotel.controller;

import com.nsbm.xyzhotel.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyzhotel.model.Reservation;
import xyzhotel.model.ReservationRoom;
import xyzhotel.model.Responsehandle.Response;
import xyzhotel.model.exception.InvalidReservationException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public Response save(@RequestBody Reservation reservation){

        try{
            reservation = reservationService.Save(reservation);
            return Response.success(reservation);

        }catch(InvalidReservationException invalidReservationException){

            return Response.fail(invalidReservationException.getMessage());
        }

    }

    @PostMapping(value = "/checkOutDateAndChecking")
    public Response getReservation(@RequestBody Reservation reservation){
        List<Reservation> reservations = reservationService.getReservations(reservation.getCheckoutDate(),reservation.getCheckingDate());
        //List<ReservationRoom> reservationRooms = reservationService.getReservations(reservation.getCheckoutDate(),reservation.getCheckingDate());
        if (reservations != null) {
            return Response.success(reservations);
        } else {
            return Response.fail("Reservation Not Exist");
        }

    }

    @PostMapping(value = "/checkingAndCheckOutDateAndReservationType")
    public Response getReservationsByType(@RequestBody Reservation reservation){
        List<Reservation> reservations = reservationService.getReservationsByType(reservation.getCheckoutDate(),reservation.getCheckingDate(), reservation.getReservationType());
        if (reservation != null) {
            return Response.success(reservations);
        } else {
            return Response.fail("Reservation Not Exist");
        }

    }

    @GetMapping
    public Response findAll(){
        return Response.success(reservationService.FindAll());
    }

}
