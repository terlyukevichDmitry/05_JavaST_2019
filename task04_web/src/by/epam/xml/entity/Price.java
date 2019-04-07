package by.epam.xml.entity;

import java.math.BigDecimal;

/**
 * <p>Java class for Price complex type.
 * <p>The following schema fragment specifies the expected
 * content contained within this class.
 * <pre>
 * &lt;complexType name="Price">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>decimal">
 *       &lt;attribute name="currency" type="{
 *       http://www.training.by/vouchers}Currency" default="EUR" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 */
public class Price {
    /**
     * Price value.
     */
    private BigDecimal value;
    /**
     * Enum value.
     */
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
     * @param valueT
     *     allowed object is
     *     {@link BigDecimal }
     */
    public void setValue(final BigDecimal valueT) {
        this.value = valueT;
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
     * @param valueT
     *     allowed object is
     *     {@link Currency }
     */
    public void setCurrency(final Currency valueT) {
        this.currency = valueT;
    }
    /**
     * {@inheritDoc}
     * @return string.
     */
    @Override
    public String toString() {
        return "Price{" + "value=" + value + ", currency=" + currency + '}';
    }
}
