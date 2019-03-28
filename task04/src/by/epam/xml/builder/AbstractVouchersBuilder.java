package by.epam.xml.builder;

import by.epam.xml.entity.Voucher;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractVouchersBuilder {
    protected Set<Voucher> vouchers;
    public AbstractVouchersBuilder() {
        vouchers = new HashSet<Voucher>();
    }
    public AbstractVouchersBuilder(Set<Voucher> students) {
        this.vouchers = students;
    }
    public Set<Voucher> getVouchers() {
        return vouchers;
    }
    abstract public void buildSetVouchers(String fileName);
}
