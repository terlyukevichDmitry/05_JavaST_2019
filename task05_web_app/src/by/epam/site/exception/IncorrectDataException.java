package by.epam.site.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IncorrectDataException extends Exception {
    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER
            = LogManager.getLogger(ConstantException.class);

    public IncorrectDataException(final String message,
                                  final String value) {
        super(String.format("Empty or incorrect \"%s\" parameter was found: %s",
                message, value));
        LOGGER.error("Empty or incorrect \"%s\" parameter was found: %s");
    }
}
