package xyzhotel.model;

import javax.persistence.*;

@Entity
@Table(name = "reservationType")
public class ReservationType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservationTypeId;
    private String reservationTypeName;

    public int getReservationTypeId() {
        return reservationTypeId;
    }

    public void setReservationTypeId(int reservationTypeId) {
        this.reservationTypeId = reservationTypeId;
    }

    public String getReservationTypeName() {
        return reservationTypeName;
    }

    public void setReservationTypeName(String reservationTypeName) {
        this.reservationTypeName = reservationTypeName;
    }
}
