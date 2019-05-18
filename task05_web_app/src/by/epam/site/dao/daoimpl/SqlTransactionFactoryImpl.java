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
            = LogManager.getLogger(SqlTransactionFactoryImpl.class);

    private static final String DB_URL = "jdbc:mysql://localhost:3306/quest_bd?"
            + "useUnicode=true&characterEncoding=UTF-8";
    private static final String DB_LOGIN = "quest_user";
    private static final String DB_PASSWORD = "quest_password";

    private Connection connection;

    public SqlTransactionFactoryImpl()
            throws ConstantException {
        try {
            ConnectionPool.getInstance().init("com.mysql.jdbc.Driver",
                    DB_URL, DB_LOGIN, DB_PASSWORD, 3, 15,
                    100);
        } catch (ConstantException e) {
            throw new ConstantException();
        }

        connection = ConnectionPool.getInstance().getConnection();
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            LOGGER.warn("SQLException exception");
        }
    }

        @Override
    public SqlTransaction createSqlTransaction() {
        return new SqlTransactionImpl(connection);
    }
}
