package by.epam.xml.builder;

import by.epam.xml.entity.Voucher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.Set;

/**
 * This class we use for parsing xml file with SAX method.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class VouchersSAXBuilder extends AbstractVouchersBuilder {

    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER =
            LogManager.getLogger(VouchersSAXBuilder.class);
    /**
     * Set with voucher object of xml file.
     */
    private Set<Voucher> vouchers;
    /**
     * object for parsing xml file.
     */
    private VoucherHandler voucherHandler;
    /**
     * Xml reader is for reading data of xml file.
     */
    private XMLReader reader;
    /**
     * Constructor for initializing data.
     */
    public VouchersSAXBuilder() {
        voucherHandler = new VoucherHandler();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            reader = parser.getXMLReader();
            reader.setContentHandler(voucherHandler);
        } catch (org.xml.sax.SAXException e) {
            LOGGER.error("SAX parser mistake: " + e);
        } catch (ParserConfigurationException e) {
            LOGGER.error("We have exception: ", e);
        }
    }
    /**
     * {@inheritDoc}
     * @param fileName file which save xml direction.
     */
    @Override
    public void buildSetVouchers(final String fileName) {
        try {
            reader.parse(fileName);
        } catch (IOException e) {
            LOGGER.error("Mistake I/О thread: " + e);
        } catch (org.xml.sax.SAXException e) {
            LOGGER.error("We have exception: " + e);
        }
        vouchers = voucherHandler.getVouchers();
    }
    /**
     * {@inheritDoc}
     * @return getter for getting set with voucher object.
     */
    @Override
    public Set<Voucher> getVouchers() {
        return vouchers;
    }
}
