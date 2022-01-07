package com.nsbm.xyzhotel.service;

import xyzhotel.model.ConferenceHall;
import java.util.List;

public interface ConferenceHallService {

    public String Save(ConferenceHall conferenceHall) ;

    public String Update(ConferenceHall conferenceHall);

    public ConferenceHall FindById(int id);

    public List<ConferenceHall> findAll();
}
