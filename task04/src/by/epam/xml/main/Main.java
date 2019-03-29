package by.epam.xml.main;

import by.epam.xml.dom.VouchersDOMBuilder;

import java.io.File;

public class Main {
    /**
     * file direction.
     */
    private static final String FILE = "data" + File.separator + "vouchers.xml";

    public static void main(String[] args) {
        VouchersDOMBuilder domBuilder = new VouchersDOMBuilder();
        domBuilder.buildSetStudents(FILE);
        System.out.println(domBuilder.getVouchers());
    }
}
