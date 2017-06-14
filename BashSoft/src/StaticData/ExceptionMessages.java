package StaticData;

/**
 * Created by mponev on 19.05.16.
 */
public class ExceptionMessages {
    public static final String DATA_ALREADY_INITIALIZED = "Repository.StudentsRepository has already been initialized";
    public static final String DATA_NOT_INITIALIZED     = "Repository.StudentsRepository is not initialized";
    public static final String NON_EXISTING_COURSE      = "Course does not exist";
    public static final String NON_EXISTING_STUDENT     = "Student does not exist";
    public static final String INVALID_PATH             = "File does not exist";
    public static final String CANNOT_ACCESS_FILE       = "Cannot access file.";
    public static final String INVALID_OUTPUT_LENGTH    = "Actual and expected files are with different length.";
    public static final String INVALID_DESTINATION      = "Cannot go higher in folder hierarchy.";
    public static final String INVALID_FILTER           = "Invalid filter.";
    public static final String STUDENT_ALREADY_ENROLLED = "The %s already exist in %s.";
    public static final String NOT_ENROLLED_IN_COURSE   = "Student must be enrolled in course before you set his mark.";
    public static final String INVALID_NUMBER_OF_SCORES = "The number of scores for the given course is greater than the possible.";
    public static final String INVALID_SCORE            = "The number for the score you've entered is not in the range of 0 - 100";
    public static final String NULL_OR_EMPTY_VALUE      = "The value of the variable CANNOT be null or empty!";
    public static final String FORBIDDEN_SYMBOLS_CONTAINED_IN_NAME =
            "The given name contains symbols that are not allowed to be used in names of files or folders.";
    public static final String INVALID_COMPARISON_QUERY =
            "The comparison query you want, does not exist in the context of the current program!";
    public static final String INVALID_TAKE_COMMAND =
            "The take command expected does not match the format wanted!";
    public static final String IVALID_TAKE_QUANTITY_PARAMETER =
            "The quantity you are trying to take is an invalid parameter!";
}
