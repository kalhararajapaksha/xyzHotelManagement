package xyzhotel.model;

import javax.persistence.*;

@Entity
@Table(name = "roomCapacity")
public class RoomCapacity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomCapacityID;
    private int capacity;

    public int getRoomCapacityID() {
        return roomCapacityID;
    }

    public void setRoomCapacityID(int roomCapacityID) {
        this.roomCapacityID = roomCapacityID;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
