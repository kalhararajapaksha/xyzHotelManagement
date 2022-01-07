package com.nsbm.xyzhotel.ui.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsbm.xyzhotel.ui.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import xyzhotel.model.*;
import xyzhotel.model.Responsehandle.Response;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.*;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RestTemplate restTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<RoomType> getRoomTypeList() {
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        ResponseEntity<Response> responseEntity = restTemplate.getForEntity(
                "http://localhost:8080/roomType"
                , Response.class);


        ArrayList<RoomType> roomTypeArrayList = null;
        if (responseEntity.getBody().isAction()) {
            roomTypeArrayList = (ArrayList<RoomType>) Arrays.asList(responseEntity.getBody().getData()).get(0);
        }
        // Response roomTypes1 =responseEntity.getBody();

        // List<RoomType> roomTypes = Arrays.asList(responseEntity.getBody());


        return roomTypeArrayList;

    }

    @Override
    public List<RoomCapacity> getRoomCapacityList() {

        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        ResponseEntity<Response> responseEntity = restTemplate.exchange(
                "http://localhost:8080/roomCapacity"
                , HttpMethod.GET
                , httpEntity
                , Response.class);
        ArrayList<RoomCapacity> roomCapacityArrayList = null;
        if (responseEntity.getBody().isAction()) {
            roomCapacityArrayList = (ArrayList<RoomCapacity>) Arrays.asList(responseEntity.getBody().getData()).get(0);
        }


        // List<RoomCapacity> roomCapacities = Arrays.asList(responseEntity.getBody());


        return roomCapacityArrayList;

    }

    @Override
    public List<RoomCharge> getRoomChargeList() {
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        ResponseEntity<Response> responseEntity = restTemplate.exchange(
                "http://localhost:8080/roomCharges"
                , HttpMethod.GET
                , httpEntity
                , Response.class);
        ArrayList<RoomCharge> roomChargeArrayList = null;
        if (responseEntity.getBody().isAction()) {
            roomChargeArrayList = (ArrayList<RoomCharge>) Arrays.asList(responseEntity.getBody().getData()).get(0);
        }

        //    List<RoomCharge> roomCharge = Arrays.asList(responseEntity.getBody());


        return roomChargeArrayList;
    }

    @Override
    public List<Room> getRoomeList() {
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        ResponseEntity<Response> responseEntity = restTemplate.exchange(
                "http://localhost:8080/room"
                , HttpMethod.GET
                , httpEntity
                , Response.class);
        ArrayList<Room> roomArrayList = null;
        if (responseEntity.getBody().isAction()) {
            roomArrayList = (ArrayList<Room>) Arrays.asList(responseEntity.getBody().getData()).get(0);
        }

        //  List<Room> rooms = Arrays.asList(roomArrayList);

        return roomArrayList;
    }


    @Override
    public List<Room> getAvailableRoom(Reservation reservation) {


        HttpEntity<Reservation> httpEntity = new HttpEntity<>(reservation);

        ResponseEntity<Response> responseEntity = restTemplate.exchange(
                "http://localhost:8080/reservation/checkOutDateAndChecking"
                , HttpMethod.POST
                , httpEntity
                , Response.class);


        ArrayList<Reservation> reservationList = null;
        if (responseEntity.getBody().isAction()) {
            reservationList = (ArrayList<Reservation>) Arrays.asList(responseEntity.getBody().getData()).get(0);

        }

        Set<Integer> roomIds = new HashSet<>();

        for (Object object : reservationList) {

            Reservation reservationObj = objectMapper.convertValue(object, Reservation.class);


            for (ReservationRoom reservationRoom : reservationObj.getReservationRoom()) {
                roomIds.add(reservationRoom.getRoomId());
            }
        }


//        for(int x=0 ;x<reservationList.size();x++){
//
//            Reservation reservationObj = new ObjectMapper().convertValue(reservationList.get(x),Reservation.class);
//            for (ReservationRoom reservationRoom : reservationObj.getReservationRoom()) {
//                roomIds.add(reservationRoom.getRoomId());
//            }
//        }

        List<Room> availableRooms = new ArrayList<>();

        for (Object object : getRoomeList()) {
            Room room = objectMapper.convertValue(object, Room.class);
            if (!roomIds.contains(room.getRoomNo())) {
                availableRooms.add(room);
            }
        }

        return availableRooms;
    }


    @Override
    public Response saveReservation(Map map) {


        String checkingDate = map.get("checkingDate").toString();
        LocalDate checkingDateParse = LocalDate.parse(checkingDate);
        String checkoutDate = map.get("checkOutDate").toString();
        LocalDate checkoutDateParse = LocalDate.parse(checkoutDate);
        List roomDetail = (List) map.get("roomDetail");
        int guest = Integer.parseInt(map.get("guest").toString());
        Double bill = Double.parseDouble(map.get("totalBill").toString());
        String reservationTypeID =  map.get("reservationType").toString();
        int customerID = Integer.parseInt(map.get("customerID").toString());

        BigDecimal billParse = BigDecimal.valueOf(bill);

        Reservation reservation = new Reservation();
        reservation.setCheckingDate(checkingDateParse);
        reservation.setCheckoutDate(checkoutDateParse);
        reservation.setReservationType(reservationTypeID);
        reservation.setActive(true);
        reservation.setCustomerID(customerID);
        reservation.setNoOfGuest(guest);

        List<Room> availableRooms = getAvailableRoom(reservation);
        List<ReservationRoom> reservationRooms = new ArrayList<>();


        for (int i = 0; i < roomDetail.size(); i++) {
            Map roomDetailsMap = (Map) roomDetail.get(i);

            int roomCapacityId = Integer.parseInt(roomDetailsMap.get("capacityID").toString());
            int roomTypeId = Integer.parseInt(roomDetailsMap.get("roomTypeId").toString());
            int roomCount = Integer.parseInt(roomDetailsMap.get("roomCount").toString());

            for (Room room : availableRooms) {
                if (room.getRoomTypeId() == roomTypeId && room.getCapacityID() == roomCapacityId && roomCount != 0) {
                    ReservationRoom reservationRoom = new ReservationRoom();
                    reservationRoom.setRoomId(room.getRoomNo());
                    reservationRooms.add(reservationRoom);
                }
            }
        }

        reservation.setReservationRoom(reservationRooms);


        HttpEntity<Reservation> httpEntity = new HttpEntity<>(reservation);
        ResponseEntity<Response> responseEntity = restTemplate.exchange(
                "http://localhost:8080/reservation"
                , HttpMethod.POST
                , httpEntity
                , Response.class);

        return responseEntity.getBody();
    }


}
