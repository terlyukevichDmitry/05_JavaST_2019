package by.epam.site.dao.daoimpl;

import by.epam.site.dao.interfaces.*;
import by.epam.site.dao.transaction.SqlTransaction;
import by.epam.site.exception.ConstantException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SqlTransactionImpl implements SqlTransaction {
    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER
            = LogManager.getLogger(ConstantException.class);


    private static Map<Class<? extends DaoPattern<?>>,Class<? extends
            AbstractDAOImpl>> mapContainer = new ConcurrentHashMap<>();
    static {
        mapContainer.put(UserDAO.class, UserDAOImpl.class);
        mapContainer.put(ClientDAO.class, ClientDAOImpl.class);
        mapContainer.put(QuestDAO.class, QuestDAOImpl.class);
        mapContainer.put(ReviewDAO.class, ReviewDAOImpl.class);
        mapContainer.put(ImageDAO.class, ImageDAOImpl.class);
    }
    private Connection connection;

    public SqlTransactionImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public <Type extends DaoPattern<?>> Type createDaoImpl(Class<Type> key) {
        Class<? extends AbstractDAOImpl> value = mapContainer.get(key);
        if(value != null) {
            try {
                AbstractDAOImpl dao = value.newInstance();
                dao.setConnection(connection);
                return (Type)dao;
            } catch(InstantiationException | IllegalAccessException e) {
                LOGGER.error("It is impossible to create data access object", e);

            }
        }
        return null;
    }

    @Override
    public void commit() throws ConstantException {
        try {
            connection.commit();
        } catch(SQLException e) {
            LOGGER.error("It is impossible to commit transaction", e);
            throw new ConstantException(e);
        }
    }

    @Override
    public void rollback() throws ConstantException {
        try {
            connection.rollback();
        } catch(SQLException e) {
            LOGGER.error("It is impossible to rollback transaction", e);
            throw new ConstantException(e);
        }
    }
}
