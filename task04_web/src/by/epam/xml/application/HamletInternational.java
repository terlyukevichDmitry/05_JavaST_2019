package by.epam.xml.application;

import by.epam.xml.builder.AbstractVouchersBuilder;
import by.epam.xml.builder.VouchersDOMBuilder;
import by.epam.xml.builder.VouchersSAXBuilder;
import by.epam.xml.builder.VouchersStAXBuilder;
import by.epam.xml.entity.Voucher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Set;

/**
 * It is the main class in this application.
 * Main in this class have not bad application for parse xml file with
 * different methods.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public final class HamletInternational {
    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER =
            LogManager.getLogger(HamletInternational.class);
    /**
     * file direction.
     */
    private static final String FILE = "data" + File.separator + "vouchers.xml";
    /**
     * constant.
     */
    private static final int THREE = 3;

    /**
     * Constructor.
     */
    private HamletInternational() {
    }

    /**
     * Main method for stating application.
     * @param args array.
     */
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        LOGGER.info("Hello, choose the number between 1 and 3.");
        LOGGER.info("1-english, 2-belorussian, 3-russian");
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
            case THREE:
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

        Set<Voucher> vouchers = getVouchersOfDifferentMethods(scanner, rb);

        LOGGER.info(getStringOfProperties(rb, "result"));
        for (Voucher v : vouchers) {
            LOGGER.info(v.toString());
        }
    }

    /**
     * Method for set voucher calculated one of parser methods.
     * @param scanner for write number.
     * @param rb resource.
     * @return set with voucher objects.
     */
    private static Set<Voucher> getVouchersOfDifferentMethods(
            final Scanner scanner,
            final ResourceBundle rb) {
        int k = scanner.nextInt();
        Set<Voucher> vouchers = null;
        switch (k) {
            case 1:
                AbstractVouchersBuilder domBuilder = new VouchersDOMBuilder();
                domBuilder.buildSetVouchers(FILE);
                vouchers = domBuilder.getVouchers();

                LOGGER.info(getStringOfProperties(rb,
                        "domParserText"));
                break;
            case 2:
                AbstractVouchersBuilder vouchersSAXBuilder
                        = new VouchersSAXBuilder();
                vouchersSAXBuilder.buildSetVouchers(FILE);
                vouchers = vouchersSAXBuilder.getVouchers();

                LOGGER.info(getStringOfProperties(rb,
                        "saxParserText"));
                break;
            case THREE:
                AbstractVouchersBuilder staxBuilder = new VouchersStAXBuilder();
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

    /**
     * Method for getting str properties.
     * @param rb resource.
     * @param stringBundle str resource.
     * @return string.
     */
    private static String getStringOfProperties(final ResourceBundle rb,
                                         final String stringBundle) {
        return rb.getString(stringBundle);
    }
}
