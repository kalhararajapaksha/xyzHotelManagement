package xyzhotel.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table( name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservationId;
    private int customerID;
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate checkingDate;
    @JsonSerialize(using = LocalTimeSerializer.class)
    @JsonDeserialize(using = LocalTimeDeserializer.class)
    private LocalTime checkingTime;
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate checkoutDate;
    @JsonSerialize(using = LocalTimeSerializer.class)
    @JsonDeserialize(using = LocalTimeDeserializer.class)
    private LocalTime checkOutTime;
    private boolean isActive;
    private String reservationType;
    private int noOfGuest;

    //@OneToMany(mappedBy = "reservationId", fetch = FetchType.LAZY)
    @OneToMany(mappedBy = "reservation", fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
    private List<ReservationRoom> reservationRoom;




    public List<ReservationRoom> getReservationRoom() {
        return reservationRoom;
    }

    public void setReservationRoom(List<ReservationRoom> reservationRoom) {
        this.reservationRoom = reservationRoom;
    }

    public LocalDate getCheckingDate() {
        return checkingDate;
    }

    public void setCheckingDate(LocalDate checkingDate) {
        this.checkingDate = checkingDate;
    }

    public LocalTime getCheckingTime() {
        return checkingTime;
    }

    public void setCheckingTime(LocalTime checkingTime) {
        this.checkingTime = checkingTime;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public LocalTime getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(LocalTime checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getReservationType() {
        return reservationType;
    }

    public void setReservationType(String reservationType) {
        this.reservationType = reservationType;
    }

    public int getNoOfGuest() {
        return noOfGuest;
    }

    public void setNoOfGuest(int noOfGuest) {
        this.noOfGuest = noOfGuest;
    }


}
