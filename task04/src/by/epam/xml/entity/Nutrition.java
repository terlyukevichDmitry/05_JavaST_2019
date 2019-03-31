package by.epam.xml.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for Nutrition.
 * <p>The following schema fragment specifies the expected
 * content contained within this class.
 * <p>
 * &lt;simpleType name="Nutrition">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BB"/>
 *     &lt;enumeration value="HB"/>
 *     &lt;enumeration value="AL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 */
@XmlType(name = "Nutrition")
@XmlEnum
public enum Nutrition {
    /**
     * BB constant.
     */
    BB,
    /**
     * HB constant.
     */
    HB,
    /**
     * AL constant.
     */
    AL;
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
    public static Nutrition fromValue(final String string) {
        for (Nutrition c: Nutrition.values()) {
            if (c.value().equalsIgnoreCase(string)) {
                return c;
            }
        }
        throw new IllegalArgumentException(string);
    }
}
