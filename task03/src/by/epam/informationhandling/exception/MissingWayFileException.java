package by.epam.informationhandling.exception;

/**
 * An public class for checking my exception.
 * In this class i'm checking my exception it is Missing Way File Exception
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class MissingWayFileException extends Exception {

    /**
     * Constructor for this class.
     */
    public MissingWayFileException() {
        super();
    }
    /**
     * Constructor for this class.
     * @param information for show info about mistakes.
     */
    public MissingWayFileException(final String information) {
        super(information);
    }
}
