package com.nsbm.xyzhotel.ui.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsbm.xyzhotel.ui.service.HallService;
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
import java.time.LocalDate;
import java.util.*;

@Service
public class HallServiceImpl implements HallService {

    @Autowired
    private RestTemplate restTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public List<ConferenceHall> getHalltype() {
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        ResponseEntity<Response> responseEntity = restTemplate.getForEntity(
                "http://localhost:8080/conferenceHall"
                , Response.class);


        ArrayList<ConferenceHall> conferenceHallArrayList = null;
        if (responseEntity.getBody().isAction()) {
            conferenceHallArrayList = (ArrayList<ConferenceHall>) Arrays.asList(responseEntity.getBody().getData()).get(0);
        }



        return conferenceHallArrayList;
    }

    @Override
    public List<ReservationHall> getReservationList() {
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        ResponseEntity<Response> responseEntity = restTemplate.getForEntity(
                "http://localhost:8080/reservationHall"
                , Response.class);


        ArrayList<ReservationHall> reservationHalls = null;
        if (responseEntity.getBody().isAction()) {
            reservationHalls = (ArrayList<ReservationHall>) Arrays.asList(responseEntity.getBody().getData()).get(0);
        }



        return reservationHalls;
    }


    @Override
    public List<ConferenceHall> getAvailableHall(Reservation reservation) {


        HttpEntity<Reservation> httpEntity = new HttpEntity<>(reservation);

        ResponseEntity<Response> responseEntity = restTemplate.exchange(
                "http://localhost:8080/reservation/checkingAndCheckOutDateAndReservationType"
                , HttpMethod.POST
                , httpEntity
                , Response.class);


        ArrayList<Reservation> reservationList = null;

        if (responseEntity.getBody().isAction()) {
            reservationList = (ArrayList<Reservation>) Arrays.asList(responseEntity.getBody().getData()).get(0);

        }

        Set<Integer> hallIds = new HashSet<>();

        for (Object object : reservationList) {

            Reservation reservationObj = objectMapper.convertValue(object, Reservation.class);


            for (Object object1 : getReservationList()) {
                ReservationHall reservationHall = objectMapper.convertValue(object1, ReservationHall.class);
                if (reservationHall.getReservationId() == reservationObj.getReservationId()) {
                    hallIds.add(reservationHall.getHallId());
                }
            }

        }

        List<ConferenceHall> availableHall = new ArrayList<>();


        for (Object object : getHalltype()) {
            ConferenceHall conferenceHall = objectMapper.convertValue(object, ConferenceHall.class);
            if (!hallIds.contains(conferenceHall.getHallNo())) {
                availableHall.add(conferenceHall);
            }
        }

        return availableHall;
    }

    @Override
    public Response saveReservation(Map map) {

        String checkingDate = map.get("checkingDate").toString();
        LocalDate checkingDateParse = LocalDate.parse(checkingDate);
        String checkoutDate = map.get("checkoutDate").toString();
        LocalDate checkoutDateParse = LocalDate.parse(checkoutDate);
        int hallNo = Integer.parseInt(map.get("hallNo").toString());
        int guest = Integer.parseInt(map.get("guest").toString());
        int customerID = Integer.parseInt(map.get("customerID").toString());
        String reservationTypeID =  map.get("reservationType").toString();
        Double bill = Double.parseDouble(map.get("price").toString());

        BigDecimal billParse = BigDecimal.valueOf(bill);

        Reservation reservation = new Reservation();
        reservation.setCheckingDate(checkingDateParse);
        reservation.setCheckoutDate(checkoutDateParse);
        reservation.setNoOfGuest(guest);
        reservation.setActive(true);
        reservation.setCustomerID(customerID);
        reservation.setReservationType(reservationTypeID);




        List<ConferenceHall> availableHall = getAvailableHall(reservation);
        List<ReservationHall> reservationHallList = new ArrayList<>();


        HttpEntity<Reservation> httpEntity = new HttpEntity<>(reservation);
        ResponseEntity<Response> responseEntity = restTemplate.exchange(
                "http://localhost:8080/reservation"
                , HttpMethod.POST
                , httpEntity
                , Response.class);


        Object object = null;
        if (responseEntity.getBody().isAction()) {
               object = responseEntity.getBody().getData();

        }

             ReservationHall reservationHall = new ReservationHall();

            Reservation reservation1 = objectMapper.convertValue(object, Reservation.class);
            int reservationID = reservation1.getReservationId();

            reservationHall.setHallId(hallNo);
            reservationHall.setReservationId(reservationID);





            HttpEntity<ReservationHall> httpEntityHall = new HttpEntity<>(reservationHall);
            ResponseEntity<Response> responseEntityHall = restTemplate.exchange(
                    "http://localhost:8080/reservationHall"
                    , HttpMethod.POST
                    , httpEntityHall
                    , Response.class);



        return responseEntity.getBody();
    }
}
