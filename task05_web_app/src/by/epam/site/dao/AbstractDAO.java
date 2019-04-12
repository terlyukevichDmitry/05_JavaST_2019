package by.epam.site.dao;

import by.epam.site.entity.Entity;
import by.epam.site.entity.Role;
import by.epam.site.exception.ConstantException;

import java.sql.SQLException;
import java.util.List;

public interface AbstractDAO <T extends Entity> {
    List<T> readAll() throws SQLException, ConstantException;
    void delete(Integer id) throws ConstantException;
    void create(T entity) throws ConstantException;
    T update(T entity) throws ConstantException;
}
