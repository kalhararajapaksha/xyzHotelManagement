package com.nsbm.xyzhotel.controller;

import com.nsbm.xyzhotel.service.RoomChargeService;
import xyzhotel.model.Responsehandle.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyzhotel.model.RoomCharge;

import java.util.List;

@RestController
@RequestMapping(value = "/roomCharges")
public class RoomChargeController {

    @Autowired
    private RoomChargeService roomChargeService;

    @GetMapping(value = "roomType")
    public Response findByRoomTypeAndCapacity(@RequestBody RoomCharge roomCharge){
        RoomCharge roomCharge1 =roomChargeService.findByRoomTypeAndRoomCapacity(roomCharge.getRoomTypeID(), roomCharge.getRoomCapacityID());
        if(roomCharge != null ){
            return Response.success(roomCharge1);
        }
        return Response.fail("Room Type and Capacity Not Exist");

    }
    @GetMapping
    public Response findAll(){
        return Response.success(roomChargeService.findAll());
       // return roomChargeService.findAll();
    }
}
