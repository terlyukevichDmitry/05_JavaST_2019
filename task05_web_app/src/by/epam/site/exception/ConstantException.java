package by.epam.site.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

/**
 * I created this class, because we use this type exception in plural places.
 */
public class ConstantException extends Exception {
    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER
            = LogManager.getLogger(ConstantException.class);
    public ConstantException() {
    }

    public ConstantException(SQLException exception) {
        super(exception);
        LOGGER.error("We have exception in constant places!");
    }
}
