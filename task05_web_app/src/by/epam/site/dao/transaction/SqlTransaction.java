package by.epam.site.dao.transaction;

import by.epam.site.dao.interfaces.DaoPattern;
import by.epam.site.exception.ConstantException;

public interface SqlTransaction {
    <Type extends DaoPattern<?>> Type createDaoImpl(Class<Type> key);
    void commit() throws ConstantException;
    void rollback() throws ConstantException;
}
