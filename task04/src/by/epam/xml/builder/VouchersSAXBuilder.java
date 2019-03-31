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

public class VouchersSAXBuilder extends AbstractVouchersBuilder {

    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER =
            LogManager.getLogger(VouchersSAXBuilder.class);

    private Set<Voucher> vouchers;

    private VoucherHandler voucherHandler;

    private XMLReader reader;

    public VouchersSAXBuilder(Set<Voucher> vouchers) {
        super(vouchers);
    }

    @Override
    public void buildSetVouchers(String fileName) {
        try {
            reader.parse(fileName);
        } catch (IOException e) {
            LOGGER.error("Mistake I/О thread: " + e);
        } catch (org.xml.sax.SAXException e) {
            LOGGER.error("We have exception: " + e);
        }
        vouchers = voucherHandler.getVouchers();
    }
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

    @Override
    public Set<Voucher> getVouchers() {
        return vouchers;
    }
}
