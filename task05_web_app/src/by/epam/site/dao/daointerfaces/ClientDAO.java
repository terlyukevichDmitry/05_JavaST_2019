package by.epam.site.dao.daointerfaces;

import by.epam.site.entity.Client;
import by.epam.site.exception.ConstantException;

public interface ClientDAO extends DaoPattern<Client> {
    Client read(Integer id) throws ConstantException;
}
