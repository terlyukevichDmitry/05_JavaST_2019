package by.epam.xml.entity;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Characteristics complex type.
 * <p>The following schema fragment specifies the expected content
 * contained within this class.
 * &lt;complexType name="Characteristics">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="stars"
 *         type="{http://www.training.by/vouchers}Stars"/>
 *         &lt;element name="nutrition"
 *         type="{http://www.training.by/vouchers}Nutrition"/>
 *         &lt;element name="room"
 *         type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="TV"
 *         type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="WI-FI"
 *         type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="air-conditioning"
 *         type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
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
    /**
     * stars element in characteristics xml place.
     */
    @XmlSchemaType(name = "positiveInteger")
    private int stars;
    /**
     * Nutrition element in characteristics xml place.
     */
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    private Nutrition nutrition;
    /**
     * BigInteger element in characteristics xml place.
     */
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    private BigInteger room;
    /**
     * boolean element in characteristics xml place.
     */
    @XmlElement(name = "TV")
    private boolean tv;
    /**
     * boolean element in characteristics xml place.
     */
    @XmlElement(name = "WI-FI")
    private boolean wifi;
    /**
     * boolean element in characteristics xml place.
     */
    @XmlElement(name = "air-conditioning")
    private boolean airConditioning;

    /**
     * Gets the value of the stars property.
     * @return number of stars.
     */
    public int getStars() {
        return stars;
    }

    /**
     * Sets the value of the stars property.
     * @param value for init data.
     */
    public void setStars(final int value) {
        this.stars = value;
    }

    /**
     * Gets the value of the nutrition property.
     * @return
     *     possible object is
     *     {@link Nutrition }
     */
    public Nutrition getNutrition() {
        return nutrition;
    }

    /**
     * Sets the value of the nutrition property.
     * @param value
     *     allowed object is
     *     {@link Nutrition }
     */
    public void setNutrition(final Nutrition value) {
        this.nutrition = value;
    }

    /**
     * Gets the value of the room property.
     * @return
     *     possible object is
     *     {@link BigInteger }
     */
    public BigInteger getRoom() {
        return room;
    }

    /**
     * Sets the value of the room property.
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     */
    public void setRoom(final BigInteger value) {
        this.room = value;
    }

    /**
     * Gets the value of the tv property.
     * @return tv value.
     */
    public boolean isTV() {
        return tv;
    }

    /**
     * Sets the value of the tv property.
     * @param value for init data.
     */
    public void setTV(final boolean value) {
        this.tv = value;
    }

    /**
     * Gets the value of the wifi property.
     * @return wifi value.
     */
    public boolean isWIFI() {
        return wifi;
    }

    /**
     * Sets the value of the wifi property.
     * @param value for init data.
     */
    public void setWIFI(final boolean value) {
        this.wifi = value;
    }

    /**
     * Gets the value of the airConditioning property.
     * @return airConditioning value.
     */
    public boolean isAirConditioning() {
        return airConditioning;
    }

    /**
     * Sets the value of the airConditioning property.
     * @param value for init data.
     */
    public void setAirConditioning(final boolean value) {
        this.airConditioning = value;
    }

    /**
     * {@inheritDoc}
     * Method for getting string.
     * @return string.
     */
    @Override
    public String toString() {
        return "Characteristics{"
                + "stars=" + stars + ", nutrition=" + nutrition + ", room="
                + room + ", tv=" + tv + ", wifi=" + wifi
                + ", airConditioning=" + airConditioning + '}';
    }
}
