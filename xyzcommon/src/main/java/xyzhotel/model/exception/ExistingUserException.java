package xyzhotel.model.exception;

public class ExistingUserException extends RuntimeException{

    public ExistingUserException(String message){
        super(message);
    }
    public ExistingUserException(String message, Throwable cause){
        super(message, cause);
    }
}
