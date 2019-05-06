package by.epam.site.service.serviceimpl;

import by.epam.site.dao.transaction.SqlTransaction;
import by.epam.site.service.interfaces.Service;

public class ServiceImpl implements Service {
    protected SqlTransaction transaction = null;

    public void setTransaction(SqlTransaction transaction) {
        this.transaction = transaction;
    }

    public SqlTransaction getTransaction() {
        return transaction;
    }
}
