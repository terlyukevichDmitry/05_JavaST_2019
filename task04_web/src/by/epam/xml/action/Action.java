package by.epam.xml.action;

import by.epam.xml.builder.VouchersDOMBuilder;
import by.epam.xml.entity.Voucher;

import java.io.File;
import java.util.Set;

public class Action {
    /**
     * file direction.
     */
    private static final String FILE = "data" + File.separator + "vouchers.xml";
    private static final String fi = "C:\\05_JavaST_2019\\task04_web\\data\\vouchers.xml";

    public String getDOMParserText() {
        VouchersDOMBuilder builder = new VouchersDOMBuilder();
        builder.buildSetVouchers(fi);
        Set<Voucher> vouchers = builder.getVouchers();
        return vouchers.toString();
    }
}
