package by.epam.informationhandling.exception;

/**
 * An public class for checking my exception.
 * In this class i'm checking my exception it is File Empty Exception
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class FileEmptyException extends Exception {
    /**
     * Constructor for this class.
     */
    public FileEmptyException() {
        super();
    }
    /**
     * Constructor for this class.
     * @param information for show info about mistakes.
     */
    public FileEmptyException(final String information) {
        super(information);
    }
}
