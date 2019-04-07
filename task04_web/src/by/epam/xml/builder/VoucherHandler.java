package by.epam.xml.builder;

import by.epam.xml.datetime.DateTimeConverter;
import by.epam.xml.entity.VoucherEnum;
import by.epam.xml.entity.Transport;
import by.epam.xml.entity.Voucher;
import by.epam.xml.entity.Price;
import by.epam.xml.entity.Nutrition;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;


/**
 * This class we use for parsing xml file with SAX method.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class VoucherHandler extends DefaultHandler {
    /**
     * Set with voucher object of xml file.
     */
    private Set<Voucher> vouchers;
    /**
     * object for initializing object.
     */
    private Voucher current;
    /**
     * Enum for reading data.
     */
    private VoucherEnum currentEnum;
    /**
     * Enum set for reading object.
     */
    private EnumSet<VoucherEnum> withText;
    /**
     * Constructor for initializing data.
     */
    VoucherHandler() {
        vouchers = new HashSet<>();
        withText = EnumSet.range(VoucherEnum.TYPE, VoucherEnum.DATA_FINISH);
    }
    /**
     * @return getter for getting set with voucher object.
     */
    public Set<Voucher> getVouchers() {
        return vouchers;
    }
    /**
     * Method for reading data and creating object.
     * {@inheritDoc}
     * @param uri uri direction.
     * @param localName name.
     * @param qName with data elements.
     * @param attrs attributes for reading this.
     */
    @Override
    public void startElement(final String uri, final String localName,
                             final String qName, final Attributes attrs) {
        if (qName.equals("voucher")) {
            current = new Voucher();
            setAttributesVouches(attrs);
            } else {
            VoucherEnum temp = VoucherEnum.valueOf(qName.toUpperCase());
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }
    }
    /**
     * Set data.
     * @param attrs attributes for reading this.
     */
    private void setAttributesVouches(final Attributes attrs) {
        current.setId(attrs.getValue(0));
        current.setNumberNights(BigInteger.valueOf(
                Integer.parseInt(attrs.getValue(1))));
    }
    /**
     * {@inheritDoc}
     * Method for ending elements.
     * @param uri uri direction.
     * @param localName name.
     * @param qName with data elements.
     */
    @Override
    public void endElement(final String uri, final String localName,
                           final String qName) {
        if ("voucher".equals(qName)) {
            vouchers.add(current);
        }
    }

    /**
     * Method for creating object.
     * {@inheritDoc}
     * @param ch with data.
     * @param start start element.
     * @param length element.
     */
    @Override
    public void characters(final char[] ch, final int start,
                           final int length) {
        String string = new String(ch, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum) {
                case TYPE:
                    current.setType(string);
                    break;
                case NUMBERDAYS:
                    current.setNumberDays(BigInteger.valueOf(
                            Integer.parseInt(string)));
                    break;
                case TRANSPORT:
                    current.setTransport(Transport.fromValue(string));
                    break;
                case STARS:
                    current.getHotelCharacteristics().setStars(
                            Integer.parseInt(string));
                    break;
                case NUTRITION:
                    current.getHotelCharacteristics().setNutrition(
                            Nutrition.fromValue(string));
                    break;
                case ROOM:
                    current.getHotelCharacteristics().setRoom(
                            BigInteger.valueOf(
                            Integer.parseInt(string)));
                    break;
                case TV:
                    current.getHotelCharacteristics().setTV(
                            Boolean.parseBoolean(string));
                    break;
                case WI_FI:
                    current.getHotelCharacteristics().setWIFI(
                            Boolean.parseBoolean(string));
                    break;
                case AIR_CONDITIONING:
                    current.getHotelCharacteristics().setAirConditioning(
                            Boolean.parseBoolean(string));
                    break;
                case COUNTRY:
                    current.setCountry(string);
                    break;
                case COST:
                    current.setCost(getPrice(string));
                    break;
                case DATA_START:
                    current.setDataStart(
                            new DateTimeConverter().getDateTime(string));
                    break;
                case DATA_FINISH:
                    current.setDataFinish(
                            new DateTimeConverter().getDateTime(string));
                    break;
                    default: break;
            }
            currentEnum = null;
        }
    }

    /**
     * Method for creating price object for the next creating voucher object.
     * @param string for reading data.
     * @return price object.
     */
    private Price getPrice(final String string) {
        Price price = new Price();
        price.setValue(BigDecimal.valueOf(Integer.parseInt(string)));
        return price;
    }
}
