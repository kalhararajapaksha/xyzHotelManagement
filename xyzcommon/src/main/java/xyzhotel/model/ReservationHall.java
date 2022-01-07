package xyzhotel.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "reservationHall")
public class ReservationHall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservationHallId;
    private int reservationId;
    private int hallId;



    public int getReservationHallId() {
        return reservationHallId;
    }

    public void setReservationHallId(int reservationHallId) {
        this.reservationHallId = reservationHallId;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getHallId() {
        return hallId;
    }

    public void setHallId(int hallId) {
        this.hallId = hallId;
    }


}
