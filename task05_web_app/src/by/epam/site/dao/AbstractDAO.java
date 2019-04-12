package by.epam.site.dao;

import by.epam.site.entity.Entity;
import by.epam.site.exception.ConstantException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractDAO <T extends Entity> {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/quest_bd?"
            + "useUnicode=true&characterEncoding=UTF-8";
    private static final String DB_LOGIN = "quest_user";
    private static final String DB_PASSWORD = "quest_password";

    public abstract List<T> readAll() throws SQLException, ConstantException;
    public abstract void delete(Integer id) throws ConstantException;
    public abstract void create(T entity) throws ConstantException;
    public abstract T update(T entity) throws ConstantException;

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL,
                DB_LOGIN, DB_PASSWORD);
    }
}
