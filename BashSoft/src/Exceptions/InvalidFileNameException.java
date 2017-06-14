package Exceptions;

/**
 * Created by mponev on 01.07.16.
 */
public class InvalidFileNameException extends RuntimeException {
    private static final String FORBIDDEN_SYMBOLS_CONTAINED_IN_NAME = "The given name contains symbols" +
            "that are not allowed to be contained in names of files or folders.";

    public InvalidFileNameException() {
        super(FORBIDDEN_SYMBOLS_CONTAINED_IN_NAME);
    }

    public InvalidFileNameException(String message) {
        super(message);
    }
}
