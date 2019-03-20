package by.epam.informationhandling.exception;

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
