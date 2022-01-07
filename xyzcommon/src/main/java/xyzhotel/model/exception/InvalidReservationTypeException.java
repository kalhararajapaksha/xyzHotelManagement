package xyzhotel.model.exception;

public class InvalidReservationTypeException extends RuntimeException{

    public InvalidReservationTypeException(String message){
        super(message);
    }

    public InvalidReservationTypeException(String message,Throwable cause){
        super(message, cause);
    }
}
