package by.epam.xml.application;

import by.epam.xml.builder.VouchersDOMBuilder;
import by.epam.xml.builder.VouchersSAXBuilder;
import by.epam.xml.builder.VouchersStAXBuilder;
import by.epam.xml.entity.Voucher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Set;

public class HamletInternational {
    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER =
            LogManager.getLogger(HamletInternational.class);
    /**
     * file direction.
     */
    private static final String FILE = "data" + File.separator + "vouchers.xml";

    public static void main(String[ ] args) {
        Scanner scanner = new Scanner(System.in);
        LOGGER.info("Hello, choose the number between 1 and 3.");
        LOGGER.info( "1 — английский || 2 — белорусский || 3 — русский");

        int k = scanner.nextInt();
        String country;
        String language;
        switch (k) {
            case 1:
                country = "US";
                language = "en";
                break;
            case 2:
                country = "BY";
                language = "be";
                break;
            case 3:
                country = "RU";
                language = "ru";
                break;
                default:
                    country = "US";
                    language = "en";
        }

        Locale current = new Locale(language, country);
        ResourceBundle rb = ResourceBundle.getBundle("text", current);

        LOGGER.info(getStringOfProperties(rb, "chooseParser"));
        LOGGER.info(getStringOfProperties(rb, "parsersText"));

        Set<Voucher> vouchers = getVouchersOfDifferentMethods(scanner, rb);

        LOGGER.info(getStringOfProperties(rb, "result"));
        for (Voucher v : vouchers) {
            LOGGER.info(v.toString());
        }
    }

    private static Set<Voucher> getVouchersOfDifferentMethods(
            final Scanner scanner,
            final ResourceBundle rb) {
        int k = scanner.nextInt();
        Set<Voucher> vouchers = null;
        switch (k) {
            case 1:
                VouchersDOMBuilder domBuilder = new VouchersDOMBuilder();
                domBuilder.buildSetVouchers(FILE);
                vouchers = domBuilder.getVouchers();

                LOGGER.info(getStringOfProperties(rb,
                        "domParserText"));
                break;
            case 2:
                VouchersSAXBuilder vouchersSAXBuilder = new VouchersSAXBuilder();
                vouchersSAXBuilder.buildSetVouchers(FILE);
                vouchers = vouchersSAXBuilder.getVouchers();

                LOGGER.info(getStringOfProperties(rb,
                        "saxParserText"));
                break;
            case 3:
                VouchersStAXBuilder staxBuilder = new VouchersStAXBuilder();
                staxBuilder.buildSetVouchers(FILE);
                vouchers = staxBuilder.getVouchers();

                LOGGER.info(getStringOfProperties(rb,
                        "staxParserText"));
                break;
            default:
                VouchersDOMBuilder domBuilder1 = new VouchersDOMBuilder();
                domBuilder1.buildSetVouchers(FILE);
                vouchers = domBuilder1.getVouchers();

                LOGGER.info(getStringOfProperties(rb,
                        "domParserText"));
                break;
        }
        return vouchers;
    }

    private static String getStringOfProperties(final ResourceBundle rb,
                                         final String stringBundle) {
        return new String(rb.getString(stringBundle).getBytes(
                StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
    }
}
