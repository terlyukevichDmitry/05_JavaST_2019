package by.epam.xml.entity;

/**
 * <p>Java class for Transport.
 * <p>The following schema fragment specifies the expected
 * content contained within this class.
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
 */
public enum Transport {
    /**
     * Enum constant.
     */
    PLANE("plane"),
    /**
     * Enum constant.
     */
    CAR("car"),
    /**
     * Enum constant.
     */
    BUS("bus"),
    /**
     * Enum constant.
     */
    TRAIN("train"),
    /**
     * Enum constant.
     */
    SHIP("ship");
    /**
     * value for initializing data.
     */
    private final String value;
    /**
     * Constructor for initializing enum value.
     * @param string string for initializing data.
     */
    Transport(final String string) {
        value = string;
    }

    /**
     * Getter for get value.
     * @return get string.
     */
    public String value() {
        return value;
    }
    /**
     * For get currency value.
     * @param string for return value.
     * @return enum value.
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
