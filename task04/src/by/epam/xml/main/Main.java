package by.epam.xml.main;

import by.epam.xml.dom.VouchersDOMBuilder;
import by.epam.xml.entity.Voucher;
import by.epam.xml.sax.VouchersSAXBuilder;
import by.epam.xml.stax.VouchersStAXBuilder;
import by.epam.xml.validation.ValidatorSAX;

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
        staxBuilder.buildSetVouchers(FILE);
        Set<Voucher> vouchers1 = staxBuilder.getVouchers();
        for (Voucher v :vouchers1) {
            System.out.println(v);
        }

        VouchersSAXBuilder vouchersSAXBuilder = new VouchersSAXBuilder();
        vouchersSAXBuilder.buildSetVouchers(FILE);
        Set<Voucher> vouchers2 = vouchersSAXBuilder.getVouchers();
        for (Voucher v :vouchers2) {
            System.out.println(v);
        }
        String filename = "data" + File.separator + "vouchers.xml";
        String schemaName = "data" + File.separator + "vouchers.xsd";
        ValidatorSAX validatorSAX = new ValidatorSAX();
        validatorSAX.validatingSAX(filename, schemaName);

    }
}
