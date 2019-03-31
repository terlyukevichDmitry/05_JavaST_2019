package by.epam.xml.builder;

import by.epam.xml.entity.*;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class VoucherHandler extends DefaultHandler {

    private Set<Voucher> vouchers;
    private Voucher current;
    private VoucherEnum currentEnum;
    private EnumSet<VoucherEnum> withText;

    VoucherHandler() {
        vouchers = new HashSet<>();
        withText = EnumSet.range(VoucherEnum.TYPE, VoucherEnum.DATA_FINISH);
    }
    public Set<Voucher> getVouchers() {
        return vouchers;
    }

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

    private void setAttributesVouches(final Attributes attrs) {
        current.setId(attrs.getValue(0));
        current.setNumberNights(BigInteger.valueOf(
                Integer.parseInt(attrs.getValue(1))));
    }

    @Override
    public void endElement(final String uri, final String localName,
                           final String qName) {
        if ("voucher".equals(qName)) {
            vouchers.add(current);
        }
    }

    @Override
    public void characters(final char[] ch, final int start,
                           final int length) {
        String s = new String(ch, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum) {
                case TYPE:
                    current.setType(s);
                    break;
                case NUMBERDAYS:
                    current.setNumberDays(BigInteger.valueOf(
                            Integer.parseInt(s)));
                    break;
                case TRANSPORT:
                    current.setTransport(Transport.fromValue(s));
                    break;
                case STARS:
                    current.getHotelCharacteristics().setStars(
                            Integer.parseInt(s));
                    break;
                case NUTRITION:
                    current.getHotelCharacteristics().setNutrition(
                            Nutrition.fromValue(s));
                    break;
                case ROOM:
                    current.getHotelCharacteristics().setRoom(
                            BigInteger.valueOf(
                            Integer.parseInt(s)));
                    break;
                case TV:
                    current.getHotelCharacteristics().setTV(
                            Boolean.parseBoolean(s));
                    break;
                case WI_FI:
                    current.getHotelCharacteristics().setWIFI(
                            Boolean.parseBoolean(s));
                    break;
                case AIR_CONDITIONING:
                    current.getHotelCharacteristics().setAirConditioning(
                            Boolean.parseBoolean(s));
                    break;
                case COUNTRY:
                    current.setCountry(s);
                    break;
                case COST:
                    current.setCost(getPrice(s));
                    break;
                case DATA_START:
                    current.setDataStart(s);
                    break;
                case DATA_FINISH:
                    current.setDataFinish(s);
                    break;
                    default: break;
            }
            currentEnum = null;
        }
    }

    private Price getPrice(final String s) {
        Price price = new Price();
        price.setValue(BigDecimal.valueOf(Integer.parseInt(s)));
        return price;
    }
}
