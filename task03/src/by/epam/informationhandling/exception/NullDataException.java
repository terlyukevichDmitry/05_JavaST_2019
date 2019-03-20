package by.epam.informationhandling.exception;

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
