package by.epam.site.dao.transaction;

import by.epam.site.dao.daointerfaces.DaoPattern;
import by.epam.site.exception.ConstantException;

import java.sql.Connection;

public interface SqlTransaction {
    public Connection getConnection();
    <Type extends DaoPattern<?>> Type createDaoImpl(Class<Type> key);
    void commit() throws ConstantException;
    void rollback() throws ConstantException;
}
