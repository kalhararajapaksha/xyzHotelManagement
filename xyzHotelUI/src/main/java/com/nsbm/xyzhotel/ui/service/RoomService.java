package com.nsbm.xyzhotel.ui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import xyzhotel.model.*;
import xyzhotel.model.Responsehandle.Response;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


public interface RoomService {

    public List<RoomType> getRoomTypeList();

    public List<RoomCapacity> getRoomCapacityList();

    public List<RoomCharge> getRoomChargeList();

    public List<Room> getRoomeList();

    public  List<Room> getAvailableRoom(Reservation reservation);

    public Response saveReservation(Map map);






}
