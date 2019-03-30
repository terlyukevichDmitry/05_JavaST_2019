package by.epam.xml.entity;

public enum VoucherEnum {
    VOUCHERS("vouchers"),
    VOUCHER("voucher"),
    TYPE("type"),
    NUMBERDAYS("numberDays"),
    TRANSPORT("transport"),
    STARS("stars"),
    NUTRITION("nutrition"),
    COUNTRY("country"),
    ROOM("room"),
    TV("TV"),
    WI_FI("WI_FI"),
    AIR_CONDITIONING("air_conditioning"),
    COST("cost"),
    DATA_START("data_start"),
    DATA_FINISH("data_finish"),
    CURRENCY("currency"),
    ID("id"),
    NUMBER_NIGHTS("numberNights"),
    HOTEL_CHARACTERISTICS("hotel_characteristics");

    private String value;
    VoucherEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}