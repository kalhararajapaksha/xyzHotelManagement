package xyzhotel.model.exception;

public class ConferenceHallNotFoundException extends RuntimeException{

    public  ConferenceHallNotFoundException(String message){
        super(message);
    }
    public ConferenceHallNotFoundException(String message,Throwable cause){
        super(message, cause);
    }
}
