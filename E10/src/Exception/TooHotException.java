package Exception;

public class TooHotException extends Exception {
    public TooHotException() {
        super("The coffee is too hot!");
    }

    public TooHotException(String message) {
        super(message);
    }
}
