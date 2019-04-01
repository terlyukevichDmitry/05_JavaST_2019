package by.epam.xml.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for Transport.
 * <p>The following schema fragment specifies the expected content
 * contained within this class.
 * &lt;simpleType name="Transport">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="plane"/>
 *     &lt;enumeration value="car"/>
 *     &lt;enumeration value="bus"/>
 *     &lt;enumeration value="train"/>
 *     &lt;enumeration value="ship"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 */
@XmlType(name = "Transport")
@XmlEnum
public enum Transport {
    /**
     * PLANE constant.
     */
    @XmlEnumValue("plane")
    PLANE("plane"),
    /**
     * CAR constant.
     */
    @XmlEnumValue("car")
    CAR("car"),
    /**
     * BUS constant.
     */
    @XmlEnumValue("bus")
    BUS("bus"),
    /**
     * TRAIN constant.
     */
    @XmlEnumValue("train")
    TRAIN("train"),
    /**
     * SHIP constant.
     */
    @XmlEnumValue("ship")
    SHIP("ship");
    /**
     * for initializing data.
     */
    private final String value;
    /**
     * Constructor for initializing data.
     * @param string for value.
     */
    Transport(final String string) {
        this.value = string;
    }
    /**
     * Method for get value.
     * @param string for get enum.
     * @return get enum.
     */
    public static Transport fromValue(final String string) {
        for (Transport c: Transport.values()) {
            if (c.value.equals(string)) {
                return c;
            }
        }
        throw new IllegalArgumentException(string);
    }
}
