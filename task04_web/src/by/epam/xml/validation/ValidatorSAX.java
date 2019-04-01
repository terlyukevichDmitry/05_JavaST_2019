package by.epam.xml.validation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

/**
 * This class we use for validating xml file with SAX method.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class ValidatorSAX {
    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER =
            LogManager.getLogger(ValidatorSAX.class);

    /**
     * Method for validating data.
     * @param filename string.
     * @param schemaName string.
     */
    public void validatingSAX(final String filename,
                              final String schemaName) {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        try {
            Schema schema = factory.newSchema(new File(schemaName));
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setSchema(schema);
            SAXParser parser = spf.newSAXParser();
            parser.parse(filename, new VoucherErrorHandler());
            LOGGER.info(filename + " is valid");
        } catch (ParserConfigurationException e) {
            LOGGER.error(filename + " config error: " + e.getMessage());
        } catch (IOException e) {
            LOGGER.error("I/O error: " + e.getMessage());
        } catch (org.xml.sax.SAXException e) {
            LOGGER.error(filename + " SAX error: " + e.getMessage());
        }
    }
}
