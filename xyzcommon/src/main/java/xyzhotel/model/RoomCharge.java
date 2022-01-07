package xyzhotel.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "roomCharge")
public class RoomCharge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomChargeID;
    private int roomTypeID;
    private int roomCapacityID;
    private BigDecimal roomCharge;

    public int getRoomTypeID() {
        return roomTypeID;
    }

    public void setRoomTypeID(int roomTypeID) {
        this.roomTypeID = roomTypeID;
    }

    public int getRoomChargeID() {
        return roomChargeID;
    }

    public void setRoomChargeID(int roomChargeID) {
        this.roomChargeID = roomChargeID;
    }

    public int getRoomCapacityID() {
        return roomCapacityID;
    }

    public void setRoomCapacityID(int roomCapacityID) {
        this.roomCapacityID = roomCapacityID;
    }

    public BigDecimal getRoomCharge() {
        return roomCharge;
    }

    public void setRoomCharge(BigDecimal roomCharge) {
        this.roomCharge = roomCharge;
    }
}
