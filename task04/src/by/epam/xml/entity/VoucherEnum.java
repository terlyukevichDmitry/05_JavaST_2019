package by.epam.xml.entity;

public enum VoucherEnum {
    VOUCHERS("vouchers"),
    VOUCHER("voucher"),
    TYPE("type"),
    COUNTRY("country"),
    NUMBERDAYS("numberDays"),
    TRANSPORT("transport"),
    HOTEL_CHARACTERISTICS("hotel-characteristics"),
    STARS("stars"),
    NUTRITION("nutrition"),
    ROOM("room"),
    TV("TV"),
    WI_FI("WI_FI"),
    AIR_CONDITIONING("air-conditioning"),
    COST("cost"),
    DATA_START("data-start"),
    DATA_FINISH("data-finish"),
    CURRENCY("currency"),
    ID("id"),
    NUMBER_NIGHTS("numberNights");

    private String value;
    VoucherEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

    public static VoucherEnum fromValue(String v) {
        for (VoucherEnum c: VoucherEnum.values()) {
            if (c.getValue().equalsIgnoreCase(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
