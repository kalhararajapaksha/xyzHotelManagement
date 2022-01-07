package xyzhotel.model.exception;

public class InvalidEmailException extends RuntimeException{

    public InvalidEmailException(String message){
        super(message);
    }
    public InvalidEmailException(String message,Throwable cause){
        super(message, cause);
    }

}
