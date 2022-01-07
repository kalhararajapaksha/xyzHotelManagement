package xyzhotel.model.exception;

public class ReservationHallNotFoundException extends RuntimeException{

    public ReservationHallNotFoundException(String message){
        super(message);
    }

    public  ReservationHallNotFoundException(String message,Throwable cause){
        super(message, cause);
    }
}
