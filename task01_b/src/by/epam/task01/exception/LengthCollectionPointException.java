package by.epam.task01.exception;

/**
 * An public class for checking my exception.
 * In this class i'm checking my exception it is length collection point ex.
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class LengthCollectionPointException extends Exception {
    /**
     * Constructor without parameter.
     */
    public LengthCollectionPointException() {
    }
    /**
     * Constructor for this class.
     * @param information for show info about mistakes.
     */
    public LengthCollectionPointException(final String information) {
        super(information);
    }
}
