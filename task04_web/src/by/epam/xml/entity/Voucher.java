package by.epam.xml.entity;

import java.math.BigInteger;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>Java class for Voucher complex type.
 * <p>The following schema fragment specifies the
 * expected content contained within this class.
 * <pre>
 * &lt;complexType name="Voucher">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.training.by/vouchers}VoucherTypes">
 *       &lt;sequence>
 *         &lt;element name="country" type="
 *         {http://www.training.by/vouchers}CountryInEnglishLanguage"/>
 *         &lt;element name="numberDays" type="
 *         {http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="transport" type="
 *         {http://www.training.by/vouchers}Transport"/>
 *         &lt;element name="hotel_characteristics"
 *         type="{http://www.training.by/vouchers}Characteristics"/>
 *         &lt;element name="cost" type="
 *         {http://www.training.by/vouchers}Price"/>
 *         &lt;element name="data_start"
 *         type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="data_finish"
 *         type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required"
 *       type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="numberNights"
 *       type="{http://www.w3.org/2001/XMLSchema}positiveInteger" default="3" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
public class Voucher extends VoucherTypes {
    /**
     * Country string value.
     */
    private String country;
    /**
     * int value.
     */
    private BigInteger numberDays;
    /**
     * Enum value.
     */
    private Transport transport;
    /**
     * Object for hotelCharacteristics.
     */
    private Characteristics hotelCharacteristics = new Characteristics();
    /**
     * Cost value witch consist of number of price and type of currency.
     */
    private Price cost;
    /**
     * for data start.
     */
    private XMLGregorianCalendar dataStart;
    /**
     * for data finish.
     */
    private XMLGregorianCalendar dataFinish;
    /**
     * id for id value.
     */
    private String id;
    /**
     * Int number nights.
     */
    private BigInteger numberNights;
    /**
     * Gets the value of the country property.
     * @return
     *     possible object is
     *     {@link String }
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setCountry(final String value) {
        this.country = value;
    }

    /**
     * Gets the value of the numberDays property.
     * @return
     *     possible object is
     *     {@link BigInteger }
     */
    public BigInteger getNumberDays() {
        return numberDays;
    }

    /**
     * Sets the value of the numberDays property.
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     */
    public void setNumberDays(final BigInteger value) {
        this.numberDays = value;
    }

    /**
     * Gets the value of the transport property.
     * @return
     *     possible object is
     *     {@link Transport }
     */
    public Transport getTransport() {
        return transport;
    }

    /**
     * Sets the value of the transport property.
     * @param value
     *     allowed object is
     *     {@link Transport }
     */
    public void setTransport(final Transport value) {
        this.transport = value;
    }

    /**
     * Gets the value of the hotelCharacteristics property.
     * @return
     *     possible object is
     *     {@link Characteristics }
     */
    public Characteristics getHotelCharacteristics() {
        return hotelCharacteristics;
    }

    /**
     * Sets the value of the hotelCharacteristics property.
     * @param value
     *     allowed object is
     *     {@link Characteristics }
     */
    public void setHotelCharacteristics(final Characteristics value) {
        this.hotelCharacteristics = value;
    }

    /**
     * Gets the value of the cost property.
     * @return
     *     possible object is
     *     {@link Price }
     */
    public Price getCost() {
        return cost;
    }

    /**
     * Sets the value of the cost property.
     * @param value
     *     allowed object is
     *     {@link Price }
     */
    public void setCost(final Price value) {
        this.cost = value;
    }

    /**
     * Gets the value of the dataStart property.
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getDataStart() {
        return dataStart;
    }

    /**
     * Sets the value of the dataStart property.
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     */
    public void setDataStart(final XMLGregorianCalendar value) {
        this.dataStart = value;
    }

    /**
     * Gets the value of the dataFinish property.
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getDataFinish() {
        return dataFinish;
    }

    /**
     * Sets the value of the dataFinish property.
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     */
    public void setDataFinish(final XMLGregorianCalendar value) {
        this.dataFinish = value;
    }

    /**
     * Gets the value of the id property.
     * @return
     *     possible object is
     *     {@link String }
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setId(final String value) {
        this.id = value;
    }

    /**
     * Gets the value of the numberNights property.
     * @return
     *     possible object is
     *     {@link BigInteger }
     */
    public BigInteger getNumberNights() {
        if (numberNights == null) {
            return BigInteger.valueOf(Integer.valueOf("3"));
        } else {
            return numberNights;
        }
    }

    /**
     * Sets the value of the numberNights property.
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     */
    public void setNumberNights(final BigInteger value) {
        this.numberNights = value;
    }
    /**
     * {@inheritDoc}
     * @return string.
     */
    @Override
    public String toString() {
        return "Voucher{"
                + "country='" + country + '\'' + ", numberDays=" + numberDays
                + ", transport=" + transport
                + ", hotelCharacteristics=" + hotelCharacteristics
                + ", cost=" + cost + ", dataStart=" + dataStart
                + ", dataFinish=" + dataFinish + ", id='" + id + '\''
                + ", numberNights=" + numberNights + ", type='" + type + '\''
                + '}';
    }
}
