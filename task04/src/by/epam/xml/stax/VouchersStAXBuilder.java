package by.epam.xml.stax;

import by.epam.xml.entity.*;

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


public class VouchersStAXBuilder {

    private HashSet<Voucher> vouchers = new HashSet<>();
    private XMLInputFactory inputFactory;
    public VouchersStAXBuilder() {
        inputFactory = XMLInputFactory.newInstance();
    }


    public Set<Voucher> getVouchers() {
        return vouchers;
    }

    public Set<Voucher> buildSetVouchers(String fileName) {
        FileInputStream inputStream = null;
        XMLStreamReader reader;
        String name;
        try {
            inputStream = new FileInputStream(new File(fileName));
            reader = inputFactory.createXMLStreamReader(inputStream);

            // StAX parsing
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (VoucherEnum.valueOf(name.toUpperCase()) == VoucherEnum.VOUCHER) {
                        Voucher st = buildVoucher(reader);
                        vouchers.add(st);
                    }
                }
            }
        } catch (XMLStreamException ex) {
            System.err.println("StAX parsing error! " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            System.err.println("File " + fileName + " not found! " + ex);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.err.println("Impossible close file "+fileName+" : "+e);
            }
        }
        return vouchers;
    }

    private Voucher buildVoucher(XMLStreamReader reader) throws XMLStreamException {
        Voucher voucher = new Voucher();
        voucher.setId(reader.getAttributeValue(null, VoucherEnum.ID.getValue()));
        voucher.setNumberNights(BigInteger.valueOf(Integer.parseInt(
                reader.getAttributeValue(null,
                        VoucherEnum.NUMBER_NIGHTS.getValue()))));
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
                            Price price = new Price();
                            price.setCurrency(Currency.fromValue(
                                    reader.getAttributeValue(null,
                                            VoucherEnum.CURRENCY.getValue())));

                            price.setValue(BigDecimal.valueOf(
                                    Integer.parseInt(getXMLText(reader))));

                            voucher.setCost(price);
                            break;
                        case DATA_START:
                            voucher.setDataStart(getXMLText(reader));
                            break;
                        case DATA_FINISH:
                            voucher.setDataFinish(getXMLText(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (VoucherEnum.valueOf(name.toUpperCase()) ==
                            VoucherEnum.VOUCHER) {
                        return voucher;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Student");
    }

    private Characteristics getXMLCharacteristics(XMLStreamReader reader)
            throws XMLStreamException {
        Characteristics characteristics = new Characteristics();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
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
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (VoucherEnum.valueOf(name.toUpperCase()) ==
                            VoucherEnum.HOTEL_CHARACTERISTICS){
                        return characteristics;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Address");
    }
    private String getXMLText(XMLStreamReader reader)
            throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }

}
