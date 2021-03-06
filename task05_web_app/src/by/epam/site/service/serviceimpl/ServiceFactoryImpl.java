package by.epam.site.service.serviceimpl;

import by.epam.site.dao.transaction.SqlTransaction;
import by.epam.site.dao.transaction.SqlTransactionFactory;
import by.epam.site.service.interfaces.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceFactoryImpl implements ServiceFactory {
    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER =
            LogManager.getLogger(ServiceFactoryImpl.class);

    private static final Map<Class<? extends Service>, Class<?
            extends ServiceImpl>> serviceContainer = new ConcurrentHashMap<>();

    static {
        serviceContainer.put(UserService.class, UserServiceImpl.class);
        serviceContainer.put(UsedQuestService.class,
                UsedQuestServiceImpl.class);
        serviceContainer.put(QuestPlaceService.class,
                QuestPlaceServiceImpl.class);
        serviceContainer.put(ImageService.class, ImageServiceImpl.class);
        serviceContainer.put(ClientService.class, ClientServiceImpl.class);
        serviceContainer.put(ReviewService.class, ReviewServiceImpl.class);
        serviceContainer.put(QuestService.class, QuestServiceImpl.class);
    }

    private SqlTransactionFactory factory;

    public ServiceFactoryImpl(SqlTransactionFactory factory) {
        this.factory = factory;
    }

    @Override
    public <Type extends Service> Type getService(Class<Type> key) {
        Class<? extends ServiceImpl> value = serviceContainer.get(key);
        if(value != null) {
            try {
                SqlTransaction transaction = factory.createSqlTransaction();
                ServiceImpl service = value.newInstance();
                service.setTransaction(transaction);
                return (Type) service;
            } catch (InstantiationException e) {
                LOGGER.error("InstantiationException", e);
            } catch (IllegalAccessException e) {
                LOGGER.error("IllegalAccessException", e);
            }
        }
        return null;
    }

    @Override
    public void close() {
        factory.close();
    }
}
