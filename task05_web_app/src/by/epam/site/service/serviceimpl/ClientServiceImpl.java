package by.epam.site.service.serviceimpl;

import by.epam.site.dao.daointerfaces.ClientDAO;
import by.epam.site.entity.Client;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.ClientService;
import by.epam.site.servlet.ControllerServlet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class ClientServiceImpl extends ServiceImpl implements ClientService {

    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER =
            LogManager.getLogger(ClientServiceImpl.class);


    @Override
    public List<Client> findAll() throws ConstantException, SQLException, ClassNotFoundException {
        ClientDAO dao = transaction.createDaoImpl(ClientDAO.class);
        return dao.readAll();
    }

    @Override
    public void save(Client client) throws ConstantException {
        ClientDAO dao = transaction.createDaoImpl(ClientDAO.class);
        try {
            if (client.getId() != null) {
                dao.update(client, transaction);
            } else {
                client.setId(dao.create(client, transaction));
            }
        } catch (ConstantException | SQLException | ClassNotFoundException e) {
            LOGGER.error("It is impossible to turn off " +
                    "autocommiting for database connection", e);
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
