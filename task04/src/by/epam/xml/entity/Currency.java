package by.epam.xml.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for Currency.
 * <p>The following schema fragment specifies the expected content
 * contained within this class.
 * &lt;simpleType name="Currency">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="EUR"/>
 *     &lt;enumeration value="RUB"/>
 *     &lt;enumeration value="BYN"/>
 *     &lt;enumeration value="USD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 */
@XmlType(name = "Currency")
@XmlEnum
public enum Currency {
    /**
     * USD constant.
     */
    USD,
    /**
     * RUB constant.
     */
    RUB,
    /**
     * BYN constant.
     */
    BYN,
    /**
     * EUR constant.
     */
    EUR;
    /**
     * Getter for getting value with string data.
     * @return value.
     */
    public String value() {
        return name();
    }
    /**
     * Method for get value.
     * @param string for get enum.
     * @return get enum.
     */
    public static Currency fromValue(final String string) {
        for (Currency c: Currency.values()) {
            if (c.value().equalsIgnoreCase(string)) {
                return c;
            }
        }
        throw new IllegalArgumentException(string);
    }
}
