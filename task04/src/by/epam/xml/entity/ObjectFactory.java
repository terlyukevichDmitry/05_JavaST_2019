//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.03.29 at 11:00:08 AM MSK 
//


package by.epam.xml.entity;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the entity package.
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Voucher_QNAME = new QName("http://www.training.by/vouchers", "voucher");
    private final static QName _AllVouchers_QNAME = new QName("http://www.training.by/vouchers", "AllVouchers");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: entity
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Voucher }
     * 
     */
    public Voucher createVoucher() {
        return new Voucher();
    }

    /**
     * Create an instance of {@link VoucherTypes }
     * 
     */
    public VoucherTypes createVoucherTypes() {
        return new VoucherTypes();
    }

    /**
     * Create an instance of {@link Vouchers }
     * 
     */
    public Vouchers createVouchers() {
        return new Vouchers();
    }

    /**
     * Create an instance of {@link Characteristics }
     * 
     */
    public Characteristics createCharacteristics() {
        return new Characteristics();
    }

    /**
     * Create an instance of {@link Price }
     * 
     */
    public Price createPrice() {
        return new Price();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Voucher }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.training.by/vouchers", name = "voucher", substitutionHeadNamespace = "http://www.training.by/vouchers", substitutionHeadName = "AllVouchers")
    public JAXBElement<Voucher> createVoucher(Voucher value) {
        return new JAXBElement<Voucher>(_Voucher_QNAME, Voucher.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VoucherTypes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.training.by/vouchers", name = "AllVouchers")
    public JAXBElement<VoucherTypes> createAllVouchers(VoucherTypes value) {
        return new JAXBElement<VoucherTypes>(_AllVouchers_QNAME, VoucherTypes.class, null, value);
    }

}