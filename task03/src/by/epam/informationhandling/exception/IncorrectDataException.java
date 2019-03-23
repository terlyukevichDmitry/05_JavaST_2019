package by.epam.informationhandling.exception;

/**
 * An public class for checking my exception.
 * In this class i'm checking my exception it is Incorrect Data Exception.
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class IncorrectDataException extends Exception {
    /**
     * Constructor for this class.
     */
    public IncorrectDataException() {
        super();
    }
    /**
     * Constructor for this class.
     * @param information for show info about mistakes.
     */
    public IncorrectDataException(final String information) {
        super(information);
    }
}
