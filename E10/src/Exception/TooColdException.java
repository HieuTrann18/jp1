package Exception;

public class TooColdException extends TemperatureException {
    public TooColdException(String message) {
        super(message);
    }

    public TooColdException() {
        super("The coffee is too cold!"); // Đây là thông báo mặc định
    }
}
