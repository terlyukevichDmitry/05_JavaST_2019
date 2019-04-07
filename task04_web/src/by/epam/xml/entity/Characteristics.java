package by.epam.xml.entity;

import java.math.BigInteger;

/**
 * <p>Java class for Characteristics complex type.
 * <p>The following schema fragment specifies the expected
 * content contained within this class.
 * <pre>
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
 *         &lt;element name="WI_FI"
 *         type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="air_conditioning"
 *         type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
public class Characteristics {
    /**
     * Number of stars.
     */
    private int stars;
    /**
     * Type of nutrition.
     */
    private Nutrition nutrition;
    /**
     * Number of room.
     */
    private BigInteger room;
    /**
     * Boolean result.
     */
    private boolean tv;
    /**
     * Boolean result.
     */
    private boolean wifi;
    /**
     * Boolean result.
     */
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
     * @param value for set number of stars.
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
     * Gets the value of the airConditioning property.
     * @return boolean value.
     */
    public boolean isAirConditioning() {
        return airConditioning;
    }

    /**
     * Sets the value of the airConditioning property.
     * @param value set air value.
     */
    public void setAirConditioning(final boolean value) {
        this.airConditioning = value;
    }
    /**
     * Gets the value of the tv property.
     * @return boolean value.
     */
    public boolean isTv() {
        return tv;
    }
    /**
     * Sets the value of the tv property.
     * @param value set tv value.
     */
    public void setTv(final boolean value) {
        this.tv = value;
    }
    /**
     * Gets the value of the wifi property.
     * @return boolean value.
     */
    public boolean isWifi() {
        return wifi;
    }
    /**
     * Sets the value of the wifi property.
     * @param value wifi value.
     */
    public void setWifi(final boolean value) {
        this.wifi = value;
    }

    /**
     * {@inheritDoc}
     * @return string.
     */
    @Override
    public String toString() {
        return "Characteristics{" + "stars=" + stars + ", nutrition="
                + nutrition + ", room=" + room + ", tv=" + tv
                + ", wifi=" + wifi + ", airConditioning=" + airConditioning
                + '}';
    }
}
