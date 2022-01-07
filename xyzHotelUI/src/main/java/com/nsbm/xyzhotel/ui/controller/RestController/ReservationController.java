package com.nsbm.xyzhotel.ui.controller.RestController;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsbm.xyzhotel.ui.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyzhotel.model.*;
import xyzhotel.model.Responsehandle.Response;

import java.math.BigDecimal;
import java.sql.ClientInfoStatus;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reservations")
public class ReservationController {


    @Autowired
    private RoomService roomService;

    @PostMapping(value = "/roomDetailsForPageLoard")
    public Map<String, Object> reservationPageLoad(@RequestBody Reservation reservation) {
        Map<String, Object> map = new HashMap<>();
        List<RoomType> roomTypes = roomService.getRoomTypeList();
        List<RoomCapacity> roomCapacities = roomService.getRoomCapacityList();
        List<RoomCharge> roomCharges = roomService.getRoomChargeList();
        List<Room> availableRooms = roomService.getAvailableRoom(reservation);

        Map<String, Integer> availableRoomsForRoomTypeAndCapacity = new HashMap<>();
        Map<String, BigDecimal> roomChargeForRoomTypeAndCapacity = new HashMap<>();

        ObjectMapper objectMapper = new ObjectMapper();
        for (Object objectRoomType : roomTypes) {

            RoomType roomType = objectMapper.convertValue(objectRoomType, RoomType.class);

            for (Object objectRoomCapacity : roomCapacities) {
                RoomCapacity roomCapacity = objectMapper.convertValue(objectRoomCapacity, RoomCapacity.class);

                int roomCount = 0;
                for (Room room : availableRooms) {
                    if (room.getRoomTypeId() == roomType.getRoomTypeId() &&
                            room.getCapacityID() == roomCapacity.getRoomCapacityID()) {
                        roomCount++;
                    }
                }
                availableRoomsForRoomTypeAndCapacity
                        .put(roomType.getRoomTypeId() + "" + roomCapacity.getRoomCapacityID(), roomCount);
                for (Object objectRoomCharge : roomCharges) {
                    RoomCharge roomCharge=objectMapper.convertValue(objectRoomCharge,RoomCharge.class);

                    if (roomCharge.getRoomTypeID() == roomType.getRoomTypeId() &&
                            roomCharge.getRoomCapacityID() == roomCapacity.getRoomCapacityID()) {

                        roomChargeForRoomTypeAndCapacity
                                .put(roomType.getRoomTypeId() + "" + roomCapacity.getRoomCapacityID(), roomCharge.getRoomCharge());
                    }
                }
            }
        }

        map.put("roomTypes", roomTypes);
        map.put("roomCapacity", roomCapacities);
        map.put("roomChargers", roomChargeForRoomTypeAndCapacity);
        map.put("availableRooms", availableRoomsForRoomTypeAndCapacity);
        return map;
    }

    @GetMapping
    public List<RoomType> roomTypes() {
        List<RoomType> roomTypeList = roomService.getRoomTypeList();
        if (roomTypeList != null) {
            return roomTypeList;
        }
        return null;
    }

    @GetMapping(value = "/reservation")
    public List<Room> reservations(@RequestBody Reservation reservation) {
        List<Room> roomList = roomService.getAvailableRoom(reservation);
        if (roomList != null) {
            return roomList;
        }
        return null;
    }


    @PostMapping(value ="/getRoomIdforReservaton" )
    public Response reservation (@RequestBody Map map){
          try {
              //Response response = roomService.saveReservation(map);
              return Response.success( roomService.saveReservation(map));
          }catch (Exception e){
              return Response.fail("can't reserve room");
          }

    }

}
