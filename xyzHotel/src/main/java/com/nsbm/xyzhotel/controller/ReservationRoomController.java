package com.nsbm.xyzhotel.controller;

import com.nsbm.xyzhotel.service.ReservationRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyzhotel.model.Reservation;
import xyzhotel.model.ReservationRoom;
import xyzhotel.model.Responsehandle.Response;
import xyzhotel.model.exception.InvalidRoomException;

import java.util.List;

@RestController
@RequestMapping("/reservationRoom")
public class ReservationRoomController {

    @Autowired
    private ReservationRoomService reservationRoomService;

    @PostMapping
    public Response save(@RequestBody ReservationRoom reservationRoom){


        try{
            ReservationRoom reservationRoom1 = reservationRoomService.Save(reservationRoom);

            return  Response.success(reservationRoom1);

        }catch (InvalidRoomException invalidRoomException){
            return Response.fail(invalidRoomException.getMessage());
        }

    }

    @GetMapping(value = "{reservationRoomId}")
    public  Response reservationRoomFindById(@PathVariable int reservationRoomId){
        ReservationRoom reservationRoom = reservationRoomService.findByID(reservationRoomId);
        if(reservationRoom != null){
            return Response.success(reservationRoom);
        }
        return Response.fail("Not Found");
    }

    @GetMapping
    public Response findAllReservationRoom(){
        List<ReservationRoom> reservationRoomList = reservationRoomService.findAll();
        if( reservationRoomList != null){
            return Response.success(reservationRoomList);
        }
        return Response.fail("Reservaation rooms are Not Found");
    }

    @PutMapping
    public Response update(@RequestBody ReservationRoom reservationRoom){
        try {
            reservationRoom = reservationRoomService.Update(reservationRoom);
            return Response.success(reservationRoom);

        }catch (InvalidRoomException invalidRoomException){
            return Response.fail(invalidRoomException);
        }
    }
}
