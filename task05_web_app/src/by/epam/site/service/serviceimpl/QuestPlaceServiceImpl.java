package by.epam.site.service.serviceimpl;

import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.dao.daointerfaces.QuestPlaceDAO;
import by.epam.site.entity.QuestPlace;
import by.epam.site.entity.User;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.*;
import by.epam.site.servlet.ControllerServlet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class QuestPlaceServiceImpl
        extends ServiceImpl implements QuestPlaceService {
    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER =
            LogManager.getLogger(QuestPlaceServiceImpl.class);
    @Override
    public List<QuestPlace> findAll() throws ConstantException,
            SQLException, ClassNotFoundException {
        QuestPlaceDAO dao = transaction.createDaoImpl(QuestPlaceDAO.class);
        return dao.readAll();
    }

    @Override
    public void save(QuestPlace questPlace) throws ConstantException {
        QuestPlaceDAO dao = transaction.createDaoImpl(QuestPlaceDAO.class);
        try {
            if (questPlace.getId() != null) {
                dao.update(questPlace, transaction);
            } else {
                questPlace.setId(dao.create(questPlace, transaction));
            }
        } catch (ConstantException | SQLException | ClassNotFoundException e) {

            LOGGER.error("It is impossible to be turn off "
                    + "autocommiting for our database connection", e);
        }
    }

    @Override
    public void delete(Integer id) throws ClassNotFoundException,
            ConstantException {
        QuestPlaceDAO dao = transaction.createDaoImpl(QuestPlaceDAO.class);
        dao.delete(id);
    }

    @Override
    public void initData(List<QuestPlace> questPlaces)
            throws ConstantException {
        for (QuestPlace element : questPlaces) {
            ServiceFactory factory = new ServiceFactoryImpl(
                    new SqlTransactionFactoryImpl());
            QuestService service = factory.getService(QuestService.class);
            service.read(element.getQuest());
            ImageService imageService
                    = factory.getService(ImageService.class);
            imageService.read(element.getImage());
        }
    }

    @Override
    public List<QuestPlace> findByName(final String title) throws ConstantException {
        QuestPlaceDAO dao = transaction.createDaoImpl(QuestPlaceDAO.class);
        List<QuestPlace> questPlaces = dao.read(title);
        initData(questPlaces);
        return questPlaces;
    }

    @Override
    public QuestPlace findById(final Integer id) throws ConstantException {
        QuestPlaceDAO dao = transaction.createDaoImpl(QuestPlaceDAO.class);
        return dao.read(id);
    }
}
