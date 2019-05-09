package by.epam.site.service.serviceimpl;

import by.epam.site.dao.daointerfaces.ClientDAO;
import by.epam.site.entity.Client;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.ClientService;

import java.sql.SQLException;
import java.util.List;

public class ClientServiceImpl extends ServiceImpl implements ClientService {
    @Override
    public List<Client> findAll() throws ConstantException, SQLException, ClassNotFoundException {
        ClientDAO dao = transaction.createDaoImpl(ClientDAO.class);
        return dao.readAll();
    }

    @Override
    public void save(Client client) throws ConstantException, ClassNotFoundException, SQLException {
        ClientDAO dao = transaction.createDaoImpl(ClientDAO.class);
        if(client.getId() != null) {
            dao.update(client, transaction);
        } else {
            client.setId(dao.create(client, transaction));
        }
    }

    @Override
    public void delete(Integer id) throws ClassNotFoundException, ConstantException {
        ClientDAO dao = transaction.createDaoImpl(ClientDAO.class);
        dao.delete(id);
    }

    @Override
    public Client findById(final Integer id) throws ConstantException {
        ClientDAO dao = transaction.createDaoImpl(ClientDAO.class);
        return dao.read(id);
    }
}
