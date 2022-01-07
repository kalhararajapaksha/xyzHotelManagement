package com.nsbm.xyzhotel.controller;

import com.nsbm.xyzhotel.service.ReservationHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyzhotel.model.ReservationHall;
import xyzhotel.model.Responsehandle.Response;
import xyzhotel.model.exception.InvalidReservationException;

@RestController
@RequestMapping(value = "/reservationHall")
public class ReservationHallconntroller {

    @Autowired
    private ReservationHallService reservationHallService;

    @GetMapping
    public Response findAllReservation(){
        return Response.success(reservationHallService.findAll());
    }

    @PostMapping
    public Response saveReservationHall(@RequestBody ReservationHall reservationHall){
        try {
            reservationHall = reservationHallService.Save(reservationHall);
            return Response.success(reservationHall);
        }catch (InvalidReservationException invalidReservationException){
            return Response.fail(invalidReservationException);
        }
    }
}
