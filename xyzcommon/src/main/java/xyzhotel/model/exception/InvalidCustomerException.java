package xyzhotel.model.exception;

public class InvalidCustomerException extends RuntimeException{

    public InvalidCustomerException(String message){
        super(message);
    }

    public InvalidCustomerException(String message,Throwable cause){
        super(message, cause);
    }
}
