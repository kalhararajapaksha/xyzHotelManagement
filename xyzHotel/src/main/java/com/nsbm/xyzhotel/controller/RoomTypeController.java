package com.nsbm.xyzhotel.controller;

import com.nsbm.xyzhotel.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import xyzhotel.model.Responsehandle.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyzhotel.model.RoomType;

import java.util.List;

@RestController
@RequestMapping("roomType")
public class RoomTypeController {

    @Autowired
    private RoomTypeService roomTypeService;

    @GetMapping(value = "/{roomTypeId}")
    public Response findByRoomTypeID(@PathVariable int roomTypeId){
        RoomType roomType = roomTypeService.findById(roomTypeId);
        if(roomType != null){
            return Response.success(roomType);
        }
        return Response.fail("Invalid Room Type");
    }

    @GetMapping
    public Response findAll(){
        List<RoomType> roomTypes = roomTypeService.findAll();
        if(roomTypes != null){
            return Response.success(roomTypeService.findAll());
        }
        return null;
    }
}
