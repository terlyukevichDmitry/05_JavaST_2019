package by.epam.xml.entity;

/**
 * <p>Java class for VoucherTypes complex type.
 * <p>The following schema fragment specifies the
 * expected content contained within this class.
 * <pre>
 * &lt;complexType name="VoucherTypes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="type" type="{
 *         http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
public class VoucherTypes {
    /**
     * String type for voucher types.
     */
    protected String type;

    /**
     * Gets the value of the type property.
     * @return
     *     possible object is
     *     {@link String }
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setType(final String value) {
        this.type = value;
    }
    /**
     * {@inheritDoc}
     * @return string.
     */
    @Override
    public String toString() {
        return "VoucherTypes{" + "type='" + type + '\'' + '}';
    }
}
