package by.epam.task01.exception;

/**
 * An public class for checking my exception.
 * In this class i'm checking my exception it is pyramid data exception.
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class PyramidException extends Exception {
    /**
     * Constructor without parameter.
     */
    public PyramidException() {
    }
    /**
     * Constructor for this class.
     * @param information for show info about mistakes.
     */
    public PyramidException(final String information) {
        super(information);
    }
}
