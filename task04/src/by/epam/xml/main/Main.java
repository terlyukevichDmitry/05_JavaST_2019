package by.epam.xml.main;

import by.epam.xml.dom.VouchersDOMBuilder;
import by.epam.xml.entity.Voucher;
import by.epam.xml.sax.VouchersSAXBuilder;
import by.epam.xml.stax.VouchersStAXBuilder;

import java.io.File;
import java.util.Set;

public class Main {
    /**
     * file direction.
     */
    private static final String FILE = "data" + File.separator + "vouchers.xml";

    public static void main(String[] args) {
        VouchersDOMBuilder domBuilder = new VouchersDOMBuilder();
        domBuilder.buildSetVouchers(FILE);
        Set<Voucher> vouchers = domBuilder.getVouchers();
        for (Voucher voucher : vouchers) {
            System.out.println(voucher);
        }

        VouchersStAXBuilder staxBuilder = new VouchersStAXBuilder();
        Set<Voucher> vouchers1 = staxBuilder.buildSetVouchers(FILE);
        for (Voucher v :vouchers1) {
            System.out.println(v);
        }

        VouchersSAXBuilder vouchersSAXBuilder = new VouchersSAXBuilder();
        vouchersSAXBuilder.buildSetStudents(FILE);
        Set<Voucher> vouchers2 = vouchersSAXBuilder.getVouchers();
        for (Voucher v :vouchers2) {
            System.out.println(v);
        }
    }
}
