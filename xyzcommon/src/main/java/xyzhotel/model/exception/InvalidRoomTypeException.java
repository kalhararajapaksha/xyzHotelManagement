package xyzhotel.model.exception;

public class InvalidRoomTypeException extends RuntimeException{

    public InvalidRoomTypeException(String message){
        super(message);
    }

    public InvalidRoomTypeException(String message, Throwable cause){
        super(message, cause);
    }
}
