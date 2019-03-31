package by.epam.xml.entity;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for Price complex type.
 * <p>The following schema fragment specifies the expected content
 * contained within this class.
 * &lt;complexType name="Price">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>decimal">
 *       &lt;attribute name="currency"
 *       type="{http://www.training.by/vouchers}Currency" default="EUR" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Price", propOrder = {
    "value"
})
public class Price {
    /**
     * BigDecimal element in Price xml place.
     */
    @XmlValue
    private BigDecimal value;
    /**
     * Currency element in Price xml place.
     */
    @XmlAttribute(name = "currency")
    private Currency currency;

    /**
     * Gets the value of the value property.
     * @return
     *     possible object is
     *     {@link BigDecimal }
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * @param bigDecimal
     *     allowed object is
     *     {@link BigDecimal }
     */
    public void setValue(final BigDecimal bigDecimal) {
        this.value = bigDecimal;
    }

    /**
     * Gets the value of the currency property.
     * @return
     *     possible object is
     *     {@link Currency }
     */
    public Currency getCurrency() {
        if (currency == null) {
            return Currency.EUR;
        } else {
            return currency;
        }
    }

    /**
     * Sets the value of the currency property.
     * @param valueC
     *     allowed object is
     *     {@link Currency }
     */
    public void setCurrency(final Currency valueC) {
        this.currency = valueC;
    }
    /**
     * {@inheritDoc}
     * Method for getting string.
     * @return string.
     */
    @Override
    public String toString() {
        return "Price{" + "value=" + value + ", currency=" + currency + '}';
    }
}
