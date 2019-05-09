package by.epam.site.service.interfaces;

import by.epam.site.entity.Client;
import by.epam.site.exception.ConstantException;

import java.sql.SQLException;
import java.util.List;

public interface ClientService extends Service {
    List<Client> findAll() throws ConstantException,
            SQLException, ClassNotFoundException;
    void save(Client user) throws ConstantException, ClassNotFoundException, SQLException;
    void delete(Integer id) throws ClassNotFoundException, ConstantException;
    Client findById(Integer id) throws ConstantException;
}
