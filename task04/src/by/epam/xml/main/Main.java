package by.epam.xml.main;

import by.epam.xml.entity.Voucher;
import by.epam.xml.stax.VouchersStAXBuilder;

import java.io.File;
import java.util.Set;

public class Main {
    /**
     * file direction.
     */
    private static final String FILE = "data" + File.separator + "vouchers.xml";

    public static void main(String[] args) {
//        VouchersDOMBuilder domBuilder = new VouchersDOMBuilder();
//        domBuilder.buildSetVouchers(FILE);
//        Set<Voucher> vouchers = domBuilder.getVouchers();
//        for (Voucher voucher : vouchers) {
//            System.out.println(voucher);
//        }

        VouchersStAXBuilder staxBuilder = new VouchersStAXBuilder();
        Set<Voucher> vouchers = staxBuilder.buildSetVouchers(FILE);
        for (Voucher v :vouchers) {
            System.out.println(v);
        }

    }
}
