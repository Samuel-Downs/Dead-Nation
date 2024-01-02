package exceptions;

public class ExitBlockedException extends Exception{
    public ExitBlockedException() {
    }
    public ExitBlockedException(String message) {
        super(message);
    }
}
