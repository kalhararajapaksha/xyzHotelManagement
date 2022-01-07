package com.nsbm.xyzhotel.controller;

import com.nsbm.xyzhotel.service.ConferenceHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyzhotel.model.Responsehandle.Response;

@RestController
@RequestMapping("/conferenceHall")
public class ConferenceHallController {
    @Autowired
    ConferenceHallService conferenceHallService;

    @GetMapping
    public Response getConferenceHallList(){

        return Response.success(conferenceHallService.findAll());
    }
}
