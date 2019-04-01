package by.epam.xml.entity;

import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for anonymous complex type.
 * <p>The following schema fragment specifies the
 * expected content contained within this class.
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.training.by/vouchers}AllVouchers"
 *         maxOccurs="16"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "allVouchers"
})
@XmlRootElement(name = "vouchers")
public class Vouchers {
    /**
     * object.
     */
    @XmlElementRef(name = "AllVouchers", namespace
            = "http://www.training.by/vouchers", type = JAXBElement.class)
    private List<JAXBElement<? extends VoucherTypes>> allVouchers;
}
