package by.epam.xml.validation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class VoucherErrorHandler extends DefaultHandler {
    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER =
            LogManager.getLogger(VoucherErrorHandler.class);
    @Override
    public void warning(SAXParseException e) {
        LOGGER.warn(getLineAddress(e) + "-" + e.getMessage());
    }
    @Override
    public void error(SAXParseException e) {
        LOGGER.error(getLineAddress(e) + " - " + e.getMessage());
    }
    @Override
    public void fatalError(SAXParseException e) {
        LOGGER.fatal(getLineAddress(e) + " - " + e.getMessage());
    }
    private String getLineAddress(SAXParseException e) {
        return e.getLineNumber() + " : " + e.getColumnNumber();
    }
}
