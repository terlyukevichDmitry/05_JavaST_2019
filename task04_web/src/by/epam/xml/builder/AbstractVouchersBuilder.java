package by.epam.xml.builder;

import by.epam.xml.entity.Voucher;

import java.util.HashSet;
import java.util.Set;

/**
 * This abstract class we use for create builder patter and getting solution
 * from different parsers.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public abstract class AbstractVouchersBuilder {
    /**
     * Set for saving Voucher object with data of xml file.
     */
    private Set<Voucher> vouchers;
    /**
     * Constructor for initializing set without parameters.
     */
    AbstractVouchersBuilder() {
        vouchers = new HashSet<>();
    }

    /**
     * Constructor for initializing set with parameters.
     * @param students for initializing set.
     */
    AbstractVouchersBuilder(final Set<Voucher> students) {
        this.vouchers = students;
    }

    /**
     * For getting set with vouchers information.
     * @return voucher set.
     */
    public Set<Voucher> getVouchers() {
        return vouchers;
    }

    /**
     * Method for build set in different classes with different parse
     * realization.
     * @param fileName file which save xml direction.
     */
    public abstract void buildSetVouchers(String fileName);
}
