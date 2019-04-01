package by.epam.xml.entity;

/**
 * Enum with voucher elements.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public enum VoucherEnum {
    /**
     * VOUCHERS constant.
     */
    VOUCHERS("vouchers"),
    /**
     * VOUCHER constant.
     */
    VOUCHER("voucher"),
    /**
     * TYPE constant.
     */
    TYPE("type"),
    /**
     * NUMBERDAYS constant.
     */
    NUMBERDAYS("numberDays"),
    /**
     * TRANSPORT constant.
     */
    TRANSPORT("transport"),
    /**
     * STARS constant.
     */
    STARS("stars"),
    /**
     * NUTRITION constant.
     */
    NUTRITION("nutrition"),
    /**
     * COUNTRY constant.
     */
    COUNTRY("country"),
    /**
     * ROOM constant.
     */
    ROOM("room"),
    /**
     * TV constant.
     */
    TV("TV"),
    /**
     * WI_FI constant.
     */
    WI_FI("WI_FI"),
    /**
     * AIR_CONDITIONING constant.
     */
    AIR_CONDITIONING("air_conditioning"),
    /**
     * COST constant.
     */
    COST("cost"),
    /**
     * DATA_START constant.
     */
    DATA_START("data_start"),
    /**
     * DATA_FINISH constant.
     */
    DATA_FINISH("data_finish"),
    /**
     * CURRENCY constant.
     */
    CURRENCY("currency"),
    /**
     * ID constant.
     */
    ID("id"),
    /**
     * NUMBER_NIGHTS constant.
     */
    NUMBER_NIGHTS("numberNights"),
    /**
     * HOTEL_CHARACTERISTICS constant.
     */
    HOTEL_CHARACTERISTICS("hotel_characteristics");
    /**
     * for initializing data.
     */
    private String value;

    /**
     * Constructor.
     * @param valueT string with data.
     */
    VoucherEnum(final String valueT) {
        this.value = valueT;
    }
    /**
     * Getter for getting value with string data.
     * @return value.
     */
    public String getValue() {
        return value;
    }
}
