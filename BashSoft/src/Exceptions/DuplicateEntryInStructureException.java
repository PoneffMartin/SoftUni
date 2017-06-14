package Exceptions;

/**
 * Created by mponev on 01.07.16.
 */
public class DuplicateEntryInStructureException extends RuntimeException{
    public static final String DUPLICATE_ENTRY = "The %s already exist in %s.";

    public DuplicateEntryInStructureException(String entryName, String structureName) {
        super(String.format(DUPLICATE_ENTRY, entryName, structureName));
    }
    public DuplicateEntryInStructureException(String message) {
        super(message);
    }
}
