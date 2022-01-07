package xyzhotel.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "reservationRoom" )
public class ReservationRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservationRoomId;
   // private int reservationId;
    private int roomId;

   // @ManyToOne
   // @JoinColumn(name="reservationId", nullable=false)
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY , optional = false)
    @JoinColumn(name = "reservationId" ,nullable = false)
    private Reservation reservation;

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public int getReservationRoomId() {
        return reservationRoomId;
    }

    public void setReservationRoomId(int reservationRoomId) {
        this.reservationRoomId = reservationRoomId;
    }



    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }


}
