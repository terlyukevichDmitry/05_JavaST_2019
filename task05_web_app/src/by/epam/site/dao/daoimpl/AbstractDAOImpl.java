package by.epam.site.dao.daoimpl;

import java.sql.Connection;

public abstract class AbstractDAOImpl {
    protected Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }
}
