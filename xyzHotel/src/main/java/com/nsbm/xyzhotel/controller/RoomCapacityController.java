package com.nsbm.xyzhotel.controller;

import com.nsbm.xyzhotel.service.RoomCapacityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyzhotel.model.Responsehandle.Response;
import xyzhotel.model.RoomCapacity;

import java.util.List;

@RestController
@RequestMapping(value = "/roomCapacity")
public class RoomCapacityController {

    @Autowired
    private RoomCapacityService roomCapacityService;

    @GetMapping(value = "/{roomCapacityId}")
    public Response roomCapacity(@PathVariable int roomCapacityId){
        RoomCapacity roomCapacity = roomCapacityService.findById(roomCapacityId);
        if(roomCapacity != null){
            return Response.success(roomCapacity);
        }
        return Response.fail("Invalid room capacity ID");
    }

    @GetMapping
    public Response findAll(){
        return Response.success(roomCapacityService.findAll());
        //return roomCapacityService.findAll();
    }

}
