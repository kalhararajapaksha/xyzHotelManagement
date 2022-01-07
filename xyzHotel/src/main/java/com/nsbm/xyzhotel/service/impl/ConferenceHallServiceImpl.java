package com.nsbm.xyzhotel.service.impl;

import com.nsbm.xyzhotel.repository.ConferenceHallRepository;
import com.nsbm.xyzhotel.service.ConferenceHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyzhotel.model.ConferenceHall;

import java.util.List;

@Service
public class ConferenceHallServiceImpl implements ConferenceHallService {
    @Autowired
    ConferenceHallRepository conferenceHallRepository;
    @Override
    public String Save(ConferenceHall conferenceHall) {
        return null;
    }

    @Override
    public String Update(ConferenceHall conferenceHall) {
        return null;
    }

    @Override
    public ConferenceHall FindById(int id) {
        return null;
    }

    @Override
    public List<ConferenceHall> findAll() {
        return conferenceHallRepository.findAll();
    }
}
