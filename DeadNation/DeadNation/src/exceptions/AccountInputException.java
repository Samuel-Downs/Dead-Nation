package exceptions;

public class AccountInputException extends Exception{
    public AccountInputException() {
    }
    public AccountInputException(String message) {
        super(message);
    }
}
