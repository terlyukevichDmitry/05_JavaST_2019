//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.03.29 at 11:00:08 AM MSK 
//


package by.epam.xml.entity;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for Voucher complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Voucher">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.training.by/vouchers}VoucherTypes">
 *       &lt;sequence>
 *         &lt;element name="country" type="{http://www.training.by/vouchers}CountryInEnglishLanguage"/>
 *         &lt;element name="numberDays" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="transport" type="{http://www.training.by/vouchers}Transport"/>
 *         &lt;element name="hotel-characteristics" type="{http://www.training.by/vouchers}Characteristics"/>
 *         &lt;element name="cost" type="{http://www.training.by/vouchers}Price"/>
 *         &lt;element name="data-start" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="data-finish" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="numberNights" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" default="3" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Voucher", propOrder = {
    "country",
    "numberDays",
    "transport",
    "hotelCharacteristics",
    "cost",
    "dataStart",
    "dataFinish"
})
public class Voucher
    extends VoucherTypes
{

    @XmlElement(required = true)
    protected String country;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger numberDays;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Transport transport;
    @XmlElement(name = "hotel-characteristics", required = true)
    protected Characteristics hotelCharacteristics = new Characteristics();
    @XmlElement(required = true)
    protected Price cost;
    @XmlElement(name = "data-start", required = true)
    protected String dataStart;
    @XmlElement(name = "data-finish", required = true)
    protected String dataFinish;
    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "numberNights")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger numberNights;

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountry(String value) {
        this.country = value;
    }

    /**
     * Gets the value of the numberDays property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberDays() {
        return numberDays;
    }

    /**
     * Sets the value of the numberDays property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberDays(BigInteger value) {
        this.numberDays = value;
    }

    /**
     * Gets the value of the transport property.
     * 
     * @return
     *     possible object is
     *     {@link Transport }
     *     
     */
    public Transport getTransport() {
        return transport;
    }

    /**
     * Sets the value of the transport property.
     * 
     * @param value
     *     allowed object is
     *     {@link Transport }
     *     
     */
    public void setTransport(Transport value) {
        this.transport = value;
    }

    /**
     * Gets the value of the hotelCharacteristics property.
     * 
     * @return
     *     possible object is
     *     {@link Characteristics }
     *     
     */
    public Characteristics getHotelCharacteristics() {
        return hotelCharacteristics;
    }

    /**
     * Sets the value of the hotelCharacteristics property.
     * 
     * @param value
     *     allowed object is
     *     {@link Characteristics }
     *     
     */
    public void setHotelCharacteristics(Characteristics value) {
        this.hotelCharacteristics = value;
    }

    /**
     * Gets the value of the cost property.
     * 
     * @return
     *     possible object is
     *     {@link Price }
     *     
     */
    public Price getCost() {
        return cost;
    }

    /**
     * Sets the value of the cost property.
     * 
     * @param value
     *     allowed object is
     *     {@link Price }
     *     
     */
    public void setCost(Price value) {
        this.cost = value;
    }

    /**
     * Gets the value of the dataStart property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataStart() {
        return dataStart;
    }

    /**
     * Sets the value of the dataStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataStart(String value) {
        this.dataStart = value;
    }

    /**
     * Gets the value of the dataFinish property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataFinish() {
        return dataFinish;
    }

    /**
     * Sets the value of the dataFinish property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataFinish(String value) {
        this.dataFinish = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Sets the value of the numberNights property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberNights(BigInteger value) {
        this.numberNights = value;
    }

    @Override
    public String toString() {
        return "Voucher{" +
                "country='" + country + '\'' +
                ", numberDays=" + numberDays +
                ", transport=" + transport +
                ", hotelCharacteristics=" + hotelCharacteristics +
                ", cost=" + cost +
                ", dataStart='" + dataStart + '\'' +
                ", dataFinish='" + dataFinish + '\'' +
                ", id='" + id + '\'' +
                ", numberNights=" + numberNights +
                ", type='" + type + '\'' +
                '}';
    }
}
