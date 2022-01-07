package com.nsbm.xyzhotel.ui.controller.RestController;

import com.nsbm.xyzhotel.ui.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyzhotel.model.ConferenceHall;
import xyzhotel.model.Reservation;
import xyzhotel.model.Responsehandle.Response;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reservationHallRest")
public class ReservationHallController {

    @Autowired
    private HallService hallService;


    @PostMapping
    public Response conferenceHallListForPageLoad(){

        try {
            List<ConferenceHall> conferenceHallList = hallService.getHalltype();
            return Response.success(conferenceHallList);
        }catch (Exception e){
            return  Response.fail(e);

        }

    }

    @PostMapping(value = "/availableHallList")
    public Response availableConferenceHallListForPageLoad(@RequestBody Reservation reservation){
        try {
            List<ConferenceHall> aVconferenceHallList = hallService.getAvailableHall(reservation);
            return Response.success(aVconferenceHallList);
        }catch (Exception e){
            return  Response.fail(e);

        }

    }

    @PostMapping(value ="/getHallNoforReservation" )
    public Response reservation (@RequestBody Map map){
        try {
            //Response response = roomService.saveReservation(map);
            return Response.success( hallService.saveReservation(map));
        }catch (Exception e){
            return Response.fail("can't reserve room");
        }


    }


}
