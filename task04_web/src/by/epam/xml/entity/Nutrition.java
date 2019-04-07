package by.epam.xml.entity;

/**
 * <p>Java class for Nutrition.
 * <p>The following schema fragment specifies the expected
 * content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Nutrition">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BB"/>
 *     &lt;enumeration value="HB"/>
 *     &lt;enumeration value="AL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
public enum Nutrition {
    /**
     * Enum constant.
     */
    BB,
    /**
     * Enum constant.
     */
    HB,
    /**
     * Enum constant.
     */
    AL;
    /**
     * Method for get name.
     * @return name.
     */
    public String value() {
        return name();
    }
    /**
     * For get currency value.
     * @param string for return value.
     * @return enum value.
     */
    public static Nutrition fromValue(final String string) {
        return valueOf(string);
    }
}
