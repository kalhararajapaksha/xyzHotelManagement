package com.nsbm.xyzhotel.controller;

import com.nsbm.xyzhotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyzhotel.model.Responsehandle.Response;
import xyzhotel.model.Room;
import xyzhotel.model.exception.InvalidRoomException;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping
    public Response findAll(){

        return Response.success(roomService.FindAll());
        //return roomService.FindAll();
    }

    @GetMapping(value ="roomID")
    public Response findById(@PathVariable int roomID){
        Room room = roomService.FindById(roomID);
        if(room != null){
            return Response.success(room);
        }
        return Response.fail("NotFound");
    }

    @PostMapping(value = "/availbleRoomByRoomTypeAndCapacity")
    public Response findById(@RequestBody Room room){
       List<Room> roomList = roomService.findByRoomTypeAndCapacity(room.getRoomTypeId(),room.getCapacityID());
       if(roomList != null){
           return Response.success(roomList);
       }
       return Response.fail("No Available");
    }


}
