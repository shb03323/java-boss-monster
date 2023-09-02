package bossmonster.exception;

public class CustomException extends IllegalArgumentException {

    private static final String ERROR_PREFIX = "[ERROR] ";

    public CustomException(final String message) {
        super(ERROR_PREFIX + message);
    }
}
