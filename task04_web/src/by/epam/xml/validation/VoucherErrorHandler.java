package by.epam.xml.validation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * This class we use for validating VoucherErrorHandler.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class VoucherErrorHandler extends DefaultHandler {
    Logger logger;
    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER =
            LogManager.getLogger(VoucherErrorHandler.class);

    public VoucherErrorHandler(String log) {
        logger = LogManager.getLogger("error");
        //logger..addAppender(new FileAppender(new SimpleLayout(), log));
    }

    /**
     * {@inheritDoc}
     * @param e warn exception.
     */
    @Override
    public void warning(final SAXParseException e) {
        LOGGER.warn(getLineAddress(e) + "-" + e.getMessage());
    }
    /**
     * {@inheritDoc}
     * @param e error exception.
     */
    @Override
    public void error(final SAXParseException e) {
        LOGGER.error(getLineAddress(e) + " - " + e.getMessage());
    }
    /**
     * {@inheritDoc}
     * @param e fatal exception.
     */
    @Override
    public void fatalError(final SAXParseException e) {
        LOGGER.fatal(getLineAddress(e) + " - " + e.getMessage());
    }

    /**
     * Method for getting line address.
     * @param e for exception.
     * @return string with line address data.
     */
    private String getLineAddress(final SAXParseException e) {
        return e.getLineNumber() + " : " + e.getColumnNumber();
    }
}
