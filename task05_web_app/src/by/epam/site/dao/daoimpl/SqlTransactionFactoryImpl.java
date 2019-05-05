package by.epam.site.dao.daoimpl;

import by.epam.site.dao.connection.ConnectionPool;
import by.epam.site.dao.transaction.SqlTransaction;
import by.epam.site.dao.transaction.SqlTransactionFactory;
import by.epam.site.exception.ConstantException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class SqlTransactionFactoryImpl implements SqlTransactionFactory {

    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER
            = LogManager.getLogger(ConstantException.class);

    private static final String DB_URL = "jdbc:mysql://localhost:3306/quest_bd?"
            + "useUnicode=true&characterEncoding=UTF-8";
    private static final String DB_LOGIN = "quest_user";
    private static final String DB_PASSWORD = "quest_password";

    public Connection connection;

    public SqlTransactionFactoryImpl()
            throws ConstantException {
        try {
            ConnectionPool.getInstance().init("com.mysql.jdbc.Driver",
                    DB_URL, DB_LOGIN, DB_PASSWORD, 3, 15,
                    100);
        } catch (ConstantException e) {
            throw new ConstantException();
        }

        initConnection();
    }

    private void initConnection() throws ConstantException {
        connection = ConnectionPool.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
        } catch(SQLException e) {
            LOGGER.error("It is impossible to turn off " +
                    "autocommiting for database connection", e);
            throw new ConstantException(e);
        }
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch(SQLException ignored) {}
    }

    @Override
    public SqlTransaction createSqlTransaction() {
        return new SqlTransactionImpl(connection);
    }
}
