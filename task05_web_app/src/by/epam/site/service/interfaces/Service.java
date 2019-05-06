package by.epam.site.service.interfaces;

import by.epam.site.dao.transaction.SqlTransaction;

public interface Service {
    SqlTransaction getTransaction();
}
