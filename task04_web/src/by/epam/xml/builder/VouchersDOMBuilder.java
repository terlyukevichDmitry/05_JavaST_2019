package by.epam.xml.builder;

import by.epam.xml.datetime.DateTimeConverter;
import by.epam.xml.entity.Characteristics;
import by.epam.xml.entity.Transport;
import by.epam.xml.entity.Voucher;
import by.epam.xml.entity.Currency;
import by.epam.xml.entity.Price;
import by.epam.xml.entity.Nutrition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * This class we use for parsing xml file with DOM method.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class VouchersDOMBuilder extends AbstractVouchersBuilder {
    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER =
            LogManager.getLogger(VouchersDOMBuilder.class);
    /**
     * DocumentBuilder object for reading data.
     */
    private DocumentBuilder documentBuilder;
    /**
     * Set with voucher object of xml file.
     */
    private Set<Voucher> vouchers;
    /**
     * Constructor for initializing data.
     */
    public VouchersDOMBuilder() {
        super();
        this.vouchers = new HashSet<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            LOGGER.error("We have exception", e);
        }
    }
    /**
     * Setter for setting data.
     * @param vouchersT set with voucher object.
     */
    public void setVouchers(final Set<Voucher> vouchersT) {
        this.vouchers = vouchersT;
    }
    /**
     * {@inheritDoc}
     * @return getter for getting set with voucher object.
     */
    @Override
    public Set<Voucher> getVouchers() {
        return vouchers;
    }
    /**
     * {@inheritDoc}
     * @param fileName file which save xml direction.
     */
    @Override
    public void buildSetVouchers(final String fileName) {
        Document doc;
        try {
            doc = documentBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            NodeList vouchersList = root.getElementsByTagName("voucher");
            for (int i = 0; i < vouchersList.getLength(); i++) {
                Element voucherElement = (Element) vouchersList.item(i);
                Voucher voucher = buildVoucher(voucherElement);
                vouchers.add(voucher);
            }
        } catch (IOException e) {
            LOGGER.error("File error or I/O error: " + e);
        } catch (org.xml.sax.SAXException e) {
            LOGGER.error("File error or SAX error: " + e);
        }
    }
    /**
     * Method for build voucher object with data of xml file.
     * @param voucherElement for reading data.
     * @return get voucher object.
     */
    private Voucher buildVoucher(final Element voucherElement) {
        Voucher voucher = new Voucher();
        voucher.setId(voucherElement.getAttribute("id"));
        voucher.setNumberNights(BigInteger.valueOf(Integer.valueOf(
                voucherElement.getAttribute("numberNights"))));
        voucher.setType(getElementTextContent(voucherElement,
                "type"));
        voucher.setCountry(getElementTextContent(voucherElement,
                "country"));
        voucher.setNumberDays(BigInteger.valueOf(Integer.valueOf(
                getElementTextContent(
                voucherElement, "numberDays"))));
        voucher.setTransport(Transport.fromValue(getElementTextContent(
                voucherElement, "transport")));
        voucher.setHotelCharacteristics(getCharacteristics(voucherElement));
        voucher.setCost(getPrice(voucherElement));

        DateTimeConverter dateTimeConverter = new DateTimeConverter();
        voucher.setDataStart(dateTimeConverter.getDataTime(
                getElementTextContent(voucherElement,
                        "data_start")));
        voucher.setDataFinish(dateTimeConverter.getDataTime(
                getElementTextContent(voucherElement,
                        "data_finish")));
        return voucher;
    }
    /**
     * Method for creating price object for the next creating voucher object.
     * @param voucherElement for creating object.
     * @return price object.
     */
    private Price getPrice(final Element voucherElement) {
        Price price = new Price();
        price.setValue(BigDecimal.valueOf(Integer.valueOf(
                getElementTextContent(voucherElement, "cost"))));
        price.setCurrency(Currency.fromValue(getCurrency(voucherElement)));
        return price;
    }
    /**
     * Method for initializing characteristics object.
     * @param voucherElement for reading data.
     * @return Characteristics object.
     */
    private Characteristics getCharacteristics(final Element voucherElement) {
        Characteristics characteristics = new Characteristics();
        characteristics.setStars(Integer.parseInt(
                getElementTextContent(voucherElement, "stars")));
        characteristics.setNutrition(Nutrition.fromValue(
                getElementTextContent(voucherElement,
                        "nutrition")));
        characteristics.setRoom(BigInteger.valueOf(
                Integer.valueOf(getElementTextContent(voucherElement,
                        "room"))));
        characteristics.setTV(Boolean.parseBoolean(
                getElementTextContent(voucherElement, "TV")));
        characteristics.setWIFI(Boolean.parseBoolean(getElementTextContent(
                voucherElement, "WI_FI")));
        characteristics.setAirConditioning(Boolean.parseBoolean(
                getElementTextContent(voucherElement,
                        "air_conditioning")));
        return characteristics;
    }

    /**
     * Getter for getting necessary element of xml file.
     * @param element object for reading data.
     * @param elementName string element.
     * @return textContent.
     */
    private static String getElementTextContent(final Element element,
                                                final String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        return node.getTextContent();
    }

    /**
     * Getter for getting element.
     * @param element object for reading data.
     * @return textContent.
     */
    private String getCurrency(final Element element) {
        return String.valueOf(element.getElementsByTagName("cost").item(
                0).getAttributes().item(0).getTextContent());
    }
}
