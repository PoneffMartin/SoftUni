package Exceptions;

/**
 * Created by mponev on 02.07.16.
 */
public class InvalidCommandException extends RuntimeException {
    private static final String INVALID_COMMAND = "This command does not exist";

    public InvalidCommandException() {
        super(INVALID_COMMAND);
    }
    public InvalidCommandException(String message) {
        super(message);
    }
}
