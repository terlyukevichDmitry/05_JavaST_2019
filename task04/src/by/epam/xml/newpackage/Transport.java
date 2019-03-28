//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.03.28 at 03:52:27 PM MSK 
//


package by.epam.xml.newpackage;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Transport.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Transport">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="plane"/>
 *     &lt;enumeration value="car"/>
 *     &lt;enumeration value="bus"/>
 *     &lt;enumeration value="train"/>
 *     &lt;enumeration value="ship"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Transport")
@XmlEnum
public enum Transport {

    @XmlEnumValue("plane")
    PLANE("plane"),
    @XmlEnumValue("car")
    CAR("car"),
    @XmlEnumValue("bus")
    BUS("bus"),
    @XmlEnumValue("train")
    TRAIN("train"),
    @XmlEnumValue("ship")
    SHIP("ship");
    private final String value;

    Transport(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Transport fromValue(String v) {
        for (Transport c: Transport.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
