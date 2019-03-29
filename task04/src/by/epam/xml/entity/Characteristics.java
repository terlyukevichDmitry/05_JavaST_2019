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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Characteristics complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Characteristics">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="stars" type="{http://www.training.by/vouchers}Stars"/>
 *         &lt;element name="nutrition" type="{http://www.training.by/vouchers}Nutrition"/>
 *         &lt;element name="room" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="TV" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="WI-FI" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="air-conditioning" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Characteristics", propOrder = {
    "stars",
    "nutrition",
    "room",
    "tv",
    "wifi",
    "airConditioning"
})
public class Characteristics {

    @XmlSchemaType(name = "positiveInteger")
    protected int stars;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Nutrition nutrition;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger room;
    @XmlElement(name = "TV")
    protected boolean tv;
    @XmlElement(name = "WI-FI")
    protected boolean wifi;
    @XmlElement(name = "air-conditioning")
    protected boolean airConditioning;

    /**
     * Gets the value of the stars property.
     * 
     */
    public int getStars() {
        return stars;
    }

    /**
     * Sets the value of the stars property.
     * 
     */
    public void setStars(int value) {
        this.stars = value;
    }

    /**
     * Gets the value of the nutrition property.
     * 
     * @return
     *     possible object is
     *     {@link Nutrition }
     *     
     */
    public Nutrition getNutrition() {
        return nutrition;
    }

    /**
     * Sets the value of the nutrition property.
     * 
     * @param value
     *     allowed object is
     *     {@link Nutrition }
     *     
     */
    public void setNutrition(Nutrition value) {
        this.nutrition = value;
    }

    /**
     * Gets the value of the room property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRoom() {
        return room;
    }

    /**
     * Sets the value of the room property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRoom(BigInteger value) {
        this.room = value;
    }

    /**
     * Gets the value of the tv property.
     * 
     */
    public boolean isTV() {
        return tv;
    }

    /**
     * Sets the value of the tv property.
     * 
     */
    public void setTV(boolean value) {
        this.tv = value;
    }

    /**
     * Gets the value of the wifi property.
     * 
     */
    public boolean isWIFI() {
        return wifi;
    }

    /**
     * Sets the value of the wifi property.
     * 
     */
    public void setWIFI(boolean value) {
        this.wifi = value;
    }

    /**
     * Gets the value of the airConditioning property.
     * 
     */
    public boolean isAirConditioning() {
        return airConditioning;
    }

    /**
     * Sets the value of the airConditioning property.
     * 
     */
    public void setAirConditioning(boolean value) {
        this.airConditioning = value;
    }

    @Override
    public String toString() {
        return "Characteristics{" +
                "stars=" + stars +
                ", nutrition=" + nutrition +
                ", room=" + room +
                ", tv=" + tv +
                ", wifi=" + wifi +
                ", airConditioning=" + airConditioning +
                '}';
    }
}
