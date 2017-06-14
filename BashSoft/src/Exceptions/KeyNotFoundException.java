package Exceptions;

/**
 * Created by mponev on 01.07.16.
 */
public class KeyNotFoundException extends RuntimeException {
    public static final String NON_EXISTING_COURSE = "Course does not exist";
    public KeyNotFoundException() {
        super(NON_EXISTING_COURSE);
    }
    public KeyNotFoundException(String message) {
        super(message);
    }

}
