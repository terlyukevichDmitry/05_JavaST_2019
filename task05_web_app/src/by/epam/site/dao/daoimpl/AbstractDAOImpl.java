package by.epam.site.dao.daoimpl;

import by.epam.site.dao.connection.ConnectionPool;
import by.epam.site.entity.Entity;
import by.epam.site.exception.ConstantException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractDAOImpl<T extends Entity> {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/quest_bd?"
            + "useUnicode=true&characterEncoding=UTF-8";
    private static final String DB_LOGIN = "quest_user";
    private static final String DB_PASSWORD = "quest_password";

    public abstract List<T> readAll()
            throws SQLException, ConstantException, ClassNotFoundException;
    public abstract void delete(Integer id)
            throws ConstantException, ClassNotFoundException;
    public abstract void create(T entity)
            throws ConstantException, ClassNotFoundException;
    public abstract T update(T entity)
            throws ConstantException, ClassNotFoundException;

    Connection getConnection() throws ConstantException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            connectionPool.init("com.mysql.jdbc.Driver",
                    DB_URL, DB_LOGIN, DB_PASSWORD, 3, 15,
                    100);
            return connectionPool.getConnection();
        } catch (ConstantException e) {
            throw new ConstantException();
        }
    }
}
