package xyzhotel.model.exception;

public class ReservationNotFoundException extends RuntimeException{

    public ReservationNotFoundException(String message){
        super(message);
    }
    public ReservationNotFoundException(String message,Throwable cause){
        super(message, cause);
    }
}
