package by.epam.task02.multithreading.exception;

/**
 * An public class for checking my exception.
 * In this class i'm checking my exception it is data for person object.
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class PersonDataException extends Exception {
    /**
     * Constructor for this class.
     */
    public PersonDataException() {
        super();
    }

    /**
     * Constructor for this class.
     * @param information for show info about mistakes.
     */
    public PersonDataException(final String information) {
        super(information);
    }
}
