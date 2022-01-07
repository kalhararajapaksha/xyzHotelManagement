package xyzhotel.model.exception;

public class InvalidUserNameException extends RuntimeException{


    public InvalidUserNameException(String message){
        super(message);
    }
    public InvalidUserNameException(String message,Throwable cause){
        super(message, cause);
    }
}
