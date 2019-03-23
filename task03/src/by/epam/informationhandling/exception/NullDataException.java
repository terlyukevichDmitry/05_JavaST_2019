package by.epam.informationhandling.exception;

/**
 * An public class for checking my exception.
 * In this class i'm checking my exception it is Null Data Exception.
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class NullDataException extends Exception {
    /**
     * Constructor for this class.
     */
    public NullDataException() {
        super();
    }
    /**
     * Constructor for this class.
     * @param information for show info about mistakes.
     */
    public NullDataException(final String information) {
        super(information);
    }
}
