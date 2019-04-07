package by.epam.xml.entity;
/**
 * <p>Java class for Currency.
 * <p>The following schema fragment specifies the expected
 * content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Currency">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="EUR"/>
 *     &lt;enumeration value="RUB"/>
 *     &lt;enumeration value="BYN"/>
 *     &lt;enumeration value="USD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
public enum Currency {
    /**
     * EUR.
     */
    EUR,
    /**
     * RUB.
     */
    RUB,
    /**
     * BYN.
     */
    BYN,
    /**
     * USD.
     */
    USD;

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
    public static Currency fromValue(final String string) {
        return valueOf(string);
    }
}
