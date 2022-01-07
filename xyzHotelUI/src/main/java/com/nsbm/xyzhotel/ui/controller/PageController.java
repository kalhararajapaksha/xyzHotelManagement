package com.nsbm.xyzhotel.ui.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping
    public String index(){
        return "index";
    }

    @GetMapping(value = "/signin")
    public String signin(){
        return "signin";
    }

    @GetMapping(value = "/signup")
    public String signup(){
        return "signup";
    }

    @GetMapping(value = "/profile")
    public  String userProfile(){return "profile";}

    @GetMapping(value = "/reservation")
    public String roomResrvation(){return "rooms";}

    @GetMapping(value = "/dashboard")
    public String userDashbord(){return "userdashboard";}

    @GetMapping(value = "/payment")
    public String paymentProcess(){return "guestdetails";}

    @GetMapping(value = "/reservationHall")
    public String hallResrvation(){return "hall";}

    @GetMapping(value = "/editProfile")
    public String editProfile(){return "editprofile";}


    //Admin Dashboard pages

    @GetMapping(value = "/admin")
    public String adminDashboard(){return "adminhome";}

    @GetMapping(value = "/reservationsList")
    public String reservationTable(){return "reservered";}

    @GetMapping(value = "/payments")
    public String paymentTable(){return "paymenthistory";}

    @GetMapping(value = "/registeredUsers")
    public String registeredUserTable(){return "registeredusers";}
}
