package com.nsbm.xyzhotel.ui.service;
import xyzhotel.model.*;
import xyzhotel.model.Responsehandle.Response;

import java.util.List;
import java.util.Map;

public interface HallService {

    public List<ConferenceHall> getHalltype();

    public List<ReservationHall> getReservationList();

    public List<ConferenceHall> getAvailableHall(Reservation reservation);

    public Response saveReservation(Map map);
}
