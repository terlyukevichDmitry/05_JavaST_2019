package by.epam.xml.builder;

import by.epam.xml.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
import java.io.File;


public class VouchersStAXBuilder extends AbstractVouchersBuilder {
    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER =
            LogManager.getLogger(VouchersStAXBuilder.class);

    private HashSet<Voucher> vouchers = new HashSet<>();
    private XMLInputFactory inputFactory;
    public VouchersStAXBuilder() {
        inputFactory = XMLInputFactory.newInstance();
    }

    public VouchersStAXBuilder(Set<Voucher> students) {
        super(students);
    }

    @Override
    public Set<Voucher> getVouchers() {
        return vouchers;
    }

    @Override
    public void buildSetVouchers(final String fileName) {
        XMLStreamReader reader;
        String name;
        try(FileInputStream inputStream
                    = new FileInputStream(new File(fileName))) {
            reader = inputFactory.createXMLStreamReader(inputStream);

            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (VoucherEnum.valueOf(name.toUpperCase())
                            == VoucherEnum.VOUCHER) {
                        Voucher st = buildVoucher(reader);
                        vouchers.add(st);
                    }
                }
            }
        } catch (XMLStreamException ex) {
            LOGGER.error("StAX parsing error! " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            LOGGER.error("File " + fileName + " not found! " + ex);
        } catch (IOException e) {
            LOGGER.error("Impossible close file " + fileName + " : " + e);
        }
    }

    private Voucher buildVoucher(final XMLStreamReader reader)
            throws XMLStreamException {
        Voucher voucher = new Voucher();
        setAttributes(voucher, reader);
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (VoucherEnum.valueOf(name.toUpperCase())) {
                        case TYPE:
                            voucher.setType(getXMLText(reader));
                            break;
                        case COUNTRY:
                            voucher.setCountry(getXMLText(reader));
                            break;
                        case NUMBERDAYS:
                            name = getXMLText(reader);
                            voucher.setNumberDays(BigInteger.valueOf(
                                    Integer.parseInt(name)));
                            break;
                        case TRANSPORT:
                            voucher.setTransport(Transport.fromValue(
                                    getXMLText(reader)));
                            break;
                        case HOTEL_CHARACTERISTICS:
                            Characteristics characteristics =
                                    getXMLCharacteristics(reader);
                            voucher.setHotelCharacteristics(characteristics);
                            break;
                        case COST:
                            voucher.setCost(getPrice(reader));
                            break;
                        case DATA_START:
                            voucher.setDataStart(getXMLText(reader));
                            break;
                        case DATA_FINISH:
                            voucher.setDataFinish(getXMLText(reader));
                            break;
                            default: break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (VoucherEnum.valueOf(name.toUpperCase()) ==
                            VoucherEnum.VOUCHER) {
                        return voucher;
                    }
                    break;
                    default: break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Student");
    }

    private Price getPrice(final XMLStreamReader reader)
            throws XMLStreamException {
        Price price = new Price();
        price.setCurrency(Currency.fromValue(
                reader.getAttributeValue(null,
                        VoucherEnum.CURRENCY.getValue())));
        price.setValue(BigDecimal.valueOf(
                Integer.parseInt(getXMLText(reader))));
        return price;
    }

    private void setAttributes(final Voucher voucher,
                               final XMLStreamReader reader) {
        voucher.setId(reader.getAttributeValue(null,
                VoucherEnum.ID.getValue()));
        voucher.setNumberNights(BigInteger.valueOf(Integer.parseInt(
                reader.getAttributeValue(null,
                        VoucherEnum.NUMBER_NIGHTS.getValue()))));
    }

    private Characteristics getXMLCharacteristics(final XMLStreamReader reader)
            throws XMLStreamException {
        Characteristics characteristics = new Characteristics();
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    String name = reader.getLocalName();
                    switch (VoucherEnum.valueOf(name.toUpperCase())) {
                        case STARS:
                            characteristics.setStars(Integer.parseInt(
                                    getXMLText(reader)));
                            break;
                        case NUTRITION:
                            characteristics.setNutrition(Nutrition.fromValue(
                                    getXMLText(reader)));
                            break;
                        case ROOM:
                            characteristics.setRoom(BigInteger.valueOf(
                                    Integer.parseInt(getXMLText(reader))));
                            break;
                        case TV:
                            characteristics.setTV(Boolean.parseBoolean(
                                    getXMLText(reader)));
                            break;
                        case WI_FI:
                            characteristics.setWIFI(Boolean.parseBoolean(
                                    getXMLText(reader)));
                            break;
                        case AIR_CONDITIONING:
                            characteristics.setAirConditioning(
                                    Boolean.parseBoolean(getXMLText(reader)));
                            break;
                            default: break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (VoucherEnum.valueOf(name.toUpperCase()) ==
                            VoucherEnum.HOTEL_CHARACTERISTICS){
                        return characteristics;
                    }
                    break;
                    default: break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Address");
    }
    private String getXMLText(final XMLStreamReader reader)
            throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }

}
