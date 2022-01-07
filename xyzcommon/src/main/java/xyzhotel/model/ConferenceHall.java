package xyzhotel.model;

import javax.persistence.*;

@Entity
@Table(name = "conferenceHall")
public class ConferenceHall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hallNo;
    private String conferenceHallType;
    private int capacity;
    private boolean isReservation;

    public int getHallNo() {
        return hallNo;
    }

    public void setHallNo(int hallNo) {
        this.hallNo = hallNo;
    }

    public String getConferenceHallType() {
        return conferenceHallType;
    }

    public void setConferenceHallType(String conferenceHallType) {
        this.conferenceHallType = conferenceHallType;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isReservation() {
        return isReservation;
    }

    public void setReservation(boolean reservation) {
        isReservation = reservation;
    }
}
