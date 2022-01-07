package xyzhotel.model;

import javax.lang.model.element.Name;
import javax.persistence.*;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomNo;
    private int roomTypeId;
    private int capacityID;
    private boolean isReservation;

    public int getCapacityID() {
        return capacityID;
    }

    public void setCapacityID(int capacityID) {
        this.capacityID = capacityID;
    }

    public int getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(int roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public boolean isReservation() {
        return isReservation;
    }

    public void setReservation(boolean reservation) {
        isReservation = reservation;
    }



    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }



}

