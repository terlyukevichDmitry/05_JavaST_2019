package by.epam.site.dao.daointerfaces;

import by.epam.site.dao.transaction.SqlTransaction;
import by.epam.site.entity.Entity;
import by.epam.site.exception.ConstantException;

import java.sql.SQLException;
import java.util.List;

public interface DaoPattern<T extends Entity> {
    List<T> readAll()
            throws SQLException, ConstantException, ClassNotFoundException;
    void delete(Integer id)
            throws ConstantException, ClassNotFoundException;
    Integer create(T entity, SqlTransaction transaction)
            throws ConstantException, ClassNotFoundException, SQLException;
    T update(T entity, SqlTransaction transaction)
            throws ConstantException, ClassNotFoundException, SQLException;
}
