package by.epam.xml.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for VoucherTypes complex type.
 * <p>The following schema fragment specifies the expected content
 * contained within this class.
 * <pre>
 * &lt;complexType name="VoucherTypes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="type"
 *         type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VoucherTypes", propOrder = {
    "type"
})
@XmlSeeAlso({
    Voucher.class
})
public class VoucherTypes {
    /**
     * type element for Voucher object.
     */
    @XmlElement(required = true)
    private String type;

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
}
